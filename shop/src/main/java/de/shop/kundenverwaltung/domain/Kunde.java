package de.shop.kundenverwaltung.domain;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.shop.bestellverwaltung.domain.Bestellung;

@XmlRootElement
public class Kunde {
	
	private Long id;
	private String nachname;
	private String vorname;
	
	@XmlTransient
	private List<Bestellung> bestellungen;
	private Adresse adresse;
	private Date erstellungsdatum;
	private URI bestellungenURI;
	
	public Kunde(String nname, String vname, de.shop.kundenverwaltung.domain.Adresse adr, Date erstellung) {
		super();
		nachname = nname;
		vorname = vname;
		adresse = adr;
		erstellungsdatum = erstellung;
	}
	
	//Standardkonstruktor
	public Kunde() { 
		
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


	public List<Bestellung> getBestellungen() {
		return bestellungen;
	}

	public void setBestellungen(List<Bestellung> best) {
		bestellungen = best;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adr) {
		adresse = adr;
	}

	public Date getErstellungsdatum() {
		return erstellungsdatum;
	}

	public void setErstellungsdatum(Date erstellung) {
		erstellungsdatum = erstellung;
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
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result	+ ((bestellungen == null) ? 0 : bestellungen.hashCode());
		result = prime * result	+ ((erstellungsdatum == null) ? 0 : erstellungsdatum.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		result = prime * result	+ ((bestellungenURI == null) ? 0 : bestellungenURI.hashCode());
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
		final Kunde other = (Kunde) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} 
		else if (!adresse.equals(other.adresse))
			return false;
		if (bestellungen == null) {
			if (other.bestellungen != null)
				return false;
		}
		else if (!bestellungen.equals(other.bestellungen))
			return false;
		if (erstellungsdatum == null) {
			if (other.erstellungsdatum != null)
				return false;
		} 
		else if (!erstellungsdatum.equals(other.erstellungsdatum))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		}
		else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} 
		else if (!vorname.equals(other.vorname))
			return false;
		if (bestellungenURI == null) {
			if (other.bestellungenURI != null)
				return false;
		}
		else if (!bestellungenURI.equals(other.bestellungenURI))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kunde [Id=" + id + ", Nachname=" + nachname + ", Vorname="
				+ vorname + ", Bestellungen=" + bestellungen + ", Adresse="
				+ adresse + ", Erstellungsdatum=" + erstellungsdatum
				+ ", bestellungenURI=" + bestellungenURI + "]";
	}
	
	
	
}

