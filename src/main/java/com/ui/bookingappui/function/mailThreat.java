package com.ui.bookingappui.function;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class mailThreat implements Runnable {
    private String toEmail;
    private String content;

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void sendMail(String toEmail, String content) throws MessagingException {
        String fromEmail = "bookingappui@gmail.com";
        String fromEmailPassword = "atfarynzhusoprbq";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");


        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, fromEmailPassword);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject("From bookingApp hihi.");
        message.setText(content);

        Transport.send(message);
        System.out.println("Send mail success.");


    }

    @Override
    public void run() {

        try {
            sendMail(toEmail, content);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
