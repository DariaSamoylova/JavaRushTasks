package com.javarush.task;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

/**
 * Created by mr_ma on 20.03.2018.
 */


public class TestClass  {

      private   static Properties mailServerProperties;
        static Session getMailSession;
        static MimeMessage generateMailMessage;
      public static void main(String args[]) throws AddressException, MessagingException {


          for(int i=1;i<=100;i++){
              if(i%15==0){
                 System.out.println("Fifteenyyyccc");
                 continue;
              } else if(i%5==0){
                  System.out.println("Fif ");
              }
              else if(i%3==0){
                  System.out.println("tree");
                                 }
                                 else
                  System.out.println(i);

          }

    }

    void a(Integer ggg){

    }

    public static void generateAndSendEmail() throws AddressException, MessagingException {

        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("daria.borodina@gmail.com"));
        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("daria.borodina@gmail.com"));
        generateMailMessage.setSubject("Greetings from Crunchify..");
        String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
        generateMailMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "daria.borodina@gmail.com", "a0G5u3S1taDOMDOM");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

}


