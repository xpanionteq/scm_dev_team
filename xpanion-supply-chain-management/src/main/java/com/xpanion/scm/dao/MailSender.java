package com.xpanion.scm.dao;

import javax.mail.MessagingException;

public interface MailSender {
	void send(String to, String subject, String body) throws MessagingException;
}
