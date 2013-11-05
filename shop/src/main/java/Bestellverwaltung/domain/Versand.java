package Bestellverwaltung.domain;

import Externe.domain.Spediteur;

import java.util.Date;

public class Versand {

	private Date versanddatum;
	private Spediteur spedition;

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

	public Versand(Spediteur spedition, Date versanddatum) {
		super();
		this.spedition = spedition;
		this.versanddatum = versanddatum;
	}
	
	@Override
	public String toString() {
		return "Versand:\n" + "Versanddatum = "	+ versanddatum + "\n"
				+ spedition.toString();
	}

}
