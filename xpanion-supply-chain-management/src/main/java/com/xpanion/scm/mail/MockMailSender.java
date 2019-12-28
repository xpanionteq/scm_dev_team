package com.xpanion.scm.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xpanion.scm.dao.MailSender;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

public class MockMailSender implements MailSender {
	
	private static final Logger log = LoggerFactory.getLogger(MockMailSender.class);

	@Override
	public void send(String to, String subject, String body) {
		
		log.info("Sending MOCK mail to " + to);
		log.info("with subject " + subject);
		log.info("and body " + body);
	}

}
