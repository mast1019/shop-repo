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
}
