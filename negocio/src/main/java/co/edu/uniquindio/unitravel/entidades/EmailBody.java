package co.edu.uniquindio.unitravel.entidades;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
public class EmailBody {

    @Getter @Setter
    private String remitente;

    @Getter @Setter
    private String contenido;

    @Getter @Setter
    private String destinatario;

    @Getter @Setter
    private String asunto;

    public EmailBody(String remitente, String contenido, String destinatario, String asunto) {
        this.remitente = remitente;
        this.contenido = contenido;
        this.destinatario = destinatario;
        this.asunto = asunto;
    }
}
