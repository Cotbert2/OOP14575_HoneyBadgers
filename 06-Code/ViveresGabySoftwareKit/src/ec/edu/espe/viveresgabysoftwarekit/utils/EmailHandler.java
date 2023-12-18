package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class EmailHandler {
    private static String emailFrom = "viveresgabystore@gmail.com";
    private static String passwd = "xigm jusa pszn jika";


    private final Properties properties;
    private final Session session;

    public EmailHandler() throws MessagingException {
        properties = new Properties();


        //SMTP Configuration (Simple Mail Transfer Protocol
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.user",emailFrom);
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.setProperty("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(properties);

    }

    public void sendNewEmail (String emailTo, String subject, String message) throws MessagingException{
        try {
            MimeMessage email = new MimeMessage(session);
            email.setFrom(new InternetAddress(emailFrom));
            email.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            email.setSubject(subject);
            email.setText(message, "ISO-8859-1", "html");


        } catch (AddressException e) {
            e.getCause();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, passwd);
            }
        });

        try {
            MimeMessage email = new MimeMessage(session);
            email.setFrom(new InternetAddress(emailFrom));
            email.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            email.setSubject(subject);
            email.setText(message);

            Transport.send(email);
            System.out.println("The email was successfully send!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
