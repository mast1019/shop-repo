package de.shop.bestellverwaltung.domain;

import de.shop.artikelverwaltung.domain.Artikel;


public class Posten {
	
	private Long id;
	private Artikel artikel;
	private Integer anzahl;
	private Double gesamtpreis;

	public Posten(Long id, Artikel artikel, Integer anzahl) {
		super();
		this.id = id;
		this.artikel = artikel;
		this.anzahl = anzahl;
	}

	public Posten() {	
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artikel getArtikel() {
		return artikel;
	}
	
	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}
	
	public Integer getAnzahl() {
		return anzahl;
	}
	
	public void setAnzahl(Integer anzahl) {
		this.anzahl = anzahl;
	}
	
	public Double getGesamtpreis() {
		gesamtpreis = artikel.getPreis() * anzahl;
		return gesamtpreis;
	}
	
	public void setGesamtpreis(Double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	@Override
	public String toString() {
		return "Posten [id=" + id + ", artikel=" + artikel.toString() + ", anzahl="
				+ anzahl + ", gesamtpreis=" + gesamtpreis + "]";
	}
		
}
