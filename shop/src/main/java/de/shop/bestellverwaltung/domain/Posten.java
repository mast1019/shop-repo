package de.shop.bestellverwaltung.domain;

import java.math.BigDecimal;
import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.shop.artikelverwaltung.domain.Artikel;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@XmlRootElement
public class Posten implements Serializable {
	private static final long serialVersionUID = -6546634107480260335L;

	public static final int ANZAHL_MIN = 1;
	
	private Long id;
	
	@Valid
	@NotNull(message = "{posten.artikel.notNull}")
	private Artikel artikel;
	
	@NotNull(message = "{posten.anzahl.notNull}")
	@Min(value=1, message = "{posten.anzahl.min}")	
	private Integer anzahl;
	
	@NotNull(message = "{posten.gesamtpreis.notNull}")
	@DecimalMin(value = "0.0", message = "{posten.gesamtpreis.decimalmin}")
	private BigDecimal gesamtpreis;
	
	private URI artikelUri;

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

	@XmlTransient
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
		final BigDecimal anz = new BigDecimal(anzahl);
		gesamtpreis = artikel.getPreis().multiply(anz);
		return gesamtpreis;
	}
	
	public void setGesamtpreis(BigDecimal gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}
	
	public URI getArtikelUri() {
		return artikelUri;
	}
	
	public void setArtikelUri(URI artikeluri) {
		this.artikelUri = artikeluri;
	}

	@Override
	public String toString() {
		return "Posten [id=" + id + ", artikel=" + artikel.toString() + ", anzahl="
				+ anzahl + ", gesamtpreis=" + gesamtpreis + "]";
	}
		
}
