package de.shop.bestellverwaltung.domain;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import java.util.Date;

import de.shop.kundenverwaltung.domain.Adresse;

public class Rechnung {
	
	@NotNull (message = "{rechnung.datum.notNull}")
	private Date datum;
	
	@NotNull (message = "{rechnung.bestellnummer.notNull}")
	@Valid
	private Bestellung bestellnummer;
	
	@NotNull (message = "{rechnung.adresse.notNull")
	@Valid
	private Adresse rechnungsadresse;
	
	public Rechnung(Date date, Bestellung bnr,
			Adresse rechnadr) {
		super();
		datum = date == null ? null : (Date) date.clone();
		bestellnummer = bnr;
		rechnungsadresse = rechnadr;
	}
	
	public Date getDatum() {
		return datum == null ? null : (Date) datum.clone();
	}

	public void setDatum(Date date) {
		this.datum = date == null ? null : (Date) datum.clone(); 
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

	@Override
	public String toString() {
		return "Rechnung [datum=" + datum + ", bestellnummer=" + bestellnummer
				+ ", rechnungsadresse=" + rechnungsadresse + "]";
	}
}
