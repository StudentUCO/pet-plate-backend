package com.project.notification;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailNotification {
    public static void main(String[] args) throws Exception {
        // Configurar las propiedades del sistema
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");

        // Crear la sesión de correo electrónico
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                //return new PasswordAuthentication("brayanesqbesq@gmail.com", "hbkvoemcykvstbjy");
                return new PasswordAuthentication("brayanesqbesq@outlook.com", "gdnmimibhnqhqeht");
            }
        });

        // Crear un objeto MimeMessage vacío
        Message message = new MimeMessage(session);

        // Establecer los destinatarios del correo electrónico
        //message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("brayan.sepulveda4302@soyuco.edu.co"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("brayan.sepulveda4302@soyuco.edu.co"));

        // Establecer el asunto del correo electrónico
        message.setSubject("Prueba de correo electrónico");

        // Establecer el contenido del correo electrónico
        message.setText("Este es un correo electrónico de prueba enviado desde Java.");

        // Enviar el correo electrónico
        Transport.send(message);
    }
}
