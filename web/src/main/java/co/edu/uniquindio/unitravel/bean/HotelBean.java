package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.HotelService;
import co.edu.uniquindio.unitravel.servicios.ReservaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private ReservaHabitacion reserva;

    @Setter @Getter
    private List<Gerente> gerentes;

    @Setter @Getter
    private List<Hotel> hoteles;

    @Setter @Getter
    private List<Foto> fotos;

    @Getter @Setter
    private List<Caracteristica> caracteristicas;

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
        reserva = new ReservaHabitacion();
        gerentes = hotelService.listarGerentes();
        hoteles = hotelService.listarHoteles();
        caracteristicas = hotelService.listarCaracteristicas();
        fotos = hotelService.listarFotos();
        reservas = reservaService.listarReservasHabitacion();
    }

    public void guardarGerente(){
        try{
            hotelService.registrarGerente(gerente);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado el gerente");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void actualizarGerente(){
        try{
            hotelService.actualizarGerente(gerente);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha actualizado el gerente");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void eliminarGerente() {
        try{
            hotelService.eliminarGerente(gerente.getId());
            this.gerente = null;
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_WARN, "Operación exitosa", "Se ha eliminado el gerente");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }
}
