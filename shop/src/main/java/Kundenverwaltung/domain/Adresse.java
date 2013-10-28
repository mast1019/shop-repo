package de.shop.kundenverwaltung.domain;

public class Adresse {
	
	private String Stra�e;
	private Long Hausnummer;
	private Long Postleitzahl;
	private String Stadt;
	private String Adresszusatz;
	
	public Adresse(String stra�e,
			Long hausnummer, Long postleitzahl, String stadt,
			String adresszusatz) {
		super();
		
		setStra�e(stra�e);
		setHausnummer(hausnummer);
		setPostleitzahl(postleitzahl);
		setStadt(stadt);
		setAdresszusatz(adresszusatz);
	}

	public String getStra�e() {
		return Stra�e;
	}
	public void setStra�e(String stra�e) {
		Stra�e = stra�e;
	}
	public Long getHausnummer() {
		return Hausnummer;
	}
	public void setHausnummer(Long hausnummer) {
		Hausnummer = hausnummer;
	}
	public Long getPostleitzahl() {
		return Postleitzahl;
	}
	public void setPostleitzahl(Long postleitzahl) {
		Postleitzahl = postleitzahl;
	}
	public String getStadt() {
		return Stadt;
	}
	public void setStadt(String stadt) {
		Stadt = stadt;
	}
	public String getAdresszusatz() {
		return Adresszusatz;
	}
	public void setAdresszusatz(String adresszusatz) {
		Adresszusatz = adresszusatz;
	}
	
	
}
