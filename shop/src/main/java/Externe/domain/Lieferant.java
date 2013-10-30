package Externe.domain;

import Kundenverwaltung.domain.Adresse;

public class Lieferant
{
	private Long id;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lieferant(Long id, String name, Adresse anschrift) 
	{
		super();
		this.id = id;
		this.name = name;
		this.anschrift = anschrift;
	}
	
	public Lieferant(){}

	private String name;
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Adresse getAnschrift()
	{
		return anschrift;
	}
	
	public void setAnschrift(Adresse anschrift)
	{
		this.anschrift = anschrift;
	}
	
	private Adresse anschrift;

	@Override
	public String toString() {
		return "Lieferant [id=" + id + ", name=" + name + ", anschrift="
				+ anschrift.toString() + "]";
	}
	
	
	
}
