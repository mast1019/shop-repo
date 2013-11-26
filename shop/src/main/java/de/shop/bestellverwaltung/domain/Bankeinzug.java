package de.shop.bestellverwaltung.domain;

import javax.validation.constraints.*;

public class Bankeinzug extends AbstractZahlung {
	
	@NotNull(message = "{bankeinzug.iban.notnull}")
	@Size(min = 22, max = 22, message = "{bankeinzug.iban.size}")
	@Pattern(regexp = "[A-Z]{2}[0-9]{20}", message = "{bankeinzug.iban.pattern}")
	private String iban;
	
	@NotNull(message = "{bankeinzug.bic.notnull}")
	@Size(min = 8, max = 11, message = "{bankeinzug.bic.size}")
	@Pattern(regexp = "[A-Z]{6}[\\w]{2}[\\w]*", message = "{bankeinzug.bic.pattern}")
	private String bic;

	public Bankeinzug(String vorname, String nachname, String iban, String bic) {
		super(vorname, nachname);
		this.iban = iban;
		this.bic = bic;
	}
	
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	
	@Override
	public String toString() {
		return "Bankeinzug [iban=" + iban + ", bic=" + bic + ", toString()="
				+ super.toString() + "]";
	}
		
}
