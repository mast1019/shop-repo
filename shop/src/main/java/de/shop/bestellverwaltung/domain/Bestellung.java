package de.shop.bestellverwaltung.domain;

import java.util.List;
import java.math.BigDecimal;
import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.shop.kundenverwaltung.domain.AbstractKunde;

@XmlRootElement
public class Bestellung {
	
	private Long bestellnummer;
	
	@NotNull(message = "{bestellung.posten.notnull}")
	@Size(min = 1, message = "{bestellung.posten.size}")
	@Valid
	private List<Posten> posten;
	
	@NotNull(message = "{bestellung.gesamtpreis.notnull}")
	@DecimalMin(value = "0.0", message = "{bestellung.gesamtpreis.decimalmin}")
	private BigDecimal gesamtpreis;

	@Valid
	private AbstractKunde kundenid;
	
	@NotNull(message = "{bestellung.ausgeliegert.notnull}")
	private Boolean ausgeliefert;
	
	private URI kundeUri;
	
	
	
	public Long getBestellnummer() {
		return bestellnummer;
	}
	
	public void setBestellnummer(Long bestellnummer) {
		this.bestellnummer = bestellnummer;
	}

	public List<Posten> getPosten() {
		return posten;
	}
	
	public void setPosten(List<Posten> posten) {
		this.posten = posten;
	}
	
	public BigDecimal getGesamtpreis() {
		if (posten == null) {
			gesamtpreis = new BigDecimal(0.0);
		}
		else {
			for (Posten p : posten) {
				gesamtpreis.add(p.getGesamtpreis());
			}
		}
		return gesamtpreis;
	}
	
	public void setGesamtpreis(BigDecimal gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}
	
	@XmlTransient
	public AbstractKunde getKundenid() {
		return kundenid;
	}
	
	public void setKundenid(AbstractKunde kundenid) {
		this.kundenid = kundenid;
	}
	
	public Boolean getAusgeliefert() {
		return ausgeliefert;
	}
	
	public void setAusgeliefert(Boolean ausgeliefert) {
		this.ausgeliefert = ausgeliefert;
	}
	
	public URI getKundeUri() {
		return kundeUri;
	}
	
	public void setKundeUri(URI kundeUri) {
		this.kundeUri = kundeUri;
	}
	
	@Override
	public String toString() {
		return "Bestellung [bestellnummer=" + bestellnummer + ", posten="
				+ posten + ", gesamtpreis=" + gesamtpreis + ", kundenid="
				+ kundenid + ", ausgeliefert=" + ausgeliefert + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ausgeliefert == null) ? 0 : ausgeliefert.hashCode());
		result = prime * result
				+ ((bestellnummer == null) ? 0 : bestellnummer.hashCode());
		result = prime * result
				+ ((gesamtpreis == null) ? 0 : gesamtpreis.hashCode());
		result = prime * result
				+ ((kundeUri == null) ? 0 : kundeUri.hashCode());
		result = prime * result
				+ ((kundenid == null) ? 0 : kundenid.hashCode());
		result = prime * result + ((posten == null) ? 0 : posten.hashCode());
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
		final Bestellung other = (Bestellung) obj;
		if (ausgeliefert == null) {
			if (other.ausgeliefert != null)
				return false;
		}
		else if (!ausgeliefert.equals(other.ausgeliefert))
			return false;
		if (bestellnummer == null) {
			if (other.bestellnummer != null)
				return false;
		}
		else if (!bestellnummer.equals(other.bestellnummer))
			return false;
		if (gesamtpreis == null) {
			if (other.gesamtpreis != null)
				return false;
		}
		else if (!gesamtpreis.equals(other.gesamtpreis))
			return false;
		if (kundeUri == null) {
			if (other.kundeUri != null)
				return false;
		} 
		else if (!kundeUri.equals(other.kundeUri))
			return false;
		if (kundenid == null) {
			if (other.kundenid != null)
				return false;
		} 
		else if (!kundenid.equals(other.kundenid))
			return false;
		if (posten == null) {
			if (other.posten != null)
				return false;
		}
		else if (!posten.equals(other.posten))
			return false;
		return true;
	}
	
}
