package de.shop.bestellverwaltung.domain;

import java.util.List;
import java.math.BigDecimal;
import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.DecimalMin;
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
	
	@XmlTransient
	@Valid
	private AbstractKunde kundenid;
	
	@NotNull(message = "{bestellung.ausgeliefert.notnull}")
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
				gesamtpreis = gesamtpreis.add(p.getGesamtpreis());
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
		result = prime * result + ((kundenid == null) ? 0 : kundenid.hashCode());
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
		if (bestellnummer == null) {
			if (other.bestellnummer != null)
				return false;
		}
		else if (!bestellnummer.equals(other.bestellnummer))
			return false;
		return true;
	}
	
}
