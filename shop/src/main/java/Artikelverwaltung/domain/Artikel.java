package de.shop.artikelverwaltung.domain;

import de.shop.extern.domain.Lieferant;

public abstract class Artikel {
	
	private Long id;
	private String name;
	private String beschreibung;
	private Double preis;
	private Lieferant lieferant;
	private Integer gewicht;
	
	public Artikel(String name, String beschreibung, Double preis,
			Lieferant lieferant,Integer gewicht) {
		super();
		this.setName(name);
		this.setBeschreibung(beschreibung);
		this.setPreis(preis);
		this.setLieferant(lieferant);
		this.setGewicht(gewicht);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Double getPreis() {
		return preis;
	}

	public void setPreis(Double preis) {
		this.preis = preis;
	}

	public Lieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}

	public Integer getGewicht() {
		return gewicht;
	}

	public void setGewicht(Integer gewicht) {
		this.gewicht = gewicht;
	}
	
}
