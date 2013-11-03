package Artikelverwaltung.domain;

import Externe.domain.Lieferant;
import java.util.Set;

public class Fahrrad extends Artikel {
	private Set<Fahrradtyp> typ;
	private Integer rahmengroesse;

	
	
	public Integer getRahmengroesse() {
		return rahmengroesse;
	}

	public void setRahmengroesse(Integer rahmengroesse) {
		this.rahmengroesse = rahmengroesse;
	}

	public Set<Fahrradtyp> getTyp() {
		return typ;
	}

	public void setTyp(Set<Fahrradtyp> typ) {
		this.typ = typ;
	}

	public Fahrrad(String name, String beschreibung, Double preis,
			Lieferant lieferant, Integer gewicht, Set<Fahrradtyp> typ,
			Integer rahmengroesse) {
		super(name, beschreibung, preis, lieferant, gewicht);
		this.typ = typ;
		this.rahmengroesse = rahmengroesse;
	}
	

}
