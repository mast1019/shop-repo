package Bestellverwaltung.domain;

import java.util.List;

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import Kundenverwaltung.domain.Kunde;
@XmlRootElement
public class Bestellung implements Serializable{
	private static final long serialVersionUID = 1618359234119003714L;

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
	{}
	
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
	
	
	
	
}
