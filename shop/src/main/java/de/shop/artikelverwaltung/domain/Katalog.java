package de.shop.artikelverwaltung.domain;

import java.util.List;

public class Katalog {
	
	private List<Artikel> artikel;

	public Katalog() {
		super();
	}

	public List<Artikel> getArtikel() {
		return artikel;
	}

	public void setArtikel(List<Artikel> artikel) {
		this.artikel = artikel;
	}

	@Override
	public String toString() {
		return "Katalog [artikel=" + artikel + "]";
	}
}
