package de.shop.kundenverwaltung.domain;

import javax.xml.bind.annotation.XmlTransient;

public class Adresse {	
	private String strasse;
	private String hausnummer;
	private String postleitzahl;
	private String stadt;
	@XmlTransient
	private AbstractKunde kunde;
	
	public Adresse(String str, String hnr, String plz, String stdt) {
		super();
		strasse = str;
		hausnummer = hnr;
		postleitzahl = plz;
		stadt = stdt;
	}

	public Adresse() {	
	}
	
	public String getStrasse() {
		return strasse;
	}
	
	public void setStrasse(String str) {
		strasse = str;
	}
	
	public String getHausnummer() {
		return hausnummer;
	}
	
	public void setHausnummer(String hnr) {
		hausnummer = hnr;
	}
	
	public String getPostleitzahl() {
		return postleitzahl;
	}
	
	public void setPostleitzahl(String plz) {
		postleitzahl = plz;
	}
	
	public String getStadt() {
		return stadt;
	}
	
	public void setStadt(String stdt) {
		stadt = stdt;
	}
	
	public AbstractKunde getKunde() {
		return kunde;
	}
	public void setKunde(AbstractKunde kunde) {
		this.kunde = kunde;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hausnummer == null) ? 0 : hausnummer.hashCode());
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
		result = prime * result
				+ ((postleitzahl == null) ? 0 : postleitzahl.hashCode());
		result = prime * result + ((stadt == null) ? 0 : stadt.hashCode());
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
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
		Adresse other = (Adresse) obj;
		if (hausnummer == null) {
			if (other.hausnummer != null)
				return false;
		}
		else if (!hausnummer.equals(other.hausnummer))
			return false;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		}
		else if (!kunde.equals(other.kunde))
			return false;
		if (postleitzahl == null) {
			if (other.postleitzahl != null)
				return false;
		}
		else if (!postleitzahl.equals(other.postleitzahl))
			return false;
		if (stadt == null) {
			if (other.stadt != null)
				return false;
		}
		else if (!stadt.equals(other.stadt))
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		}
		else if (!strasse.equals(other.strasse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adresse [strasse=" + strasse + ", hausnummer=" + hausnummer
				+ ", postleitzahl=" + postleitzahl + ", stadt=" + stadt + "]";
	}
}
