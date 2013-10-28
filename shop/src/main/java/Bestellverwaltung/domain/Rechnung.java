package de.shop.bestellungsverwaltung.domain;

import java.util.Date;

import de.shop.kundenverwaltung.domain.Adresse;

public class Rechnung {
	
	private Date Datum;
	private Bestellung Bestellnummer;
	private Adresse Rechnungsadresse;
	
	
	public Rechnung(Date datum, Bestellung bestellnummer,
			Adresse rechnungsadresse) {
		super();
		Datum = datum;
		Bestellnummer = bestellnummer;
		Rechnungsadresse = rechnungsadresse;
	}
	
	public Date getDatum() {
		return Datum;
	}

	public void setDatum(Date datum) {
		Datum = datum;
	}

	public Bestellung getBestellnummer() {
		return Bestellnummer;
	}

	public void setBestellnummer(Bestellung bestellnummer) {
		Bestellnummer = bestellnummer;
	}

	public Adresse getRechnungsadresse() {
		return Rechnungsadresse;
	}

	public void setRechnungsadresse(Adresse rechnungsadresse) {
		Rechnungsadresse = rechnungsadresse;
	}

	
}
