package com.prototype.pryt3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactNotification(String name, String email, String messageContent) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("Ur Destination Email");
        message.setSubject("📩 New Contact Form Submission");
        message.setText("You received a message:\n\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Message:\n" + messageContent);

        mailSender.send(message);
    }
}
