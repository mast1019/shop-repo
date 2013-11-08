package de.shop.artikelverwaltung.domain;

import javax.xml.bind.annotation.XmlTransient;

import de.shop.externe.domain.Lieferant;

public class Artikel {	
	private Long id;
	private String name;
	private String beschreibung;
	private Double preis;
	private Integer gewicht;
	@XmlTransient
	private Lieferant lieferant;
	
	public Artikel(String name, String beschreibung, Double preis, Lieferant lieferant, Integer gewicht)	{
		super();
		this.setName(name);
		this.setBeschreibung(beschreibung);
		this.setPreis(preis);
		this.setLieferant(lieferant);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + ((gewicht == null) ? 0 : gewicht.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lieferant == null) ? 0 : lieferant.hashCode());
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
		else if (!id.equals(other.id))
			return false;
		if (lieferant == null) {
			if (other.lieferant != null)
				return false;
		} 
		else if (!lieferant.equals(other.lieferant))
			return false;
		if (name == null) {
			if (other.name != null)
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
				+ beschreibung + ", preis=" + preis + ", lieferant="
				+ lieferant + ", gewicht=" + gewicht + "]";
	}	
}
