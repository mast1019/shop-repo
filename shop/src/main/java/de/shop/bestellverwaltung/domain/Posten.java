package de.shop.bestellverwaltung.domain;

import java.math.BigDecimal;

import de.shop.artikelverwaltung.domain.Artikel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.DecimalMin;

public class Posten {
	
	private Long id;
	
	@Valid
	@NotNull(message = "{posten.artikel.notNull}")
	private Artikel artikel;
	
	@Min(0)
	private Integer anzahl;
	
	@DecimalMin("0,0")
	private BigDecimal gesamtpreis;

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
	
	public BigDecimal getGesamtpreis() {
		gesamtpreis = artikel.getPreis() * anzahl;
		return gesamtpreis;
	}
	
	public void setGesamtpreis(BigDecimal gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	@Override
	public String toString() {
		return "Posten [id=" + id + ", artikel=" + artikel.toString() + ", anzahl="
				+ anzahl + ", gesamtpreis=" + gesamtpreis + "]";
	}
		
}
