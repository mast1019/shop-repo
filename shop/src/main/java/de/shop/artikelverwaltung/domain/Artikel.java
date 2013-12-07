package de.shop.artikelverwaltung.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Artikel implements Serializable {	
	
	private static final long serialVersionUID = 4593393192027810187L;
	private Long id;
	
	@NotNull(message = "{artikel.name.notNull}")
	@Size(min = 2, max = 32, message = "{artikel.name.length}")
	@Pattern(regexp = "[A-ZÄÖÜ][a-zäöüß]+")
	private String name;
	
	@NotNull(message = "{artikel.beschreibung.notNull}")
	@Size(min = 10, max = 150, message = "{artikel.beschreibung.length}")
	private String beschreibung;
	
	@NotNull(message = "{artikel.preis.notNull}")
	@DecimalMin(value = "0", message = "{artikel.preis.min}")
	@DecimalMax(value = "10000", message = "{artikel.preis.max}") 
	private BigDecimal preis;
	
	@NotNull(message = "{artikel.gewicht.notNull}")
	@DecimalMin(value = "0.1", message = "{artikel.gewicht.min}")
	@DecimalMax(value = "100", message = "{artikel.gewicht.max}")
	private BigDecimal gewicht;

	
	public Artikel(String name, String beschreibung, BigDecimal preis, BigDecimal gewicht)	{
		super();
		this.setName(name);
		this.setBeschreibung(beschreibung);
		this.setPreis(preis);
		this.setGewicht(gewicht);
	}
	
	public Artikel() {	
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

	public BigDecimal getPreis() {
		return preis;
	}

	public void setPreis(BigDecimal preis) {
		this.preis = preis;
	}

	public BigDecimal getGewicht() {
		return gewicht;
	}

	public void setGewicht(BigDecimal gewicht) {
		this.gewicht = gewicht;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beschreibung == null) ? 0 : beschreibung.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Artikel other = (Artikel) obj;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		}
		else if (!beschreibung.equals(other.beschreibung))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artikel [id=" + id + ", name=" + name + ", beschreibung="
				+ beschreibung + ", preis=" + preis + ", gewicht=" + gewicht + "]";
	}	
}
