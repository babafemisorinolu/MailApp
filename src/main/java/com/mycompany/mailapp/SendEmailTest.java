/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mailapp;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author babafemi.sorinolu
 */
public class SendEmailTest {

    
    public static void main(String[] args) {
        System.out.println("sending a test mail");
        String to = "your_email@houghton.edu"; //recipient email
        String from = "react@serenaanthonyschool.com";
        String host = "mail.serenaanthonyschool.com"; // For Gmail - use "smtp.gmail.com"
        String password="react@123";  // For Gmail, create your APP password from this link - https://myaccount.google.com/apppasswords
        //You cant use your normal password
        
        // SMTP server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", host); 
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Create session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

         try {
            // Compose the message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Test Email from Java");
            message.setText("Hello, this is a test email sent using JavaMail API!");

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
      

      
    }

}
