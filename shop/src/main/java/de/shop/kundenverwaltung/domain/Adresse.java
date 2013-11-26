package de.shop.kundenverwaltung.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

public class Adresse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7904673428542887485L;
	
	private static final int PLZ_LENGTH_MAX = 5;
	private static final int PLZ_LENGTH_MIN = 5;
	private static final int STRASSE_LENGTH_MAX = 60;
	private static final int STRASSE_LENGTH_MIN = 1;
	private static final int ORT_LENGTH_MIN = 2;
	private static final int ORT_LENGTH_MAX = 32;
	
	private Long id; 
	
	@NotNull(message = "{adresse.plz.notNull}")
	@Size(min = PLZ_LENGTH_MIN, max = PLZ_LENGTH_MAX,
    message = "{adresse.plz.length}")
	@Pattern(regexp = "\\d{5}", message = "{adresse.plz}")
	private String postleitzahl;
	
	@NotNull(message = "{adresse.strasse.notNull}")
	@Size(min = STRASSE_LENGTH_MIN, max = STRASSE_LENGTH_MAX,
    message = "{adresse.strasse.length}")
	@Pattern(regexp = "\\d{5}", message = "{adresse.strasse}")
	private String strasse;
	
	@NotNull(message = "{adresse.hausnummer.notNull}")
	@Pattern(regexp = "\\d{5}", message = "{adresse.hausnummer}")
	private String hausnummer;
	
	@NotNull(message = "{adresse.ort.notNull}")
	@Size(min = ORT_LENGTH_MIN, max = ORT_LENGTH_MAX, message = "{adresse.ort.length}")
	private String stadt;
	
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	@XmlTransient
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		} else if (!hausnummer.equals(other.hausnummer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		} else if (!kunde.equals(other.kunde))
			return false;
		if (postleitzahl == null) {
			if (other.postleitzahl != null)
				return false;
		} else if (!postleitzahl.equals(other.postleitzahl))
			return false;
		if (stadt == null) {
			if (other.stadt != null)
				return false;
		} else if (!stadt.equals(other.stadt))
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", postleitzahl=" + postleitzahl
				+ ", strasse=" + strasse + ", hausnummer=" + hausnummer
				+ ", stadt=" + stadt + ", kunde=" + kunde + "]";
	}

	
	

	
}
