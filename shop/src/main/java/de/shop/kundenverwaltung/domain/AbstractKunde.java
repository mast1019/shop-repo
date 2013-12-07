package de.shop.kundenverwaltung.domain;

import java.net.URI;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.hibernate.validator.constraints.Email;

import de.shop.bestellverwaltung.domain.Bestellung;

@XmlRootElement
@XmlSeeAlso({ Firmenkunde.class, Privatkunde.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@Type(value = Privatkunde.class, name = AbstractKunde.PRIVATKUNDE),
	@Type(value = Firmenkunde.class, name = AbstractKunde.FIRMENKUNDE) })
public abstract class AbstractKunde implements Serializable {
	
	private static final long serialVersionUID = 12639985364951030L;
	
	public static final String PRIVATKUNDE = "P";
	public static final String FIRMENKUNDE = "F";
	
	private static final String NAME_PATTERN = "[A-Z\u00C4\u00D6\u00DC][a-z\u00E4\u00F6\u00FC\u00DF]+";
	private static final String NACHNAME_PREFIX = "(o'|von|von der|von und zu|van)?";
	
	public static final String NACHNAME_PATTERN = NACHNAME_PREFIX + NAME_PATTERN + "(-" + NAME_PATTERN + ")?";
	private static final int NACHNAME_LENGTH_MIN = 2;
	private static final int NACHNAME_LENGTH_MAX = 32;
	private static final int EMAIL_LENGTH_MAX = 128;
	
	private Long id;
	
	@NotNull(message = "{kunde.nachname.notNull}")
	@Size(min = NACHNAME_LENGTH_MIN, max = NACHNAME_LENGTH_MAX,
	      message = "{kunde.nachname.length}")
	@Pattern(regexp = NACHNAME_PATTERN, message = "{kunde.nachname.pattern}")
	private String nachname;
	
	@NotNull(message = "{kunde.vorname.notNull}")
	@Size(min = NACHNAME_LENGTH_MIN, max = NACHNAME_LENGTH_MAX,
	      message = "{kunde.vorname.length}")
	@Pattern(regexp = NACHNAME_PATTERN, message = "{kunde.vorname.pattern}")
	private String vorname;
	
	@Valid
	@NotNull(message = "{kunde.adresse.notNull}")
	private Adresse adresse;
	
	@Past(message = "{kunde.seit.past}")
	private Date erstellungsdatum;
	
	@Email(message = "{kunde.email.pattern}")
	@NotNull(message = "{kunde.email.notNull}")
	@Size(max = EMAIL_LENGTH_MAX, message = "{kunde.email.length}")
	private String email;
	
	@XmlTransient
	private List<Bestellung> bestellungen;
	
	private URI bestellungenURI;

	
	public AbstractKunde(String nname, String vname, Adresse adr, Date erstellung, String mail) {
		super();
		nachname = nname;
		vorname = vname;
		adresse = adr;
		erstellungsdatum = erstellung == null ? null : (Date) erstellung.clone();
		email = mail;
	}
	
	//Standardkonstruktor
	public AbstractKunde() { 	
	}
	
	public Long getId()  {
		return id;
	}

	public void setId(Long i) {
		id = i;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nname) {
		nachname = nname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vname) {
		vorname = vname;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adr) {
		adresse = adr;
	}

	public Date getErstellungsdatum() {
		return erstellungsdatum == null ? null : (Date) erstellungsdatum.clone();
	}

	public void setErstellungsdatum(Date erstellung) {
		this.erstellungsdatum = erstellung == null ? null : (Date) erstellung.clone();
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String mail) {
		email = mail;
	}
	
	public List<Bestellung> getBestellungen() {
		return bestellungen;
	}

	public void setBestellungen(List<Bestellung> best) {
		bestellungen = best;
	}

	public URI getBestellungenURI() {
		return bestellungenURI;
	}

	public void setBestellungenURI(URI bestellungenURI) {
		this.bestellungenURI = bestellungenURI;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		final AbstractKunde other = (AbstractKunde) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractKunde [id=" + id + ", nachname=" + nachname + ", vorname="
				+ vorname + ", email=" + email + ", erstellungsdatum=" 
				+ erstellungsdatum + ", bestellungenURI=" + bestellungenURI + "]";
	}
}

