package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.servicios.AdministradorService;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class CiudadConverter implements Converter<Ciudad>, Serializable {

    private final AdministradorService administradorService;

    public CiudadConverter(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @Override
    public Ciudad getAsObject(FacesContext context, UIComponent component, String value) {
        Ciudad ciudad = null;
        try {
            ciudad = administradorService.buscarCiudadPorId(Integer.parseInt(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ciudad;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Ciudad value) {
        return (value != null) ? value.getIdCiudad().toString() : "";
    }
}
