package com.example.resturent.service;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    public boolean sendEmail(String subject, String message, String to) {
        boolean f = false;
        String from = "realpizza98@gmail.com";

        // Gmail SMTP configuration
        String host = "smtp.gmail.com";
        String port = "587";

        // Gmail authentication
        String username = "realpizza98@gmail.com";
        String password = "vvgqpldbdzcacjit"; // Update with your actual Gmail account password

        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create an authenticator for username and password
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // Create a session with the properties and authenticator
        Session session = Session.getInstance(properties, authenticator);

        try {
            // Create a new email message
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(from));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            emailMessage.setSubject(subject);
            emailMessage.setText(message);

            // Send the email
            Transport.send(emailMessage);

            System.out.println("Email sent successfully.");
            f = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return f;
    }
}

