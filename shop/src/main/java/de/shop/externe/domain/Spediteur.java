package de.shop.externe.domain;

import de.shop.kundenverwaltung.domain.Adresse;

public class Spediteur {
	
	private String name;
	private Adresse adresse;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Spediteur(String name, Adresse adresse) {
		super();
		this.name = name;
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "Spediteur:\n" + "Name = " + name + "\n" + "Adresse = " + adresse;
	}

}
