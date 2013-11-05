package Bestellverwaltung.domain;

import java.util.List;
import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import Kundenverwaltung.domain.Kunde;

@XmlRootElement
public class Bestellung {
	public Bestellung(Long bestellnummer, List<Posten> posten,
			Double gesamtpreis, Kunde kundenid, Boolean ausgeliefert) {
		super();
		this.bestellnummer = bestellnummer;
		this.posten = posten;
		this.gesamtpreis = gesamtpreis;
		this.kundenid = kundenid;
		this.ausgeliefert = ausgeliefert;
	}
	
	public Bestellung()
	{ }
	
	private Long bestellnummer;
	private List<Posten> posten;
	private Double gesamtpreis;
	
	@XmlTransient
	private Kunde kundenid;
	
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
	public Double getGesamtpreis() {
		return gesamtpreis;
	}
	
	public void setGesamtpreis(Double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}
	
	public Kunde getKundenid() {
		return kundenid;
	}
	
	public void setKundenid(Kunde kundenid) {
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
		Bestellung other = (Bestellung) obj;
		if (ausgeliefert == null) {
			if (other.ausgeliefert != null)
				return false;
		} else if (!ausgeliefert.equals(other.ausgeliefert))
			return false;
		if (bestellnummer == null) {
			if (other.bestellnummer != null)
				return false;
		} else if (!bestellnummer.equals(other.bestellnummer))
			return false;
		if (gesamtpreis == null) {
			if (other.gesamtpreis != null)
				return false;
		} else if (!gesamtpreis.equals(other.gesamtpreis))
			return false;
		if (kundeUri == null) {
			if (other.kundeUri != null)
				return false;
		} else if (!kundeUri.equals(other.kundeUri))
			return false;
		if (kundenid == null) {
			if (other.kundenid != null)
				return false;
		} else if (!kundenid.equals(other.kundenid))
			return false;
		if (posten == null) {
			if (other.posten != null)
				return false;
		} else if (!posten.equals(other.posten))
			return false;
		return true;
	}
	
	
}


