package Artikelverwaltung.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.net.URI;
import util.rest.UriHelper;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import util.Mock;
import Artikelverwaltung.domain.Artikel;

	
	@Path("/artikel")
	@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
	@Consumes
	public class ArtikelResource {
		@Context
		private UriInfo uriInfo;
		
		@Inject
		private UriHelper uriHelper;
		
		@GET
		@Path("{id:[1-9][0-9]*}")
		public Response findArtikelById(@PathParam("id") Long id) {
			// TODO Anwendungskern statt Mock, Verwendung von Locale
			// TODO findartikelbyid in mock hinzufügen 
			final Artikel artikel = Mock.findArtikelById(id);
			if (artikel == null) {
				throw new NotFoundException("Kein Artikel mit der ID " + id + " gefunden.");
			}
			
			
			// Link-Header setzen
			final Response response = Response.ok(artikel)
	                                          	.build();
			
			return response;
		}
		
		
		
		public URI getUriBestellung(Artikel artikel, UriInfo uriInfo) {
			return uriHelper.getUri(ArtikelResource.class, "findArtikelById", artikel.getId(), uriInfo);
		}
	}



