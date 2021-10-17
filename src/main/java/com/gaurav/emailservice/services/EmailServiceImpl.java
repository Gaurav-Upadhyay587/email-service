package com.gaurav.emailservice.services;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.gaurav.emailservice.beans.Mail;

@Service("mailService")
public class EmailServiceImpl implements EmailService {
	
	@Autowired
    private JavaMailSender mailSender;

	@Override
	public void sendEmail(Mail mail) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setSubject(mail.getMailSubject());
		mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom()));
		mimeMessageHelper.setTo(new InternetAddress(mail.getMailTo()));
		mimeMessageHelper.setText(mail.getMailContent());
		if(mail.getMailCc() != null)
		mimeMessageHelper.setCc(new InternetAddress(mail.getMailCc()));
		if(mail.getMailBcc() != null)
		mimeMessageHelper.setBcc(new InternetAddress(mail.getMailBcc()));
		
		
		
		mailSender.send(mimeMessageHelper.getMimeMessage());

	}

}
