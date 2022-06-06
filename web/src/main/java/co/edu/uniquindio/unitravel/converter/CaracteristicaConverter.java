package co.edu.uniquindio.unitravel.converter;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.servicios.HotelService;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class CaracteristicaConverter implements Converter<Caracteristica>, Serializable {

    private final HotelService hotelService;

    public CaracteristicaConverter(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public Caracteristica getAsObject(FacesContext context, UIComponent component, String value) {
        Caracteristica caracteristica = null;
        try {
            caracteristica = hotelService.buscarCaracteristicaPorId(Integer.parseInt(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return caracteristica;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Caracteristica value) {
        return (value != null) ? value.getCaracteristica().toString() : "";
    }
}
