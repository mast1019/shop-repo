package de.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.GregorianCalendar;
import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;

import org.jboss.logging.Logger;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.Adresse;
import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.kundenverwaltung.domain.Firmenkunde;
import de.shop.kundenverwaltung.domain.Privatkunde;
import de.shop.bestellverwaltung.domain.Posten;

public final class Mock {
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());

	private static final int MAX_ID = 99;
	private static final int MAX_KUNDEN = 8;
	private static final int MAX_BESTELLUNGEN = 4;
	private static final int MAX_ARTIKEL = 4;
	private static final int JAHR = 2001;
	private static final int MONAT = 0; // bei Calendar werden die Monate von 0 bis 11 gezaehlt!!
	private static final int TAG = 31;  // bei Calendar die Monatstage ab 1 gezaehlt

	public static AbstractKunde findKundeById(Long id) {
		if (id > MAX_ID) {
			return null;
		}
		final AbstractKunde kunde = Math.abs(id % 2) == 0 ? new Privatkunde() : new Firmenkunde();
		kunde.setId(id);
		kunde.setNachname("Nachname");
		kunde.setVorname("Vorname");
		kunde.setEmail("" + id + "@hska.de");
		final GregorianCalendar seitCal = new GregorianCalendar(JAHR, MONAT, TAG);
		final Date seit = seitCal.getTime();
		kunde.setErstellungsdatum(seit);
		
		final Adresse adresse = new Adresse();
		adresse.setPostleitzahl("01234");
		adresse.setStadt("Testort");
		adresse.setStrasse("Teststrasse");
		adresse.setHausnummer("22");
		adresse.setId(id + 1);
		kunde.setAdresse(adresse);
		
		return kunde;
	}

	public static List<AbstractKunde> findAllKunden() {
		final int anzahl = MAX_KUNDEN;
		final List<AbstractKunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final AbstractKunde kunde = findKundeById(Long.valueOf(i));
			kunden.add(kunde);			
		}
		return kunden;
	}

	public static List<AbstractKunde> findKundenByNachname(String nachname) {
		final int anzahl = nachname.length();
		final List<AbstractKunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final AbstractKunde kunde = findKundeById(Long.valueOf(i));
			kunde.setNachname(nachname);
			kunden.add(kunde);			
		}
		return kunden;
	}
	
	public static AbstractKunde findKundeByEmail(String email) {
		if (email.startsWith("x")) {
			return null;
		}
		
		final AbstractKunde kunde = Math.abs(email.length()) % 2 == 1 ? new Privatkunde() : new Firmenkunde();
		kunde.setId(Long.valueOf(email.length()));
		kunde.setNachname("Nachname");
		kunde.setEmail(email);
		final GregorianCalendar seitCal = new GregorianCalendar(JAHR, MONAT, TAG);
		final Date seit = seitCal.getTime();
		kunde.setErstellungsdatum(seit);
		
		final Adresse adresse = new Adresse();
		adresse.setPostleitzahl("12345");
		adresse.setStadt("Testort");
		adresse.setKunde(kunde);
		kunde.setAdresse(adresse);
		
		return kunde;
	}
	
	public static List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
		// Beziehungsgeflecht zwischen Kunde und Bestellungen aufbauen
		final int anzahl = kunde.getId().intValue() % MAX_BESTELLUNGEN + 1; 
		final List<Bestellung> bestellungen = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Bestellung bestellung = findBestellungById(Long.valueOf(i));
			bestellung.setKundenid(kunde);
			bestellungen.add(bestellung);			
		}
		kunde.setBestellungen(bestellungen);
		
		return bestellungen;
	}

	public static Bestellung findBestellungById(Long id) {
		if (id > MAX_ID) {
			return null;
		}

		final AbstractKunde kunde = findKundeById(id + 1);  // andere ID fuer den Kunden

		final Bestellung bestellung = new Bestellung();
		bestellung.setBestellnummer(id);
		bestellung.setAusgeliefert(false);
		// TODO bestellung.setPosten(bestellung.getPosten())
		final List<Posten> posten = bestellung.getPosten();
		bestellung.setPosten(posten);
		final BigDecimal gesamtpreis = bestellung.getGesamtpreis();
		bestellung.setGesamtpreis(gesamtpreis);
		bestellung.setKundenid(kunde);
		
		return bestellung;
	}

	public static <T extends AbstractKunde> T createKunde(T kunde) {
		// Neue IDs fuer Kunde und zugehoerige Adresse
		// Ein neuer Kunde hat auch keine Bestellungen
		final String nachname = kunde.getNachname();
		kunde.setNachname(nachname);
		final String vorname = kunde.getVorname();
		kunde.setVorname(vorname);
		kunde.setId(Long.valueOf(nachname.length()));
		final Adresse adresse = kunde.getAdresse();
		adresse.setKunde(kunde);
		kunde.setBestellungen(null);
		final String email = kunde.getEmail();
		kunde.setEmail(email);
		
		LOGGER.infof("Neuer Kunde: %s", kunde);
		return kunde;
	}

	public static void updateKunde(AbstractKunde kunde) {
		System.out.println("Aktualisierter Kunde: " + kunde);
	}
	
	public static void deleteKunde(Long kundeId) {
		System.out.println("Kunde mit ID=" + kundeId + " geloescht");
	}
	
	public static Artikel findArtikelById(Long id) {
		if (id > MAX_ARTIKEL) {
			return null;
		}
		
		final Artikel artikel = new Artikel();
		artikel.setId(id);
		artikel.setName("Testfahrrad");
		artikel.setBeschreibung("ein Fahrrad zum testen!");
		final BigDecimal preis = new BigDecimal(200.00);
		artikel.setPreis(preis);
		final BigDecimal gewicht = new BigDecimal(12);
		artikel.setGewicht(gewicht);
		
		
		return artikel;		
	}
	
	public static List<Artikel> findAllArtikel() {
		final int anzahl = MAX_ARTIKEL;
		final List<Artikel> artikel = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Artikel a = findArtikelById(Long.valueOf(i));
			artikel.add(a);
		}
		return artikel;
	}
	
	public static List<Artikel> findArtikelByName(String name) {
		final int anzahl = name.length();
		final List<Artikel> artikel = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Artikel a = findArtikelById(Long.valueOf(i));
			a.setName(name);
			artikel.add(a);
		}
		return artikel;
	}

	public static Artikel createArtikel(Artikel artikel) {
		final String name = artikel.getName();
		artikel.setName(name);
		artikel.setId(Long.valueOf(name.length()));
		final String beschreibung = artikel.getBeschreibung();
		artikel.setBeschreibung(beschreibung);
		final BigDecimal preis = artikel.getPreis();
		artikel.setPreis(preis);
		final BigDecimal gewicht = artikel.getGewicht();
		artikel.setGewicht(gewicht);
		System.out.println("Neuer artikel: " + artikel);
		return artikel;
	}
	
	public static List<Bestellung> findAllBestellungen() {
		final int anzahl = MAX_BESTELLUNGEN;
		final List<Bestellung> bestellungen = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Bestellung b = findBestellungById(Long.valueOf(i));
			bestellungen.add(b);
		}
		return bestellungen;
	}

	public static Bestellung createBestellung(Bestellung bestellung) {
		final Long bestellnummer = (long) 1;
		bestellung.setBestellnummer(bestellnummer);
		bestellung.setPosten(bestellung.getPosten());
		bestellung.setAusgeliefert(false);
		final BigDecimal gesamtpreis = bestellung.getGesamtpreis();
		bestellung.setGesamtpreis(gesamtpreis);
		final AbstractKunde kundenid = bestellung.getKundenid();
		bestellung.setKundenid(kundenid);
		
		System.out.println("Neue Bestellung: " + bestellung);	
		return bestellung;
	}
	
	public static Bestellung createBestellung(Bestellung bestellung, AbstractKunde kunde) {
		LOGGER.infof("Neue Bestellung: %s fuer Kunde: %s", bestellung, kunde);
		return bestellung;
	}
	
	public static void updateArtikel(Artikel artikel) {
		System.out.println("Aktualisierter Artikel: " + artikel);
	}
	
	public static void updateBestellung(Bestellung bestellung) {
		System.out.println("Aktualisierte Bestellung: " + bestellung);
	}

	private Mock() { /**/ }
}
