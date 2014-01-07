package de.shop.kundenverwaltung.domain;

import static de.shop.kundenverwaltung.domain.AbstractKunde.PRIVATKUNDE;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@DiscriminatorValue(PRIVATKUNDE)
@Cacheable
public class Privatkunde extends AbstractKunde {

	private static final long serialVersionUID = 2695290962230475993L;

	@Column(length = 1)
	private GeschlechtType geschlecht = GeschlechtType.WEIBLICH;
	
	public GeschlechtType getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(GeschlechtType geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	@Override
	public String toString() {
		return "Privatkunde [" + super.toString() + "geschlecht=" + geschlecht + "]";
	}
	
}
