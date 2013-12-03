package de.shop.bestellverwaltung.service;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.kundenverwaltung.service.KundeService;
import de.shop.util.interceptor.Log;
import de.shop.util.Mock;

@Log
@Dependent
public class BestellungServiceImpl implements BestellungService {
	
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@Inject
	private KundeService ks;
	
	@Inject
	@NeueBestellung
	private transient Event<Bestellung> event;
	
	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}
	
	@Override
	public Bestellung findBestellungById(Long id) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findBestellungById(id);
	}

	/**
	 * {inheritDoc}
	 */
	@Override
	public List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findBestellungenByKunde(kunde);
	}

	@Override
	public Bestellung createBestellung(Bestellung bestellung, AbstractKunde kunde, Locale locale) {
		// TODO Datenbanzugriffsschicht statt Mock
		bestellung = Mock.createBestellung(bestellung, kunde);
		event.fire(bestellung);
		
		return bestellung;
	}
	
	@Override
	public Bestellung createBestellung(Bestellung bestellung) {
		// TODO Datenbanzugriffsschicht statt Mock
		bestellung = Mock.createBestellung(bestellung);
		event.fire(bestellung);
		
		return bestellung;
	}
	
	@Override
	public Bestellung createBestellung(Bestellung bestellung, Long kundeId, Locale locale) {
		if (bestellung == null) {
			return null;
		}
		
		final AbstractKunde kunde = ks.findKundeById(kundeId);
		return createBestellung(bestellung, kunde, locale);
	}
	
	
	@Override
	public Bestellung updateBestellung(Bestellung bestellung) {
		Mock.updateBestellung(bestellung);
		
		return bestellung;
	}
	
}
