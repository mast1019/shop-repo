package de.shop.bestellverwaltung.domain;

import java.util.Date;

import de.shop.externe.domain.Spediteur;

public class Versand {

	private Date versanddatum;
	private Spediteur spedition;

	public Versand(Spediteur spedition, Date versanddatum) {
		super();
		this.spedition = spedition;
		this.versanddatum = versanddatum;
	}

		
	public Date getVersanddatum() {
		return versanddatum;
	}
	public void setVersanddatum(Date versanddatum) {
		this.versanddatum = versanddatum;
	}
	public Spediteur getSpedition() {
		return spedition;
	}
	public void setSpedition(Spediteur spedition) {
		this.spedition = spedition;
	}

	
	@Override
	public String toString() {
		return "Versand:\n" + "Versanddatum = "	+ versanddatum + "\n"
				+ spedition.toString();
	}

}