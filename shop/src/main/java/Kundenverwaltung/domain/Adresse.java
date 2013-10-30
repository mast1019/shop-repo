package Kundenverwaltung.domain;

public class Adresse {
	
	private String Straﬂe;
	private Integer Hausnummer;
	private Integer Postleitzahl;
	private String Stadt;
	
	public Adresse(String straﬂe,
			Integer hausnummer, Integer postleitzahl, String stadt) {
		super();
		
		setStraﬂe(straﬂe);
		setHausnummer(hausnummer);
		setPostleitzahl(postleitzahl);
		setStadt(stadt);
	}

	public Adresse()
	{}
	
	public String getStraﬂe() {
		return Straﬂe;
	}
	public void setStraﬂe(String straﬂe) {
		Straﬂe = straﬂe;
	}
	public Integer getHausnummer() {
		return Hausnummer;
	}
	public void setHausnummer(Integer hausnummer) {
		Hausnummer = hausnummer;
	}
	public Integer getPostleitzahl() {
		return Postleitzahl;
	}
	public void setPostleitzahl(Integer postleitzahl) {
		Postleitzahl = postleitzahl;
	}
	public String getStadt() {
		return Stadt;
	}
	public void setStadt(String stadt) {
		Stadt = stadt;
	}

	
}
