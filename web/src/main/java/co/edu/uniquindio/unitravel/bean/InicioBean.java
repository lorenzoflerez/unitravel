package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.HotelService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Component
@Getter
@Setter
public class InicioBean implements Serializable {

    @Getter @Setter
    public String mensaje = "Pfff";

    private final HotelService hotelService;

    @Getter @Setter
    private List<Hotel> hotelList;

    @PostConstruct
    public void inicializar(){
        hotelList = hotelService.listarHoteles();
    }

    public InicioBean(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public String irDetalleHotel(String codigoHotel){
        System.out.println("Voyy");
        return "detalle_hotel?faces-redirect=true&amp;busqueda="+codigoHotel;
    }
}
