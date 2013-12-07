package de.shop.bestellverwaltung.service;

import de.shop.util.AbstractShopException;

public abstract class AbstractBestellungServiceException extends AbstractShopException {
	private static final long serialVersionUID = 4925267690129059243L;

	public AbstractBestellungServiceException(String msg) {
		super(msg);
	}
	
	public AbstractBestellungServiceException(String msg, Throwable t) {
		super(msg, t);
	}
}
