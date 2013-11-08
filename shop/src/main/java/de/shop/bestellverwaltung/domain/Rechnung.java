package de.shop.bestellverwaltung.domain;

import java.util.Date;

import de.shop.kundenverwaltung.domain.Adresse;

public class Rechnung {
	
	private Date datum;
	private Bestellung bestellnummer;
	private Adresse rechnungsadresse;
	
	
	public Rechnung(Date date, Bestellung bnr,
			Adresse rechnadr) {
		super();
		datum = date;
		bestellnummer = bnr;
		rechnungsadresse = rechnadr;
	}
	
	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date date) {
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