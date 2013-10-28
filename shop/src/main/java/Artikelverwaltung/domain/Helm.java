package de.shop.artikelverwaltung.domain;

import de.shop.extern.domain.Lieferant;

public class Helm extends Artikel {
	
	private Integer groesse;

	public Integer getGroesse() {
		return groesse;
	}

	public void setGroesse(Integer groesse) {
		this.groesse = groesse;
	}

	public Helm(String name, String beschreibung, Double preis,
			Lieferant lieferant, Integer gewicht, Integer groesse) {
		super(name, beschreibung, preis, lieferant, gewicht);
		this.groesse = groesse;
	}

	

}
