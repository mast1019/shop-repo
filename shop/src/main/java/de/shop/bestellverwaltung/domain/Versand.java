package de.shop.bestellverwaltung.domain;

import de.shop.externe.domain.Spediteur;

public class Versand {

	private String versanddatum;
	private Spediteur spedition;

	public Versand(Spediteur spedition, String versanddatum) {
		super();
		this.spedition = spedition;
		this.versanddatum = versanddatum;
	}
		
	public String getVersanddatum() {
		return versanddatum;
	}
	public void setVersanddatum(String versanddatum) {
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
