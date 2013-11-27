package de.shop.bestellverwaltung.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Kreditkarte extends AbstractZahlung {
	
	@NotNull (message = "{kreditkarte.kartennummer.notNull}")
	@Size(min = 2, max = 36, message = "{kreditkarte.kartennummer.size}")
	private String kartennummer;
	
	@NotNull (message = "{kreditkarte.ablaufdatum.notNull}")
	@Size(min = 5, max = 10, message = "{kreditkarte.ablaufdatum.size}")
	private String ablaufdatum;
	
	@NotNull (message = "{kreditkarte.sicherheitscode.notNull}")
	@Size(min = 1, max = 4, message = "{kreditkarte.sicherheitscode.size}")
	private String sicherheitscode;

	public Kreditkarte(String vorname, String nachname, String kartennummer, String ablaufdatum,
			String sicherheitscode) {
		super(vorname, nachname);
		this.kartennummer = kartennummer;
		this.ablaufdatum = ablaufdatum;
		this.sicherheitscode = sicherheitscode;
	}

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
	@Override
	public String toString() {
		return "Kreditkarte [Kartennummer=" + kartennummer + ", Ablaufdatum="
				+ ablaufdatum + ", Sicherheitscode=" + sicherheitscode
				+ ", toString()=" + super.toString() + "]";
	}
		
}
