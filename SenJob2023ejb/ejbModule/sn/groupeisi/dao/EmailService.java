package sn.groupeisi.dao;

import java.util.Properties;

import jakarta.ejb.Stateless;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;



@Stateless
public class EmailService {
	
	 public void sendEmail(String to, String subject, String body) throws MessagingException {
        // Obtenez une session de messagerie à l'aide de javax.mail.Session
        Session session = Session.getInstance(getEmailProperties());

        // Créer un message MIME
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("boufitmboro@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);

        // Envoyer le message
        Transport.send(message);
    }

    private Properties getEmailProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.example.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return props;
    }
}
