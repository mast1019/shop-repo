package Kundenverwaltung.domain;

import java.net.URI;
import java.util.Date;
import java.util.List;

import Bestellverwaltung.domain.Bestellung;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Kunde {
	
	private Long Id;
	private String Nachname;
	private String Vorname;
	
	@XmlTransient
	private List<Bestellung> Bestellungen;
	private Adresse Adresse;
	private Date Erstellungsdatum;
	private URI bestellungenURI;
	
	public Kunde(String nachname, String vorname, Kundenverwaltung.domain.Adresse adresse, Date erstellungsdatum) {
		super();
		Nachname = nachname;
		Vorname = vorname;
		Adresse = adresse;
		Erstellungsdatum = erstellungsdatum;
	}
	
	public Kunde() { 
		
	}
	
	public Long getId()  {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNachname() {
		return Nachname;
	}

	public void setNachname(String nachname) {
		Nachname = nachname;
	}

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		Vorname = vorname;
	}


	public List<Bestellung> getBestellungen() {
		return Bestellungen;
	}

	public void setBestellungen(List<Bestellung> bestellungen) {
		Bestellungen = bestellungen;
	}

	public Adresse getAdresse() {
		return Adresse;
	}

	public void setAdresse(Adresse adresse) {
		Adresse = adresse;
	}

	public Date getErstellungsdatum() {
		return Erstellungsdatum;
	}

	public void setErstellungsdatum(Date erstellungsdatum) {
		Erstellungsdatum = erstellungsdatum;
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
		result = prime * result + ((Adresse == null) ? 0 : Adresse.hashCode());
		result = prime * result	+ ((Bestellungen == null) ? 0 : Bestellungen.hashCode());
		result = prime * result	+ ((Erstellungsdatum == null) ? 0 : Erstellungsdatum.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Nachname == null) ? 0 : Nachname.hashCode());
		result = prime * result + ((Vorname == null) ? 0 : Vorname.hashCode());
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
		if (Adresse == null) {
			if (other.Adresse != null)
				return false;
		} 
		else if (!Adresse.equals(other.Adresse))
			return false;
		if (Bestellungen == null) {
			if (other.Bestellungen != null)
				return false;
		}
		else if (!Bestellungen.equals(other.Bestellungen))
			return false;
		if (Erstellungsdatum == null) {
			if (other.Erstellungsdatum != null)
				return false;
		} 
		else if (!Erstellungsdatum.equals(other.Erstellungsdatum))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		}
		else if (!Id.equals(other.Id))
			return false;
		if (Nachname == null) {
			if (other.Nachname != null)
				return false;
		}
		else if (!Nachname.equals(other.Nachname))
			return false;
		if (Vorname == null) {
			if (other.Vorname != null)
				return false;
		} 
		else if (!Vorname.equals(other.Vorname))
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
		return "Kunde [Id=" + Id + ", Nachname=" + Nachname + ", Vorname="
				+ Vorname + ", Bestellungen=" + Bestellungen + ", Adresse="
				+ Adresse + ", Erstellungsdatum=" + Erstellungsdatum
				+ ", bestellungenURI=" + bestellungenURI + "]";
	}
	
	
	
}

