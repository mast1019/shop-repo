package de.shop.kundenverwaltung.service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.constraints.NotNull;

import org.jboss.logging.Logger;

import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.util.interceptor.Log;
import de.shop.util.Mock;

@Log
public class KundeService {
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}

	public AbstractKunde findKundeById(Long id) {
		if (id == null) {
			return null;
		}
		// TODO Datenbanzugriffsschicht statt Mock
		final AbstractKunde kunde = Mock.findKundeById(id);
		return kunde;
	}
	
	public List<AbstractKunde> findAllKunden() {
		// TODO Datenbanzugriffsschicht statt Mock
		final List<AbstractKunde> kunden = Mock.findAllKunden();
		return kunden;
	}
	
	/**
	 */
	public List<AbstractKunde> findKundenByNachname(String nachname) {
		// TODO Datenbanzugriffsschicht statt Mock
		final List<AbstractKunde> kunden = Mock.findKundenByNachname(nachname);
		return kunden;
	}

	@NotNull(message = "{kunde.notFound.email}") 
	public AbstractKunde findKundeByEmail(String email) { 
		if (email == null) { 
			return null; 
		} 
		// TODO Datenbanzugriffsschicht statt Mock 
		return Mock.findKundeByEmail(email);
	}
	
	
	public <T extends AbstractKunde> T createKunde(T kunde) {
		if (kunde == null) {
			return kunde;
		}

		// Pruefung, ob die Email-Adresse schon existiert
		// TODO Datenbanzugriffsschicht statt Mock

//		final AbstractKunde tmp = findKundeByEmail(kunde.getEmail());
//		if (kunde != null)
//			throw new EmailExistsException(kunde.getEmail());

		kunde = Mock.createKunde(kunde);

		return kunde;
	}

	public <T extends AbstractKunde> T updateKunde(T kunde) {
		if (kunde == null) {
			return null;
		}

		// Pruefung, ob die Email-Adresse schon existiert
		final AbstractKunde vorhandenerKunde = Mock.findKundeByEmail(kunde.getEmail());

		// Gibt es die Email-Adresse bei einem anderen, bereits vorhandenen Kunden?
		if (vorhandenerKunde.getId().longValue() != kunde.getId().longValue()) {
			throw new EmailExistsException(kunde.getEmail());
		}
		
		// TODO Datenbanzugriffsschicht statt Mock
		Mock.updateKunde(kunde);
		
		return kunde;
	}

	public void deleteKunde(Long kundeId) {
		final AbstractKunde kunde = findKundeById(kundeId);
		if (kunde == null) {
			return;
		}

		// Gibt es Bestellungen?
		if (!kunde.getBestellungen().isEmpty()) {
			throw new KundeDeleteBestellungException(kunde);
		}
		
		// TODO Datenbanzugriffsschicht statt Mock
		Mock.deleteKunde(kundeId);
	}
}
