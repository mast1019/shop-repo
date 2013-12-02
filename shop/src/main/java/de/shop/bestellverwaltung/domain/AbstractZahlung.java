package de.shop.bestellverwaltung.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public abstract class AbstractZahlung {
	
	@NotNull(message = "{abstractzahlung.vorname.notnull}")
	@Size(min = 2, max = 32, message = "{abstractzahlung.vorname.size}")
	@Pattern(regexp = "[A-ZÄÖÜ][a-zäöüß]+", message = "{abstractzahlung.vorname.pattern}")
	private String vorname;

	@NotNull(message = "{abstractzahlung.nachname.notnull}")
	@Size(min = 2, max = 32, message = "{abstractzahlung.nachname.size}")
	@Pattern(regexp = "[A-ZÄÖÜ][a-zäöüß]+", message = "{abstractzahlung.nachname.pattern}")
	private String nachname;
	
	
	public AbstractZahlung(String vn, String nm) {
		super();
		this.vorname = vn;
		this.nachname = nm;
	}
	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vn) {
		this.vorname = vn;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public void setNachname(String nm) {
		this.nachname = nm;
	}

	@Override
	public String toString() {
		return "Name = " + vorname + " " + nachname;
	}
	
}
