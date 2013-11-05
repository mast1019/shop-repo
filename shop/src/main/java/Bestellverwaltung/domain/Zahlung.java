package Bestellverwaltung.domain;

public abstract class Zahlung {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Zahlung(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name = " + name;
	}
	
}
