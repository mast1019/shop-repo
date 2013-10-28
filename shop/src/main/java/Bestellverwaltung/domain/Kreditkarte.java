package de.shop.bestellungsverwaltung.domain;

public class Kreditkarte extends Zahlung {
	
	private String kartennummer;
	private String ablaufdatum;
	private String sicherheitscode;
	
	public String getKartennummer() {
		return kartennummer;
	}
	public void setKartennummer(String kartennummer) {
		this.kartennummer = kartennummer;
	}
	public String getAblaufdatum() {
		return ablaufdatum;
	}
	public void setAblaufdatum(String ablaufdatum) {
		this.ablaufdatum = ablaufdatum;
	}
	public String getSicherheitscode() {
		return sicherheitscode;
	}
	public void setSicherheitscode(String sicherheitscode) {
		this.sicherheitscode = sicherheitscode;
	}
	public Kreditkarte(String name, String kartennummer, String ablaufdatum,
			String sicherheitscode) {
		super(name);
		this.kartennummer = kartennummer;
		this.ablaufdatum = ablaufdatum;
		this.sicherheitscode = sicherheitscode;
	}
	@Override
	public String toString() {
		return "Kreditkarte [Kartennummer=" + kartennummer + ", Ablaufdatum="
				+ ablaufdatum + ", Sicherheitscode=" + sicherheitscode
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
