/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ACER
 */
public class EmailSender {
    private static final String SENDEREMAIL = "anhnqhe151349@fpt.edu.vn";        // Your email here
    private static final String EMAILPASSWORD = "bbb123456";      // Your password here
    public static boolean sendMail(String to, String subject, String body) {
        try { 
            Properties pros = new Properties();
            pros.put("mail.transport.protocol", "smtps");
            pros.put("mail.smtps.host", "smtp.gmail.com");
            pros.put("mail.smtps.port", 465);
            pros.put("mail.smtps.auth", "true");
            pros.put("mail.smtps.quitwait", "false");
            Session session = Session.getDefaultInstance(pros);
            session.setDebug(true);
            Message message = new MimeMessage(session);
            message.setSubject(subject);
            message.setContent(body, "text/html");

            Address sender = new InternetAddress(SENDEREMAIL, "BeDev");
            Address receiver = new InternetAddress(to);
            message.setFrom(sender);
            message.setRecipient(Message.RecipientType.TO, receiver);
            try {
                Transport tt = session.getTransport(); // acqruiring a connection to remote server
                tt.connect(SENDEREMAIL, EMAILPASSWORD);
                tt.sendMessage(message, message.getAllRecipients());
                return true;
            } catch (MessagingException e) {
                System.out.println(e);
                return false;
            }
        } catch (MessagingException | UnsupportedEncodingException e) {
            System.out.println(e);
            return false;
        }
    }
}
