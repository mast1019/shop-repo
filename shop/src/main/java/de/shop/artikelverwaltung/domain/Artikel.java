package de.shop.artikelverwaltung.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Artikel implements Serializable{	
	
	private static final long serialVersionUID = 4593393192027810187L;
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 32)
	@Pattern(regexp = "[A-ZÄÖÜ] [a-zäöüß]+")
	private String name;
	
	@NotNull
	@Size(min = 10, max = 150)
	private String beschreibung;
	
	@NotNull
	@DecimalMin("0")
	@DecimalMax("10000")
	private BigDecimal preis;
	
	@NotNull
	@DecimalMin("0.1")
	@DecimalMax("100")
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
		result = prime * result + ((gewicht == null) ? 0 : gewicht.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((preis == null) ? 0 : preis.hashCode());
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
		if (beschreibung == null)	{
			if (other.beschreibung != null)
				return false;
		} 
		else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (gewicht == null) {
			if (other.gewicht != null)
				return false;
		}
		else if (!gewicht.equals(other.gewicht))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} 
		else if (!name.equals(other.name))
			return false;
		if (preis == null) {
			if (other.preis != null)
				return false;
		} 
		else if (!preis.equals(other.preis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artikel [id=" + id + ", name=" + name + ", beschreibung="
				+ beschreibung + ", preis=" + preis + ", gewicht=" + gewicht + "]";
	}	
}
