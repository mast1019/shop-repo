package de.shop.artikelverwaltung.service;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.util.cdi.MockService;
import de.shop.util.interceptor.Log;

@MockService
@Log
public class ArtikelServiceMock extends ArtikelService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5302107556277473090L;

	@Override
	public Artikel findArtikelById(Long id) {
		final Artikel artikel = new Artikel();
		artikel.setId(id);
		artikel.setName("Bezeichnung_" + id + "_Mock");
		return artikel;
	}
}
