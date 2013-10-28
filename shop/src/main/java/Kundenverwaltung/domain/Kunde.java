package Kundenverwaltung.domain;

import java.util.Date;
import java.util.List;

import Bestellverwaltung.domain.Bestellung;

public class Kunde {
	
	public Long Id;
	public String Nachname;
	public String Vorname;
	public List<Bestellung> Bestellungen;
	public Adresse Adresse;
	public Date Erstellungsdatum;
	
	public Kunde(String nachname, String vorname,
			Kundenverwaltung.domain.Adresse adresse,
			Date erstellungsdatum) {
		super();
		Nachname = nachname;
		Vorname = vorname;
		Adresse = adresse;
		Erstellungsdatum = erstellungsdatum;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNachname() {
		return Nachname;
	}

	public void setNachname(String nachname) {
		Nachname = nachname;
	}

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		Vorname = vorname;
	}

	public List<Bestellung> getBestellungen() {
		return Bestellungen;
	}

	public void setBestellungen(List<Bestellung> bestellungen) {
		Bestellungen = bestellungen;
	}

	public Adresse getAdresse() {
		return Adresse;
	}

	public void setAdresse(Adresse adresse) {
		Adresse = adresse;
	}

	public Date getErstellungsdatum() {
		return Erstellungsdatum;
	}

	public void setErstellungsdatum(Date erstellungsdatum) {
		Erstellungsdatum = erstellungsdatum;
	}
	
}

