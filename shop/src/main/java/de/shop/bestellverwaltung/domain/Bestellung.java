package de.shop.bestellverwaltung.domain;

import java.util.List;
import java.util.Collections;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.net.URI;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.jboss.logging.Logger;

import static de.shop.util.Constants.KEINE_ID;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;
import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.util.persistence.AbstractAuditable;


@Entity
@Table(indexes = {
	@Index(columnList = "kunde_fk"),
	@Index(columnList = "erzeugt")
})
@NamedQueries({
	@NamedQuery(name  = Bestellung.FIND_BESTELLUNGEN_BY_KUNDE,
                query = "SELECT b"
			            + " FROM   Bestellung b"
						+ " WHERE  b.kundenid = :" + Bestellung.PARAM_KUNDE),
	@NamedQuery(name  = Bestellung.FIND_KUNDE_BY_ID,
 			    query = "SELECT b.kundenid"
                        + " FROM   Bestellung b"
  			            + " WHERE  b.bestellnummer = :" + Bestellung.PARAM_ID)
})
@Cacheable
@XmlRootElement
@NamedEntityGraphs({
	@NamedEntityGraph(name = Bestellung.GRAPH_LIEFERUNGEN,
					  attributeNodes = @NamedAttributeNode("lieferungen"))
})
public class Bestellung extends AbstractAuditable implements Serializable {
	private static final long serialVersionUID = 1369903391973996134L;
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());	
	private static final String PREFIX = "Bestellung.";
	public static final String FIND_BESTELLUNGEN_BY_KUNDE = PREFIX + "findBestellungenByKunde";
	public static final String FIND_KUNDE_BY_ID = PREFIX + "findBestellungKundeById";
	
	public static final String PARAM_KUNDE = "kundenid";
	public static final String PARAM_ID = "bestellnummer";
	
	public static final String GRAPH_LIEFERUNGEN = PREFIX + "lieferungen";

	
	@Id
	@GeneratedValue
	@Basic(optional = false)
	private Long bestellnummer = KEINE_ID;
	
	@OneToMany(fetch = EAGER, cascade = { PERSIST, REMOVE })
	@JoinColumn(name = "bestellung_fk", nullable = false)
	@NotNull(message = "{bestellung.posten.notnull}")
	@Size(min = 1, message = "{bestellung.posten.size}")
	@Valid
	private List<Posten> posten;
	
	@ManyToMany
	@JoinTable(name = "bestellung_lieferung",
	   joinColumns = @JoinColumn(name = "bestellung_fk"),
	                 inverseJoinColumns = @JoinColumn(name = "lieferung_fk"))
	@XmlTransient
	private List<Lieferung> lieferungen;
	
	@ManyToOne
	@JoinColumn(name = "kunde_fk", nullable = false, insertable = false, updatable = false)	
	@XmlTransient
	private AbstractKunde kundenid;
	
	@NotNull(message = "{bestellung.ausgeliefert.notnull}")
	private Boolean ausgeliefert;
	
	@Transient
	private URI kundeUri;
	
	public Bestellung () {
		super();
	}

	public Bestellung (List<Posten> bestellpositionen) {
		super();
		this.posten = bestellpositionen;
	}
	
	@PostPersist
	private void postPersist() {
	LOGGER.debugf("Neue Bestellung mit Bestellnummer = %d", bestellnummer);
	}
	
	public Long getBestellnummer() {
		return bestellnummer;
	}
	
	public void setBestellnummer(Long bestellnummer) {
		this.bestellnummer = bestellnummer;
	}

	public List<Posten> getPosten() {
		return posten;
	}
	
	public void setPosten(List<Posten> posten) {
		this.posten = posten;
	}
	
	public List<Lieferung> getLieferungen() {
		return lieferungen == null ? null : Collections.unmodifiableList(lieferungen);
	}

	public void setLieferungen(List<Lieferung> lieferungen) {
		if (this.lieferungen == null) {
			this.lieferungen = lieferungen;
			return;
		}
		
		this.lieferungen.clear();
		if (lieferungen != null) {
			this.lieferungen.addAll(lieferungen);
		}
	}
	
	public void addLieferung(Lieferung l) {
		if (l == null) {
			return;
		}
		this.lieferungen.add(l);
	}
	
	public void addMehrereLieferungen(List<Lieferung> lieferungen) {
		if (lieferungen == null) {
			this.lieferungen = lieferungen;
			return;
		}
		for (Lieferung l : lieferungen) {
			this.lieferungen.add(l);
		}
	}
	
	@XmlTransient
	public AbstractKunde getKundenid() {
		return kundenid;
	}
	
	public void setKundenid(AbstractKunde kundenid) {
		this.kundenid = kundenid;
	}
	
	public Boolean getAusgeliefert() {
		return ausgeliefert;
	}
	
	public void setAusgeliefert(Boolean ausgeliefert) {
		this.ausgeliefert = ausgeliefert;
	}
	
	public URI getKundeUri() {
		return kundeUri;
	}
		
	public void setKundeUri(URI kundeUri) {
		this.kundeUri = kundeUri;
	}
	
	public void addPosten(Posten p) {
		if (p == null) {
			return;
		}
		this.posten.add(p);
	}	
	
	public void addMehrerePosten(List<Posten> posten) {
		if (posten == null) {
			this.posten = posten;
			return;
		}
		for (Posten p : posten) {
			this.posten.add(p);
		}
	}

	@Override
	public String toString() {
		return "Bestellung [bestellnummer=" + bestellnummer + ", kundeuri="
				+ kundeUri + ", ausgeliefert=" + ausgeliefert + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bestellnummer == null) ? 0 : bestellnummer.hashCode());
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
		final Bestellung other = (Bestellung) obj;
		if (bestellnummer == null) {
			if (other.bestellnummer != null)
				return false;
		}
		else if (!bestellnummer.equals(other.bestellnummer))
			return false;
		return true;
	}
	
}
