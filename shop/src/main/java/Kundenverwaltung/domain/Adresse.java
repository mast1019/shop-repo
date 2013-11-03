package Kundenverwaltung.domain;

import javax.xml.bind.annotation.XmlTransient;


public class Adresse {
	
	private String Straﬂe;
	private Integer Hausnummer;
	private Integer Postleitzahl;
	private String Stadt;
	
	@XmlTransient
	private Kunde kunde;
	
	public Adresse(String straﬂe,
			Integer hausnummer, Integer postleitzahl, String stadt, Kunde kunde) {
		super();
		
		setStraﬂe(straﬂe);
		setHausnummer(hausnummer);
		setPostleitzahl(postleitzahl);
		setStadt(stadt);
		setKunde(kunde);
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

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	@Override
	public String toString() {
		return "Adresse [Straﬂe=" + Straﬂe + ", Hausnummer=" + Hausnummer
				+ ", Postleitzahl=" + Postleitzahl + ", Stadt=" + Stadt
				+ ", kunde=" + kunde + "]";
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
		result = prime * result + ((Straﬂe == null) ? 0 : Straﬂe.hashCode());
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
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
		if (Straﬂe == null) {
			if (other.Straﬂe != null)
				return false;
		} else if (!Straﬂe.equals(other.Straﬂe))
			return false;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		} else if (!kunde.equals(other.kunde))
			return false;
		return true;
	}

	
	
}
