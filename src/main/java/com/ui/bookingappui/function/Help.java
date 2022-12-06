package com.ui.bookingappui.function;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;



public class Help {

    public int[] innitialArray() {
        int[] array = new int[120];
        Arrays.setAll(array, i -> i + 1);
        return array;
    }

    public String[] initialAge() {
        int[] arr = innitialArray();
        String[] age = new String[120];
        for (int i = 0; i < 120; i++) {
            age[i] = Integer.toString(arr[i]);

        }
        return age;
    }

    public String renderId() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
    public void sendMail(String toEmail , String content){
        String fromEmail = "bookingappui@gmail.com";
        String fromEmailPassword = "atfarynzhusoprbq";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");


        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail,fromEmailPassword);
            }
        });
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
            message.setSubject("From bookingApp hihi.");
            message.setText(content);
            Transport.send(message);
            System.out.println("Send mail success.");



        }
        catch (Exception e){
            System.out.println("send mail error.");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Help s = new Help();
        s.sendMail("meotrangbeonknd@gmail.com","minhducnehihi");
    }


}
