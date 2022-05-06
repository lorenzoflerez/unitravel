package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.EmailBody;
import lombok.Getter;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.logging.Logger;

@Service
public class EmailServiceImplementation implements EmailService{

    private static final Logger LOGGER = Logger.getLogger(EmailServiceImplementation.class.toString());

    private final JavaMailSender mailSender;

    @Getter
    private MimeMessage mailMessage;

    public EmailServiceImplementation(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    private boolean enviar(EmailBody body){
        boolean status;
        mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
        try {
            helper.setFrom(body.getRemitente());
            helper.setTo(body.getDestinatario());
            helper.setSubject(body.getAsunto());
            helper.setText(body.getContenido(), true);
            mailSender.send(mailMessage);
            LOGGER.info("Mail enviado");
            status = true;
        } catch (MessagingException | MailException e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    @Override
    public boolean enviarEmail(EmailBody body) {
        LOGGER.info("Body : ".concat( body.toString() ));
        return enviar(body);
    }
}
