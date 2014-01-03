package de.shop.kundenverwaltung.domain;

import static de.shop.util.Constants.KEINE_ID;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

import java.io.Serializable;
//import java.lang.invoke.MethodHandles;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import de.shop.util.persistence.AbstractAuditable;

//import org.jboss.logging.Logger;

@Entity
@Table(indexes = @Index(columnList = "postleitzahl"))
public class Adresse extends AbstractAuditable implements Serializable {
	
	private static final long serialVersionUID = -7904673428542887485L;
	//private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	private static final int PLZ_LENGTH_MAX = 5;
	private static final int STRASSE_LENGTH_MAX = 60;
	private static final int STRASSE_LENGTH_MIN = 1;
	private static final int ORT_LENGTH_MIN = 2;
	private static final int ORT_LENGTH_MAX = 32;
	
	@Id
	@GeneratedValue
	@Basic(optional = false)
	private Long id = KEINE_ID;
	
	@NotNull(message = "{adresse.plz.notNull}")
	@Pattern(regexp = "\\d{5}", message = "{adresse.plz}")
	@Column(length = PLZ_LENGTH_MAX)
	private String postleitzahl;
	
	@NotNull(message = "{adresse.strasse.notNull}")
	@Size(min = STRASSE_LENGTH_MIN, max = STRASSE_LENGTH_MAX,
    message = "{adresse.strasse.length}")
	private String strasse;
	
	@NotNull(message = "{adresse.hausnummer.notNull}")
	private String hausnummer;
	
	@NotNull(message = "{adresse.ort.notNull}")
	@Size(min = ORT_LENGTH_MIN, max = ORT_LENGTH_MAX, message = "{adresse.ort.length}")
	private String stadt;
	
	// mapped by = Attribut der Klasse AbstractKunde, wo die FK-Spalte definiert ist
	@OneToOne(cascade = { PERSIST,REMOVE }, mappedBy ="adresse")
	@Valid
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((postleitzahl == null) ? 0 : postleitzahl.hashCode());
		result = prime * result + ((stadt == null) ? 0 : stadt.hashCode());
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
		final Adresse other = (Adresse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
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
		return true;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", postleitzahl=" + postleitzahl
				+ ", strasse=" + strasse + ", hausnummer=" + hausnummer
				+ ", stadt=" + stadt + ", kunde=" + kunde + "]";
	}
}
