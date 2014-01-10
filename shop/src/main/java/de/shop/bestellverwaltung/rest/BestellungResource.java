package de.shop.bestellverwaltung.rest;

import static de.shop.bestellverwaltung.service.BestellungService.FetchType.NUR_BESTELLUNG;
import static de.shop.util.Constants.ADD_LINK;
import static de.shop.util.Constants.SELF_LINK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.MediaType.TEXT_XML;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.artikelverwaltung.rest.ArtikelResource;
import de.shop.artikelverwaltung.service.ArtikelService;
import de.shop.bestellverwaltung.domain.Posten;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.bestellverwaltung.service.BestellungService;
import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.kundenverwaltung.rest.KundeResource;
import de.shop.util.interceptor.Log;
import de.shop.util.rest.UriHelper;

@Path("/bestellungen")
@Produces({APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
@Consumes
@RequestScoped
@Transactional
@Log
public class BestellungResource {
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private BestellungService bs;
	
	@Inject
	private ArtikelService as;
	
	@Inject
	private ArtikelResource artikelResource;

	@Inject
	private KundeResource kundeResource;
	
	@Inject
	private UriHelper uriHelper;
	
	/**
	 * Mit der URL /bestellungen/{id} eine Bestellung ermitteln
	 * @param id ID der Bestellung
	 * @return Objekt mit Bestelldaten, falls die ID vorhanden ist
	 */
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findBestellungById(@PathParam("id") Long id) {
		final Bestellung bestellung = bs.findBestellungById(id, NUR_BESTELLUNG);

		// URIs innerhalb der gefundenen Bestellung anpassen
		setStructuralLinks(bestellung, uriInfo);
		
		// Link-Header setzen
		final Response response = Response.ok(bestellung)
                                          .links(getTransitionalLinks(bestellung, uriInfo))
                                          .build();
		return response;
	}
	
	public void setStructuralLinks(Bestellung bestellung, UriInfo uriInfo) {
		// URI fuer Kunde setzen
		final AbstractKunde kunde = bestellung.getKundenid();
		if (kunde != null) {
			final URI kundeUri = kundeResource.getUriKunde(bestellung.getKundenid(), uriInfo);
			bestellung.setKundeUri(kundeUri);
		}
		
		// URIs fuer Artikel in den Posten setzen
		final Collection<Posten> posten = bestellung.getPosten();
		if (posten != null && !posten.isEmpty()) {
			for (Posten bp : posten) {
				final URI artikelUri = artikelResource.getUriArtikel(bp.getArtikel(), uriInfo);
				bp.setArtikelUri(artikelUri);
			}
		}
	}
	
	public Link[] getTransitionalLinks(Bestellung bestellung, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriBestellung(bestellung, uriInfo))
                              .rel(SELF_LINK)
                              .build();
		final Link add = Link.fromUri(uriHelper.getUri(BestellungResource.class, uriInfo))
                             .rel(ADD_LINK)
                             .build();
		return new Link[] {self, add };
	}

	public URI getUriBestellung(Bestellung bestellung, UriInfo uriInfo) {
		return uriHelper.getUri(BestellungResource.class, "findBestellungById", bestellung.getBestellnummer(), uriInfo);
	}
	
	/**
	 * Mit der URL /bestellungen/{id}/lieferungen die Lieferung ermitteln
	 * zu einer bestimmten Bestellung ermitteln
	 * @param id ID der Bestellung
	 * @return Objekt mit Lieferdaten, falls die ID vorhanden ist
	 */
	@GET
	@Path("{id:[1-9][0-9]*}/lieferungen")
	public Response findLieferungenByBestellungId(@PathParam("id") Long id) {
		// Diese Methode ist bewusst NICHT implementiert, um zu zeigen,
		// wie man Methodensignaturen an der Schnittstelle fuer andere
		// Teammitglieder schon mal bereitstellt, indem einfach ein "Internal
		// Server Error (500)" produziert wird.
		// Die Kolleg/inn/en koennen nun weiterarbeiten, waehrend man selbst
		// gerade keine Zeit hat, weil andere Aufgaben Vorrang haben.
		
		// TODO findLieferungenByBestellungId noch nicht implementiert
		return Response.status(INTERNAL_SERVER_ERROR)
			       .entity("findLieferungenByBestellungId: NOT YET IMPLEMENTED")
			       .type(TEXT_PLAIN)
			       .build();
	}

	
	/**
	 * Mit der URL /bestellungen/{id}/kunde den Kunden einer Bestellung ermitteln
	 * @param id ID der Bestellung
	 * @return Objekt mit Kundendaten, falls die ID vorhanden ist
	 */
	@GET
	@Path("{id:[1-9][0-9]*}/kunde")
	public Response findKundeByBestellungId(@PathParam("id") Long id) {
		final AbstractKunde kunde = bs.findKundeById(id);
		kundeResource.setStructuralLinks(kunde, uriInfo);
		
		// Link Header setzen
		final Response response = Response.ok(kunde)
                                          .links(kundeResource.getTransitionalLinks(kunde, uriInfo))
                                          .build();
		return response;
	}

	
	/**
	 * Mit der URL /bestellungen eine neue Bestellung anlegen
	 * @param bestellung die neue Bestellung
	 * @return Objekt mit Bestelldaten, falls die ID vorhanden ist
	 */
	@POST
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	@Transactional
	public Response createBestellung(Bestellung bestellung) {
		// TODO eingeloggter Kunde wird durch die URI im Attribut "kundeUri" emuliert
		final String kundeUriStr = bestellung.getKundeUri().toString();
		int startPos = kundeUriStr.lastIndexOf('/') + 1;
		final String kundeIdStr = kundeUriStr.substring(startPos);
		Long kundeId = null;
		
		try {
			kundeId = Long.valueOf(kundeIdStr);
		}
		
		catch (NumberFormatException e) {
			kundeIdInvalid();
		}
		
		// IDs der (persistenten) Artikel ermitteln
		final List<Posten> posten = bestellung.getPosten();
		final List<Long> artikelIds = new ArrayList<>(posten.size());
		for (Posten bp : posten) {
			final URI artikelUri = bp.getArtikelUri();
			if (artikelUri == null) {
				continue;
			}
			final String artikelUriStr = artikelUri.toString();
			startPos = artikelUriStr.lastIndexOf('/') + 1;
			final String artikelIdStr = artikelUriStr.substring(startPos);
			Long artikelId = null;
			try {
				artikelId = Long.valueOf(artikelIdStr);
			}
			catch (NumberFormatException e) {
				// Ungueltige Artikel-ID: wird nicht beruecksichtigt
				continue;
			}
			artikelIds.add(artikelId);
		}
		
		if (artikelIds.isEmpty()) {
			// keine einzige Artikel-ID als gueltige Zahl
			return null;
		}

		final List<Artikel> gefundeneArtikel = new ArrayList<Artikel>();
		for (Long l : artikelIds) {
			gefundeneArtikel.add(as.findArtikelById(l));
		}

		int i = 0;
		final List<Posten> neuePosten = new ArrayList<Posten>(posten.size());
		for (Posten bp : posten) {
			// Artikel-ID der aktuellen Posten (s.o.):
			// artikelIds haben gleiche Reihenfolge wie Posten
			final long artikelId = artikelIds.get(i++);
			
			// Wurde der Artikel beim DB-Zugriff gefunden?
			for (Artikel artikel : gefundeneArtikel) {
				if (artikel.getId().longValue() == artikelId) {
					// Der Artikel wurde gefunden
					bp.setArtikel(artikel);
					neuePosten.add(bp);
					break;					
				}
			}
		}
		bestellung.setPosten(neuePosten);
		bestellung = bs.createBestellung(bestellung, kundeId);

		final URI bestellungUri = getUriBestellung(bestellung, uriInfo);
		return Response.created(bestellungUri).build();
	}
	
	/**
	 * @NotNull verletzen, um die entsprechende Meldung zu verursachen, weil die Kunde-Id ungueltig ist.
	 * @return null
	 */
	@NotNull(message = "{bestellung.kunde.id.invalid}")
	public Long kundeIdInvalid() {
		return null;
	}
}
