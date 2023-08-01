/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.File;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author XaviO_o
 */
public class envioCorreo {

    private static String emailFrom = "upsproyectoveterinaria@gmail.com";
    private static String passwordFrom = "aivhqniymyvyxazf";
    private String emailTo;
    private String subject;

    private Properties mProperties = new Properties();
    private Session mSession =  null;
    private MimeMessage mCorreo = null;
    private File mArchivosAdjuntos;
   // private String nombres_archivos;

    public envioCorreo(String emailTo, String subject, File mArchivosAdjuntos) {
        this.emailTo = emailTo;
        this.subject = subject;
        this.mArchivosAdjuntos = mArchivosAdjuntos;
    }

    

    public void enviarCorreo(String content) {
        // Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);
        try {
            MimeMultipart mElementosCorreo = new MimeMultipart();
            // contenido del correo
            MimeBodyPart mcontenido = new MimeBodyPart();
            mcontenido.setContent(content, "txt/html; charser=utf-8");
            mElementosCorreo.addBodyPart(mcontenido);

            //Agregar archivos adjuntos
            MimeBodyPart mAdjuntos = null;
            mAdjuntos = new MimeBodyPart();
            mAdjuntos.setDataHandler(new DataHandler(new FileDataSource(mArchivosAdjuntos.getAbsolutePath())));
            mAdjuntos.setFileName(mArchivosAdjuntos.getName());
            mElementosCorreo.addBodyPart(mAdjuntos);

            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setContent(mElementosCorreo);
            //mCorreo.setText(content, "ISO-8859-1", "html");

        } catch (AddressException ex) {
            System.out.println(ex);
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }

    public void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            JOptionPane.showMessageDialog(null, "Correo enviado");
        } catch (NoSuchProviderException ex) {
            System.out.println(ex);
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }
}
