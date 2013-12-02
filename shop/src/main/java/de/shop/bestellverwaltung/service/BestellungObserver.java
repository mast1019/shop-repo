package de.shop.bestellverwaltung.service;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jboss.logging.Logger;

import de.shop.bestellverwaltung.domain.Posten;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.AbstractKunde;
import de.shop.util.interceptor.Log;
import de.shop.util.mail.AbsenderMail;
import de.shop.util.mail.AbsenderName;

@ApplicationScoped
@Log
public class BestellungObserver {
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	private static final String NEWLINE = System.getProperty("line.separator");
	
	@Inject
	private transient Session session;
	
	@Inject
	@AbsenderMail
	private String absenderMail;
	
	@Inject
	@AbsenderName
	private String absenderName;

	@PostConstruct
	private void init() {
		if (absenderMail == null) {
			LOGGER.warn("Der Absender fuer Bestellung-Emails ist nicht gesetzt.");
			return;
		}
		LOGGER.infof("Absender fuer Bestellung-Emails: %s <%s>", absenderName, absenderMail);
	}
	
	public void onCreateBestellung(@Observes @NeueBestellung Bestellung bestellung) {
		final AbstractKunde kunde = bestellung.getKundenid();
		final String empfaengerMail = kunde.getEmail();
		if (absenderMail == null || empfaengerMail == null) {
			return;
		}
		final String vorname = kunde.getVorname() == null ? "" : kunde.getVorname();
		final String empfaengerName = vorname + " " + kunde.getNachname();
		
		final MimeMessage message = new MimeMessage(session);

		try {
			// Absender setzen
			final InternetAddress absenderObj = new InternetAddress(absenderMail, absenderName);
			message.setFrom(absenderObj);
			
			// Empfaenger setzen
			final InternetAddress empfaenger = new InternetAddress(empfaengerMail, empfaengerName);
			message.setRecipient(RecipientType.TO, empfaenger);   // RecipientType: TO, CC, BCC

			// Subject setzen
			message.setSubject("Neue Bestellung Nr. " + bestellung.getBestellnummer());
			
			// Text setzen mit MIME Type "text/plain"
			final StringBuilder sb = new StringBuilder(256);
			sb.append("<h3>Neue Bestellung Nr. <b>" + bestellung.getBestellnummer() + "</b></h3>" + NEWLINE);
			for (Posten p : bestellung.getPosten()) {
				sb.append(p.getAnzahl() + "\t" + p.getArtikel().getName() + "<br/>" + NEWLINE);
			}
			final String text = sb.toString();
			LOGGER.trace(text);
			message.setContent(text, "text/html;charset=iso-8859-1");

			// Hohe Prioritaet einstellen
			//message.setHeader("Importance", "high");
			//message.setHeader("Priority", "urgent");
			//message.setHeader("X-Priority", "1");

			Transport.send(message);
		}
		catch (MessagingException | UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
			return;
		}
	}
}
