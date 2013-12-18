package de.shop.artikelverwaltung.service;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import org.jboss.logging.Logger;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.util.interceptor.Log;
import de.shop.util.Mock;

@Log
@Dependent
public class ArtikelService implements Serializable {

	private static final long serialVersionUID = -338525630375478955L;
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@Inject
	private transient EntityManager em;
	
	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}
	
	@NotNull(message = "{artikel.notFound.id}")
	public Artikel findArtikelById(Long id) {
		return em.find(Artikel.class, id);
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
