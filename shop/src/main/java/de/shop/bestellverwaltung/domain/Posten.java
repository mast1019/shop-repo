package de.shop.bestellverwaltung.domain;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.shop.artikelverwaltung.domain.Artikel;
import static de.shop.util.Constants.KEINE_ID;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.jboss.logging.Logger;


@Entity
@Table(indexes =  {
	@Index(columnList = "bestellung_fk"),
	@Index(columnList = "artikel_fk")
})
@NamedQueries({
 @NamedQuery(name  = Posten.FIND_LADENHUETER,
	            query = "SELECT a"
	            	    + " FROM   Artikel a"
	            	    + " WHERE  a NOT IN (SELECT bp.artikel FROM Bestellposition bp)")
})
@XmlRootElement
public class Posten implements Serializable {
	private static final long serialVersionUID = -6546634107480260335L;
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	private static final String PREFIX = "Bestellposition.";
	public static final String FIND_LADENHUETER = PREFIX + "findLadenhueter";
	
	@Id
	@GeneratedValue
	@Basic(optional = false)
	private Long id = KEINE_ID;

	@ManyToOne(optional = false)
	@JoinColumn(name = "artikel_fk", nullable = false)
	@XmlTransient
	@Valid
	@NotNull(message = "{posten.artikel.notNull}")
	private Artikel artikel;
	
	@Basic(optional = false)
	@NotNull(message = "{posten.anzahl.notNull}")
	@Min(value = 1, message = "{posten.anzahl.min}")	
	private Integer anzahl;
	
	@NotNull(message = "{posten.gesamtpreis.notNull}")
	@DecimalMin(value = "0.0", message = "{posten.gesamtpreis.decimalmin}")
	private BigDecimal gesamtpreis;
	
	@XmlTransient
	private URI artikelUri;

	public Posten() {	
	}
	
	public Posten(Long id, Artikel artikel, Integer anzahl) {
		super();
		this.id = id;
		this.artikel = artikel;
		this.anzahl = anzahl;
	}
	
	@PostPersist
	private void postPersist() {
		LOGGER.debugf("Neue Bestellposition mit ID=%d", id);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlTransient
	public Artikel getArtikel() {
		return artikel;
	}
	
	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}
	
	public Integer getAnzahl() {
		return anzahl;
	}
	
	public void setAnzahl(Integer anzahl) {
		this.anzahl = anzahl;
	}
	
	public BigDecimal getGesamtpreis() {
		final BigDecimal anz = new BigDecimal(anzahl);
		gesamtpreis = artikel.getPreis().multiply(anz);
		return gesamtpreis;
	}
	
	public void setGesamtpreis(BigDecimal gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}
	
	public URI getArtikelUri() {
		return artikelUri;
	}
	
	public void setArtikelUri(URI artikeluri) {
		this.artikelUri = artikeluri;
	}

	@Override
	public String toString() {
		return "Posten [id=" + id + ", artikel=" + artikel.toString() + ", anzahl="
				+ anzahl + ", gesamtpreis=" + gesamtpreis + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anzahl;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((artikel == null) ? 0 : artikel.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Posten other = (Posten) obj;
		
		// Bei persistenten Bestellpositionen koennen zu verschiedenen Bestellungen gehoeren
		// und deshalb den gleichen Artikel (s.u.) referenzieren, deshalb wird Id hier beruecksichtigt
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		}
		else if (!id.equals(other.id)) {
			return false;
		}

		// Wenn eine neue Bestellung angelegt wird, dann wird jeder zu bestellende Artikel
		// genau 1x referenziert (nicht zu verwechseln mit der "anzahl")
		if (artikel == null) {
			if (other.artikel != null) {
				return false;
			}
		}
		else if (!artikel.equals(other.artikel)) {
			return false;
		}
		
		return true;
	}
		
}
