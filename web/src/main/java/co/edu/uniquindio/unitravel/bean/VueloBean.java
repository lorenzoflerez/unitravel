package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.servicios.AdministradorService;
import co.edu.uniquindio.unitravel.servicios.VueloService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Component
@Getter
@Setter
public class VueloBean implements Serializable {

    private final VueloService vueloService;
    private final AdministradorService administradorService;

    @Getter @Setter
    private List<Vuelo> vuelos;

    @Getter @Setter
    private List<Vuelo> vuelos2;

    @Getter @Setter
    private Vuelo vuelo;

    public VueloBean(VueloService vueloService, AdministradorService administradorService) {
        this.vueloService = vueloService;
        this.administradorService = administradorService;
    }

    @PostConstruct
    public void init() {
        vuelo = new Vuelo();
        vuelos = vueloService.listarVuelos();
    }

    public void guardarVuelo(){
        try{
            vueloService.registrarVuelo(vuelo);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado el vuelo");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void actualizarVuelo(){
        try{
            vueloService.actualizarVuelo(vuelo);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha actualizado el vuelo");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void eliminarVuelo(){
        try{
            vueloService.eliminarVuelo(vuelo.getIdVuelo());
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha eliminado el vuelo");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }
}
