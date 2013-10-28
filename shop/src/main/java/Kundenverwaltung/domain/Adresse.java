package de.shop.kundenverwaltung.domain;

public class Adresse {
	
	private String Straﬂe;
	private Long Hausnummer;
	private Long Postleitzahl;
	private String Stadt;
	private String Adresszusatz;
	
	public Adresse(String straﬂe,
			Long hausnummer, Long postleitzahl, String stadt,
			String adresszusatz) {
		super();
		
		setStraﬂe(straﬂe);
		setHausnummer(hausnummer);
		setPostleitzahl(postleitzahl);
		setStadt(stadt);
		setAdresszusatz(adresszusatz);
	}

	public String getStraﬂe() {
		return Straﬂe;
	}
	public void setStraﬂe(String straﬂe) {
		Straﬂe = straﬂe;
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
