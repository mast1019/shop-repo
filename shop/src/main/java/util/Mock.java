package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Bestellverwaltung.domain.Bestellung;
import Bestellverwaltung.domain.Bankeinzug;
import Bestellverwaltung.domain.Kreditkarte;
import Bestellverwaltung.domain.Posten;
import Bestellverwaltung.domain.Versand;
import Bestellverwaltung.domain.Rechnung;
import Bestellverwaltung.domain.Zahlung;
import Kundenverwaltung.domain.Kunde;
import Kundenverwaltung.domain.Adresse;
import Artikelverwaltung.domain.Artikel;
import Artikelverwaltung.domain.Fahrrad;
import Artikelverwaltung.domain.Fahrradtyp;
import Artikelverwaltung.domain.Helm;
import Artikelverwaltung.domain.Katalog;
import Externe.domain.Lieferant;
import Externe.domain.Spediteur;


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
		
		
		final Adresse adresse = new Adresse();
		adresse.setPostleitzahl(12345);
		adresse.setStadt("Testort");
		adresse.setStraﬂe("Teststraﬂe");
		adresse.setHausnummer(22);
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
		final int anzahl = kunde.getId().intValue() % MAX_BESTELLUNGEN + 1;  // 1, 2, 3 oder 4 Bestellungen
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

	public static Artikel findArtikelById(Long id){
		if (id>MAX_ARTIKEL){
			return null;
		}
		final Artikel artikel = new Artikel();
		artikel.setId(id);
		artikel.setName("Test-Fahrrad");
		artikel.setBeschreibung("ein Fahrrad zum testen!");
		artikel.setPreis(200.00);
		artikel.setGewicht(12);
		
		final Lieferant lieferant=new Lieferant();
		lieferant.setId((long) 1);
		lieferant.setName("Lieferanten-Name");
		
		final Adresse adresse = new Adresse();
		adresse.setPostleitzahl(12345);
		adresse.setStadt("Testort");
		adresse.setStraﬂe("Teststraﬂe");
		adresse.setHausnummer(67);
		lieferant.setAnschrift(adresse);
		
		return artikel;
		
	}
	
	private Mock() { /**/ }
}
