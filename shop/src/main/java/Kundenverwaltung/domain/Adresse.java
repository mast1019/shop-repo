package Kundenverwaltung.domain;


public class Adresse {
	
	private String Strasse;
	private String Hausnummer;
	private String Postleitzahl;
	private String Stadt;
	
	public Adresse(String strasse,
			String hausnummer, String postleitzahl, String stadt) {
		super();
		
		Strasse = strasse;
		Hausnummer = hausnummer;
		Postleitzahl = postleitzahl;
		Stadt = stadt;
	}

	public Adresse()
	{}
	
	public String getStrasse() {
		return Strasse;
	}
	public void setStrasse(String strasse) {
		Strasse = strasse;
	}
	public String getHausnummer() {
		return Hausnummer;
	}
	public void setHausnummer(String hausnummer) {
		Hausnummer = hausnummer;
	}
	public String getPostleitzahl() {
		return Postleitzahl;
	}
	public void setPostleitzahl(String postleitzahl) {
		Postleitzahl = postleitzahl;
	}
	public String getStadt() {
		return Stadt;
	}
	public void setStadt(String stadt) {
		Stadt = stadt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Hausnummer == null) ? 0 : Hausnummer.hashCode());
		result = prime * result
				+ ((Postleitzahl == null) ? 0 : Postleitzahl.hashCode());
		result = prime * result + ((Stadt == null) ? 0 : Stadt.hashCode());
		result = prime * result + ((Strasse == null) ? 0 : Strasse.hashCode());
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
		if (Hausnummer == null) {
			if (other.Hausnummer != null)
				return false;
		} else if (!Hausnummer.equals(other.Hausnummer))
			return false;
		if (Postleitzahl == null) {
			if (other.Postleitzahl != null)
				return false;
		} else if (!Postleitzahl.equals(other.Postleitzahl))
			return false;
		if (Stadt == null) {
			if (other.Stadt != null)
				return false;
		} else if (!Stadt.equals(other.Stadt))
			return false;
		if (Strasse == null) {
			if (other.Strasse != null)
				return false;
		} else if (!Strasse.equals(other.Strasse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adresse [Strasse=" + Strasse + ", Hausnummer=" + Hausnummer
				+ ", Postleitzahl=" + Postleitzahl + ", Stadt=" + Stadt + "]";
	}




	
	
}
