package de.shop.artikelverwaltung.service;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.fest.util.Strings;
import org.jboss.logging.Logger;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.util.interceptor.Log;

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
	
	public List<Artikel> findVerfuegbareArtikel()
	{
		return em.createNamedQuery(Artikel.FIND_VERFUEGBARE_ARTIKEL, Artikel.class)
				.getResultList();
	}
	
	
	@NotNull(message = "{artikel.notFound.id}")
	public Artikel findArtikelById(Long id) {
		return em.find(Artikel.class, id);
	}
	
	public List<Artikel> findArtikelByName(String name)
	{
		if (Strings.isNullOrEmpty(name))
			return findVerfuegbareArtikel();
		
		return em.createNamedQuery("FIND_ARTIKEL_BY_NAME", Artikel.class)
				.setParameter(Artikel.PARAM_NAME,"%"+ name + "%")
				.getResultList();
	}
	
	public Artikel createArtikel(Artikel artikel) {
		if (artikel == null) {
			return artikel;
		}

		//artikel = Mock.createArtikel(artikel);
		return artikel;
	}
	
	public void updateArtikel(Artikel artikel) {
		//Mock.updateArtikel(artikel);
	}
	
	public List<Artikel> findArtikelByIds(List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return Collections.emptyList();
		}
		
		/*
		 * SELECT a
		 * FROM   Artikel a
		 * WHERE  a.id = ? OR a.id = ? OR ...
		 */
		final CriteriaBuilder builder = em.getCriteriaBuilder();
		final CriteriaQuery<Artikel> criteriaQuery = builder.createQuery(Artikel.class);
		final Root<Artikel> a = criteriaQuery.from(Artikel.class);

		final Path<Long> idPath = a.get("id");
		//final Path<String> idPath = a.get(Artikel_.id);   // Metamodel-Klassen funktionieren nicht mit Eclipse
		
		Predicate pred = null;
		if (ids.size() == 1) {
			// Genau 1 id: kein OR notwendig
			pred = builder.equal(idPath, ids.get(0));
		}
		else {
			// Mind. 2x id, durch OR verknuepft
			final Predicate[] equals = new Predicate[ids.size()];
			int i = 0;
			for (Long id : ids) {
				equals[i++] = builder.equal(idPath, id);
			}
			
			pred = builder.or(equals);
		}
		
		criteriaQuery.where(pred);
		
		return em.createQuery(criteriaQuery)
		         .getResultList();
	}
}
