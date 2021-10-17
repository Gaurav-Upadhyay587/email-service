package com.gaurav.emailservice;

import javax.mail.MessagingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.gaurav.emailservice.beans.Mail;
import com.gaurav.emailservice.services.EmailService;

@SpringBootApplication
public class EmailApp {

	public static void main(String[] args) {
			 
	        Mail mail = new Mail();
	        mail.setMailFrom("gupadhyay587@gmail.com");
	        mail.setMailTo("gupadhyay587@gmail.com");
	        mail.setMailSubject("Spring Boot - Email Example");
	        mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks\nwww.technicalkeeda.com");
	 
	        ApplicationContext ctx = SpringApplication.run(EmailApp.class, args);
	        EmailService mailService = (EmailService) ctx.getBean("mailService");
	        try {
				mailService.sendEmail(mail);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	 

	}

}
