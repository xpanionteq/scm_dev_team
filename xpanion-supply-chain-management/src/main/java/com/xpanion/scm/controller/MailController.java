package com.xpanion.scm.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpanion.scm.dao.MailSender;

@RestController
public class MailController {

	@Autowired
	private JavaMailSender sender;

	private MailSender mailSender;

	public MailController(MailSender smtp) {
		this.mailSender = smtp;
	}

	@RequestMapping("/mail")
	public String mail() throws MessagingException {

		mailSender.send("ashlinash777@gmail.com", "Test Mail", "Good morning and have a nice day");
		/*
		 * System.out.println(
		 * "=======================================================================");
		 */
		return "Mail sent";
	}

	@RequestMapping("/sendMailAtt")
	public String sendMailAttachment() throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		try {
			helper.setTo("ashlinash777@gmail.com");
			helper.setText("good morning and have a nice day ");
			helper.setSubject("Test Mail From ash");
			ClassPathResource file = new ClassPathResource("new.jpg");
			helper.addAttachment("new.jpg", file);
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		sender.send(message);
		return "Mail Sent Success!";
	}
}
