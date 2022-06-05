package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Region;
import co.edu.uniquindio.unitravel.servicios.AdministradorService;
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
public class CiudadBean implements Serializable {

    private final AdministradorService administradorService;

    @Getter @Setter
    private Region region;

    @Getter @Setter
    private Ciudad ciudad;

    @Getter @Setter
    private List<Region> regiones;

    @Getter @Setter
    private List<Ciudad> ciudades;

    public CiudadBean(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostConstruct
    public void inicializar() {
        region = new Region();
        ciudad = new Ciudad();
        regiones = administradorService.listarRegiones();
        ciudades = administradorService.listarCiudades();
    }

    public void guardarRegion(){
        try{
            administradorService.registrarRegion(region);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado la región");
            FacesContext.getCurrentInstance().addMessage(null,msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,msj);
        }
    }

    public void actualizarRegion(){
        try{
            administradorService.actualizarRegion(region);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha actualizado la región");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void eliminarRegion() {
        try{
            administradorService.eliminarRegion(region.getIdRegion());
            this.region = null;
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_WARN, "Operacion exitosa", "Se ha eliminado la región");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void guardarCiudad(){
        try{
            administradorService.registrarCiudad(ciudad);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha registrado la ciudad");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void actualizarCiudad(){
        try{
            administradorService.actualizarCiudad(ciudad);
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Se ha actualizado la ciudad");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }

    public void eliminarCiudad() {
        try{
            administradorService.eliminarCiudad(ciudad.getIdCiudad());
            this.ciudad = null;
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_WARN, "Operacion exitosa", "Se ha eliminado la ciudad");
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }catch (Exception e){
            FacesMessage msj= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",msj);
        }
    }
}
