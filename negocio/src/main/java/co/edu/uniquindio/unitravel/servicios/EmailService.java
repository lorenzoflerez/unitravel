package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.EmailBody;

public interface EmailService {
    boolean enviarEmail(EmailBody body);
}

