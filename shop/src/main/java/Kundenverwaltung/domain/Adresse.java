package Kundenverwaltung.domain;

public class Adresse {
	
	private String Stra�e;
	private Integer Hausnummer;
	private Integer Postleitzahl;
	private String Stadt;
	
	public Adresse(String stra�e,
			Integer hausnummer, Integer postleitzahl, String stadt) {
		super();
		
		setStra�e(stra�e);
		setHausnummer(hausnummer);
		setPostleitzahl(postleitzahl);
		setStadt(stadt);
	}

	public Adresse()
	{}
	
	public String getStra�e() {
		return Stra�e;
	}
	public void setStra�e(String stra�e) {
		Stra�e = stra�e;
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
