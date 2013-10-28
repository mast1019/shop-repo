package Bestellverwaltung.domain;

import java.util.Date;
import java.util.List;

public class Bestellung {

	public Bestellung(Date bestelldatum, Long kundenid) {
		super();
		this.bestelldatum = bestelldatum;
		this.kundenid = kundenid;
	}
	private Long bestellnummer;
	private Date bestelldatum;
	private List<Posten> posten;
	private Double gesamtpreis;
	private Long kundenid;
	public Long getBestellnummer() {
		return bestellnummer;
	}
	public void setBestellnummer(Long bestellnummer) {
		this.bestellnummer = bestellnummer;
	}
	public Date getBestelldatum() {
		return bestelldatum;
	}
	public void setBestelldatum(Date bestelldatum) {
		this.bestelldatum = bestelldatum;
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
	public Long getKundenid() {
		return kundenid;
	}
	public void setKundenid(Long kundenid) {
		this.kundenid = kundenid;
	}
	@Override
	public String toString() {
		return "Bestellung [bestellnummer=" + bestellnummer + ", bestelldatum="
				+ bestelldatum + ", posten=" + posten + ", gesamtpreis="
				+ gesamtpreis + ", kundenid=" + kundenid + "]";
	}
	
	
}
