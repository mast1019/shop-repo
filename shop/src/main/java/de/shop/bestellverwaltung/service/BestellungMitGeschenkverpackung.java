package de.shop.bestellverwaltung.service;

import java.util.List;
import java.util.Locale;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.AbstractKunde;

@Decorator
public abstract class BestellungMitGeschenkverpackung implements
		BestellungService {

	@Inject
	@Delegate
	@Any
	private BestellungService bestellungService;

	public BestellungMitGeschenkverpackung() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Bestellung findBestellungById(Long id) {
		// TODO Auto-generated method stub
		return bestellungService.findBestellungById(id);
	}

	@Override
	public List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
		// TODO Auto-generated method stub
		return bestellungService.findBestellungenByKunde(kunde);
	}

	@Override
	public Bestellung createBestellung(Bestellung bestellung) {
		// TODO Auto-generated method stub
		return bestellungService.createBestellung(bestellung);
	}

	@Override
	public Bestellung createBestellung(Bestellung bestellung,
			AbstractKunde kunde, Locale locale) {
		// TODO Auto-generated method stub
		return bestellungService.createBestellung(bestellung, kunde, locale);
	}

	@Override
	public Bestellung updateBestellung(Bestellung bestellung) {
		// TODO Auto-generated method stub
		return bestellungService.updateBestellung(bestellung);
	}

}
