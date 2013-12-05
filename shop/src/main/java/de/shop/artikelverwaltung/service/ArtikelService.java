package de.shop.artikelverwaltung.service;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.util.interceptor.Log;
import de.shop.util.Mock;

@Log
public class ArtikelService {

	public Artikel findArtikelById(Long id) {
		// TODO id pruefen
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findArtikelById(id);
	}
	
	public Artikel createArtikel(Artikel artikel) {
		if (artikel == null) {
			return artikel;
		}

		artikel = Mock.createArtikel(artikel);
		return artikel;
	}
	
	public void updateArtikel(Artikel artikel) {
		Mock.updateArtikel(artikel);
	}
}
