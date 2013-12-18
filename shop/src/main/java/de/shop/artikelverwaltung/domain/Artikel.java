package de.shop.artikelverwaltung.domain;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.jboss.logging.Logger;

@XmlRootElement
@Entity
@Table(indexes = @Index(columnList = "name"))
@NamedQueries({
	@NamedQuery(name  = Artikel.FIND_VERFUEGBARE_ARTIKEL,
        	query = "SELECT      a"
        	        + " FROM     Artikel a"
					+ " WHERE    a.ausgesondert = FALSE"
                    + " ORDER BY a.id ASC"),
	@NamedQuery(name  = Artikel.FIND_ARTIKEL_BY_NAME,
            	query = "SELECT      a"
                        + " FROM     Artikel a"
						+ " WHERE    a.name LIKE :" + Artikel.PARAM_NAME
			 	        + " ORDER BY a.id ASC"),
   	@NamedQuery(name  = Artikel.FIND_ARTIKEL_MAX_PREIS,
            	query = "SELECT      a"
                        + " FROM     Artikel a"
						+ " WHERE    a.preis < :" + Artikel.PARAM_PREIS
			 	        + " ORDER BY a.id ASC")
})
public class Artikel implements Serializable {	 //TODO extends AbstractAuditable
	
	private static final long serialVersionUID = 4593393192027810187L;
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	private static final String PREFIX = "Artikel.";
	public static final String FIND_VERFUEGBARE_ARTIKEL = PREFIX + "findVerfuegbareArtikel";
	public static final String FIND_ARTIKEL_BY_NAME = PREFIX + "findArtikelByName";
	public static final String FIND_ARTIKEL_MAX_PREIS = PREFIX + "findArtikelByMaxPreis";

	public static final String PARAM_NAME = "name";
	public static final String PARAM_PREIS = "preis";
	
	@Id
	@GeneratedValue
	@Basic(optional = false)
	private Long id; //TODO KEINE_ID
	
	@NotNull(message = "{artikel.name.notNull}")
	@Size(min = 2, max = 32, message = "{artikel.name.length}")
	@Pattern(regexp = "[A-ZÄÖÜ][a-zäöüß]+")
	private String name;
	
	@NotNull(message = "{artikel.beschreibung.notNull}")
	@Size(min = 10, max = 150, message = "{artikel.beschreibung.length}")
	private String beschreibung;
	
	@NotNull(message = "{artikel.preis.notNull}")
	@DecimalMin(value = "0", message = "{artikel.preis.min}")
	@DecimalMax(value = "10000", message = "{artikel.preis.max}") 
	private BigDecimal preis;
	
	@NotNull(message = "{artikel.gewicht.notNull}")
	@DecimalMin(value = "0.1", message = "{artikel.gewicht.min}")
	@DecimalMax(value = "100", message = "{artikel.gewicht.max}")
	private BigDecimal gewicht;
	
	@Basic(optional = false)
	private boolean ausgesondert;

	
	public Artikel(String name, String beschreibung, BigDecimal preis, BigDecimal gewicht)	{
		super();
		this.setName(name);
		this.setBeschreibung(beschreibung);
		this.setPreis(preis);
		this.setGewicht(gewicht);
	}
	
	public Artikel() {
		super();
	}
	
	@PostPersist
	private void postPersist() {
		LOGGER.debugf("Neuer Artikel mit ID=%d", id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public BigDecimal getPreis() {
		return preis;
	}

	public void setPreis(BigDecimal preis) {
		this.preis = preis;
	}

	public BigDecimal getGewicht() {
		return gewicht;
	}

	public void setGewicht(BigDecimal gewicht) {
		this.gewicht = gewicht;
	}
	
	public boolean isAusgesondert() {
		return ausgesondert;
	}

	public void setAusgesondert(boolean ausgesondert) {
		this.ausgesondert = ausgesondert;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ausgesondert ? 1231 : 1237);
		result = prime * result
				+ ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + ((gewicht == null) ? 0 : gewicht.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((preis == null) ? 0 : preis.hashCode());
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
		Artikel other = (Artikel) obj;
		if (ausgesondert != other.ausgesondert)
			return false;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (gewicht == null) {
			if (other.gewicht != null)
				return false;
		} else if (!gewicht.equals(other.gewicht))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (preis == null) {
			if (other.preis != null)
				return false;
		} else if (!preis.equals(other.preis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artikel [id=" + id + ", name=" + name
		       + ", preis=" + preis + ", gewicht=" + gewicht + ", ausgesondert=" + ausgesondert
		       + ", " + super.toString() + "]";
	}
}
