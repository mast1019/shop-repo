package de.shop.bestellverwaltung.domain;

public class Bankeinzug extends AbstractZahlung {
	
	private String iban;
	private String bic;

	public Bankeinzug(String name, String iban, String bic) {
		super(name);
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