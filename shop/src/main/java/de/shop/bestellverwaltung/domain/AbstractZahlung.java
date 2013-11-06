package de.shop.bestellverwaltung.domain;

public abstract class AbstractZahlung {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AbstractZahlung(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name = " + name;
	}
	
}
