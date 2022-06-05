package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.Region;
import co.edu.uniquindio.unitravel.servicios.AdministradorService;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class RegionConverter implements Converter<Region>, Serializable {

    private final AdministradorService administradorService;

    public RegionConverter(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @Override
    public Region getAsObject(FacesContext context, UIComponent component, String value) {
        Region region = null;
        try {
            region = administradorService.buscarRegionPorId(Integer.parseInt(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Region value) {
        return (value != null) ? value.getIdRegion().toString() : "";
    }


}
