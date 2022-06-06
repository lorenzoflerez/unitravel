package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.PaqueteService;
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
public class TourBean implements Serializable {

    private final PaqueteService paqueteService;

    private final ReservaService reservaService;


    public TourBean(PaqueteService paqueteService, ReservaService reservaService) {
        this.paqueteService = paqueteService;
        this.reservaService = reservaService;
    }

    @Getter @Setter
    private Guia guia;

    @Getter @Setter
    private Horario horario;

    @Getter @Setter
    private Lugar lugar;

    @Getter @Setter
    private PaqueteTuristico paquete;

    @Getter @Setter
    private ReservaPaquete reserva;

    @Getter @Setter
    private List<Guia> guias;

    @Getter @Setter
    private List<Horario> horarios;

    @Getter @Setter
    private List<PaqueteTuristico> paquetes;

    @Getter @Setter
    private List<Lugar> lugares;

    @Getter @Setter
    private List<ReservaPaquete> reservas;

    @PostConstruct
    public void inicializar(){
        guia = new Guia();
        horario = new Horario();
        lugar = new Lugar();
        paquete = new PaqueteTuristico();
        reserva = new ReservaPaquete();
        guias = paqueteService.listarGuias();
        horarios = paqueteService.listarHorarios();
        lugares = paqueteService.listarLugares();
        paquetes = paqueteService.listarPaquetesTuristicos();
        reservas = reservaService.listarReservasPaquete();
    }

    public void guardarGuia(){
        try{
            paqueteService.registrarGuia(guia);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado el guia turistico");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void actualizarGuia(){
        try{
            paqueteService.actualizarGuia(guia);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha actualizado el guia truistico");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void eliminarGuia() {
        try{
            paqueteService.eliminarGuia(guia.getId());
            this.guia = null;
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_WARN, "Operación exitosa", "Se ha eliminado el guia turistico");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void guardarLugar(){
        try{
            paqueteService.registrarLugar(lugar);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado el sitio de interes");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void actualizarLugar(){
        try{
            paqueteService.actualizarLugar(lugar);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha actualizado el sitio de interes");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void eliminarLugar() {
        try{
            paqueteService.eliminarLugar(lugar.getIdLugar());
            this.guia = null;
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_WARN, "Operación exitosa", "Se ha eliminado el sitio de interes");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void guardarHorario(){
        try{
            paqueteService.registrarHorario(horario);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado el horario");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void actualizarHorario(){
        try{
            paqueteService.actualizarHorario(horario);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha actualizado el horario");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void eliminarHorario() {
        try{
            paqueteService.eliminarHorario(horario.getIdHorario());
            this.guia = null;
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_WARN, "Operación exitosa", "Se ha eliminado el sitio de interes");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void guardarPaquete(){
        try{
            paqueteService.registrarPaqueteTuristico(paquete);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado el paquete turistico");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void actualizarPaquete(){
        try{
            paqueteService.actualizarPaqueteTuristico(paquete);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha actualizado el paquete turistico");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void eliminarPaquete() {
        try{
            paqueteService.eliminarPaqueteTuristico(paquete.getIdPaquete());
            this.guia = null;
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_WARN, "Operación exitosa", "Se ha eliminado el sitio de interes");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

}