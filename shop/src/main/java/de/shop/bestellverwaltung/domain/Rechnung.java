package de.shop.bestellverwaltung.domain;

import de.shop.kundenverwaltung.domain.Adresse;

public class Rechnung {
	
	private String datum;
	private Bestellung bestellnummer;
	private Adresse rechnungsadresse;
	
	public Rechnung(String date, Bestellung bnr,
			Adresse rechnadr) {
		super();
		datum = date;
		bestellnummer = bnr;
		rechnungsadresse = rechnadr;
	}
	
	public String getDatum() {
		return datum;
	}

	public void setDatum(String date) {
		datum = date;
	}

	public Bestellung getBestellnummer() {
		return bestellnummer;
	}

	public void setBestellnummer(Bestellung bnr) {
		bestellnummer = bnr;
	}

	public Adresse getRechnungsadresse() {
		return rechnungsadresse;
	}

	public void setRechnungsadresse(Adresse rechnadr) {
		rechnungsadresse = rechnadr;
	}
}
