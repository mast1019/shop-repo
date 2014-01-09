package de.shop.kundenverwaltung.domain;

import static de.shop.kundenverwaltung.domain.AbstractKunde.FIRMENKUNDE;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@DiscriminatorValue(FIRMENKUNDE)
@Cacheable
public class Firmenkunde extends AbstractKunde {
	
	private static final long serialVersionUID = 5055072434762857586L;

	@Override
	public String toString() {
		return "Firmenkunde " + super.toString();
	}
	
}
