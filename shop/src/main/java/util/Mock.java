package util;

import java.util.ArrayList;
import java.util.List;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.bestellverwaltung.domain.Posten;
import de.shop.externe.domain.Lieferant;
import de.shop.kundenverwaltung.domain.Adresse;
import de.shop.kundenverwaltung.domain.Kunde;


public final class Mock {
	private static final int MAX_ID = 99;
	private static final int MAX_KUNDEN = 8;
	private static final int MAX_BESTELLUNGEN = 4;
	private static final int MAX_ARTIKEL = 4;

	public static Kunde findKundeById(Long id) {
		if (id > MAX_ID) {
			return null;
		}
		
		final Kunde kunde = new Kunde();
		kunde.setId(id);
		kunde.setNachname("Nachname" + id);
		kunde.setVorname("Vorname");
		
		final Adresse adresse = new Adresse();
		adresse.setPostleitzahl("01234");
		adresse.setStadt("Testort");
		adresse.setStrasse("Teststrasse");
		adresse.setHausnummer("22");
		
		kunde.setAdresse(adresse);
		
		return kunde;
	}

	public static List<Kunde> findAllKunden() {
		final int anzahl = MAX_KUNDEN;
		final List<Kunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Kunde kunde = findKundeById(Long.valueOf(i));
			kunden.add(kunde);			
		}
		return kunden;
	}

	public static List<Kunde> findKundenByNachname(String nachname) {
		final int anzahl = nachname.length();
		final List<Kunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Kunde kunde = findKundeById(Long.valueOf(i));
			kunde.setNachname(nachname);
			kunden.add(kunde);			
		}
		return kunden;
	}
	

	public static List<Bestellung> findBestellungenByKunde(Kunde kunde) {
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

		final Kunde kunde = findKundeById(id + 1);  // andere ID fuer den Kunden

		final Bestellung bestellung = new Bestellung();
		bestellung.setBestellnummer(id);
		bestellung.setAusgeliefert(false);
		bestellung.setGesamtpreis(200.5);
		bestellung.setKundenid(kunde);
		bestellung.setPosten(new ArrayList<Posten>());
		
		return bestellung;
	}


	public static Kunde createKunde(Kunde kunde) {
		// Neue IDs fuer Kunde und zugehoerige Adresse
		// Ein neuer Kunde hat auch keine Bestellungen
		final String nachname = kunde.getNachname();
		kunde.setNachname(nachname);
		final String vorname = kunde.getVorname();
		kunde.setVorname(vorname);
		kunde.setId(Long.valueOf(nachname.length()));
		final Adresse adresse = kunde.getAdresse();
		kunde.setAdresse(adresse);
		kunde.setBestellungen(null);
		
		System.out.println("Neuer Kunde: " + kunde);
		return kunde;
	}


	public static void updateKunde(Kunde kunde) {
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
		artikel.setName("Test-Fahrrad");
		artikel.setBeschreibung("ein Fahrrad zum testen!");
		artikel.setPreis(200.00);
		artikel.setGewicht(12);
		
		final Lieferant lieferant = new Lieferant();
		lieferant.setId((long) 1);
		lieferant.setName("Lieferanten-Name");
		

		
		artikel.setLieferant(lieferant);

		
		return artikel;
		
	}

	

	

	public static Artikel createArtikel(Artikel artikel) {
		final String name = artikel.getName();
		artikel.setName(name);
		artikel.setId(Long.valueOf(name.length()));
		final String beschreibung = artikel.getBeschreibung();
		artikel.setBeschreibung(beschreibung);
		final Double preis = artikel.getPreis();
		artikel.setPreis(preis);
		final Integer gewicht = artikel.getGewicht();
		artikel.setGewicht(gewicht);
		final Lieferant lieferant = artikel.getLieferant();
		artikel.setLieferant(lieferant);
		System.out.println("Neuer artikel: " + artikel);
		return artikel;
	}

	public static Bestellung createBestellung(Bestellung bestellung) {
		final Long bestellnummer = (long)1;
		bestellung.setBestellnummer(bestellnummer);
		bestellung.setPosten(null);
		bestellung.setGesamtpreis(0.0);
		bestellung.setAusgeliefert(false);
		final Kunde kundenid = bestellung.getKundenid();
		bestellung.setKundenid(kundenid);
		
		System.out.println("Neue Bestellung: " + bestellung);
		
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
