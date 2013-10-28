package de.shop.artikelverwaltung.domain;

import de.shop.extern.domain.Lieferant;

public class Fahrrad extends Artikel {
	private Fahrradtyp typ;
	private Integer rahmengroesse;

	
	
	public Integer getRahmengroesse() {
		return rahmengroesse;
	}

	public void setRahmengroesse(Integer rahmengroesse) {
		this.rahmengroesse = rahmengroesse;
	}

	public Fahrradtyp getTyp() {
		return typ;
	}

	public void setTyp(Fahrradtyp typ) {
		this.typ = typ;
	}

	public Fahrrad(String name, String beschreibung, Double preis,
			Lieferant lieferant, Integer gewicht, Fahrradtyp typ,
			Integer rahmengroesse) {
		super(name, beschreibung, preis, lieferant, gewicht);
		this.typ = typ;
		this.rahmengroesse = rahmengroesse;
	}
	

}
