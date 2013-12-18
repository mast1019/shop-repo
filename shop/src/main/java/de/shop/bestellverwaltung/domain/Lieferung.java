package de.shop.bestellverwaltung.domain;

import static de.shop.util.Constants.KEINE_ID;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostPersist;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.Logger;

import de.shop.util.persistence.AbstractAuditable;


@XmlRootElement
public class Lieferung extends AbstractAuditable {
	private static final long serialVersionUID = 7560752199018702446L;
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	private static final String PREFIX = "Lieferung.";
	public static final String FIND_LIEFERUNGEN_BY_LIEFERNR = PREFIX + "findLieferungenByLieferNr";
	public static final String PARAM_LIEFERNR = "lieferNr";
	
	public static final String GRAPH_BESTELLUNGEN = PREFIX + "bestellungen";

	@Id
	@GeneratedValue
	@Basic(optional = false)
	private Long id = KEINE_ID;
	
	@Column(name = "transport_art", length = 3)
	@Convert(converter = TransportTypeConverter.class)
	private TransportType transportArt;

	@ManyToMany(mappedBy = "lieferungen", cascade = { PERSIST, MERGE })
	@NotEmpty(message = "{lieferung.bestellungen.notEmpty}")
	@Valid
	@XmlTransient
	private List<Bestellung> bestellungen;

	public Lieferung() {
		super();
	}
	
	public Lieferung(TransportType transportArt) {
		super();
		this.transportArt = transportArt;
	}
	
	@PostPersist
	private void postPersist() {
		LOGGER.debugf("Neue Lieferung mit ID=%d", id);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public TransportType getTransportArt() {
		return transportArt;
	}

	public void setTransportArt(TransportType transportArt) {
		this.transportArt = transportArt;
	}

	public List<Bestellung> getBestellungen() {
		return bestellungen == null ? null : Collections.unmodifiableList(bestellungen);
	}
	
	public void setBestellungen(List<Bestellung> bestellungen) {
		if (this.bestellungen == null) {
			this.bestellungen = bestellungen;
			return;
		}

		this.bestellungen.clear();
		if (bestellungen != null) {
			this.bestellungen.addAll(bestellungen);
		}
	}
	
	public void addBestellung(Bestellung b) {
		if (b == null) {
			return;
		}
		this.bestellungen.add(b);
	}
	
	public void addMehrereBestellungen(List<Bestellung> bestellungen) {
		if (bestellungen == null) {
			this.bestellungen = bestellungen;
			return;
		}
		for (Bestellung b : bestellungen) {
			this.bestellungen.add(b);
		}
	}
	

	@Override
	public String toString() {
		return "Lieferung [id=" + id + ", liefernr=" + liefernr + ", transportArt=" + transportArt
				+ ", " + super.toString() + ']';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((liefernr == null) ? 0 : liefernr.hashCode());
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
		final Lieferung other = (Lieferung) obj;
		
		if (liefernr == null) {
			if (other.liefernr != null) {
				return false;
			}
		}
		else if (!liefernr.equals(other.liefernr)) {
			return false;
		}

		return true;
	}
}
