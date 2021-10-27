/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ASUS
 */
public class MailUtil {
    

 public static void sendMail(String recipient, String name, String body) throws IOException {
  String to = recipient; // to address. It can be any like gmail, hotmail etc.
  final String from = "abchospital99"; // from address. As this is using Gmail SMTP.
  final String password = "1234Abcd"; // password for from mail address. 
 
  Properties prop = new Properties();
  prop.put("mail.smtp.host", "smtp.gmail.com");
  prop.put("mail.smtp.port", "465");
  prop.put("mail.smtp.auth", "true");
  prop.put("mail.smtp.socketFactory.port", "465");
  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 
  Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(from, password);
   }
  });
 
  try {
 
   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress(from));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
   message.setSubject("ABC HOSPITAL - the heart of your healthcare!");
    
   //String msg = "Hello! "+name+", Welcome to the ABC Healthcare Family.. Thank you for registering!!!";
    
   MimeBodyPart mimeBodyPart = new MimeBodyPart();
   mimeBodyPart.setContent(body, "text/html");
     
   Multipart multipart = new MimeMultipart();
   multipart.addBodyPart(mimeBodyPart);
    
   //MimeBodyPart attachmentBodyPart = new MimeBodyPart();
   //attachmentBodyPart.attachFile(new File("E://Tools//Screenshot.JPG"));
   //multipart.addBodyPart(attachmentBodyPart);
   message.setContent(multipart);
 
   Transport.send(message);
 
   System.out.println("Mail successfully sent..");
 
  } catch (MessagingException e) {
   e.printStackTrace();
  }
 }
}
