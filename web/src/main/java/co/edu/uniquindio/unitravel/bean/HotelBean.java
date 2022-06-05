package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.HotelService;
import co.edu.uniquindio.unitravel.servicios.ReservaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class HotelBean implements Serializable {

    private final HotelService hotelService;
    private final ReservaService reservaService;

    @Getter @Setter
    private Hotel hotel;

    @Getter @Setter
    private Habitacion habitacion;

    @Getter @Setter
    private Cama cama;

    @Getter @Setter
    private Gerente gerente;

    @Getter @Setter
    private Caracteristica caracteristica;

    @Getter @Setter
    private Foto foto;

    @Setter @Getter
    private ReservaHabitacion reservaHabitacion;

    @Setter @Getter
    private List<Gerente> gerentes;

    @Setter @Getter
    private List<Hotel> hoteles;

    @Setter @Getter
    private List<ReservaHabitacion> reservas;

    public HotelBean(HotelService hotelService, ReservaService reservaService) {
        this.hotelService = hotelService;
        this.reservaService = reservaService;
    }

    @PostConstruct
    public void inicializar(){
        gerente =  new Gerente();
        hotel = new Hotel();
        habitacion = new Habitacion();
        cama = new Cama();
        caracteristica = new Caracteristica();
        foto = new Foto();
        reservaHabitacion = new ReservaHabitacion();
        gerentes = hotelService.listarGerentes();
        hoteles = hotelService.listarHoteles();
        reservas = reservaService.listarReservasHabitacion();
    }
}
