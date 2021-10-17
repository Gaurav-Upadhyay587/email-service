package com.gaurav.emailservice.services;

import javax.mail.MessagingException;

import com.gaurav.emailservice.beans.Mail;

public interface EmailService {
	public void sendEmail(Mail mail) throws MessagingException;
}
