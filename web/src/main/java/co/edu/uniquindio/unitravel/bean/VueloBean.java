package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.servicios.VueloService;
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
public class VueloBean implements Serializable {

    private final VueloService vueloService;
    @Getter @Setter
    private List<Vuelo> vuelos;

    @Getter @Setter
    private Vuelo vuelo;

    public VueloBean(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @PostConstruct
    public void init() {
        vuelos = vueloService.listarVuelos();
    }
}
