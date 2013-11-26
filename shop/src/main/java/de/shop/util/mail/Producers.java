package de.shop.util.mail;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class Producers {

	@Resource(name = "absenderMail")
	@Produces
	@AbsenderMail
	private String absenderMail;
	
	@Resource(name = "absenderName")
	@Produces
	@AbsenderName
	private String absenderName;
}
