package de.shop.bestellverwaltung.service;

import java.util.List;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.bestellverwaltung.domain.Lieferung;
import de.shop.kundenverwaltung.domain.AbstractKunde;

public interface BestellungService {
	public enum FetchType { NUR_BESTELLUNG, MIT_LIEFERUNGEN }
	Bestellung findBestellungById(Long id);
	Bestellung findBestellungById(Long id, FetchType fetch);
	List<Bestellung> findBestellungenByKunde(AbstractKunde kunde);
	Bestellung createBestellung(Bestellung bestellung, Long kundeId);
	Bestellung createBestellung(Bestellung bestellung, AbstractKunde kunde);
	Bestellung updateBestellung(Bestellung bestellung);
	AbstractKunde findKundeById(Long id);
	List<Bestellung> findBestellungenByIds(List<Long> ids, FetchType fetch);
	List<Artikel> ladenhueter(int anzahl);
	List<Lieferung> findLieferungen(String nr);
	Lieferung createLieferung(Lieferung lieferung, List<Bestellung> bestellungen);
}
