package de.shop.artikelverwaltung.service;

import de.shop.artikelverwaltung.domain.Artikel;
import util.cdi.MockService;
import util.interceptor.Log;

@MockService
@Log
public class ArtikelServiceMock extends ArtikelService {

	@Override
	public Artikel findArtikelById(Long id) {
		final Artikel artikel = new Artikel();
		artikel.setId(id);
		artikel.setName("Bezeichnung_" + id + "_Mock");
		return artikel;
	}
}