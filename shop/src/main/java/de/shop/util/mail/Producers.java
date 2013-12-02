package de.shop.util.mail;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.Serializable;

@ApplicationScoped
public class Producers implements Serializable {
	private static final long serialVersionUID = -2268537844617690370L;

	@Resource(name = "absenderMail")
	@Produces
	@AbsenderMail
	private String absenderMail;
	
	@Resource(name = "absenderName")
	@Produces
	@AbsenderName
	private String absenderName;
}
