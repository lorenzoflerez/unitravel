package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.servicios.ClienteService;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {

    @Getter @Setter
    private String busqueda;


    //@Value("#{param['busqueda']}")
    private String busquedaParametro;

    private final ClienteService clienteService;

    @Getter @Setter
    private Cliente cliente;

    @Autowired
    public BusquedaBean(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostConstruct
    public void inicializar() {
        cliente = new Cliente();
        try {
            if (busquedaParametro != null && !busquedaParametro.isEmpty()) {
                cliente = clienteService.buscarClienteEmail(busquedaParametro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String buscarClientePorId() throws Exception {
        return "resultadosBusqueda?faces-redirect=true&amp;busqueda="+busqueda;
    }

    public String buscarClienteNickname() throws Exception {
        return "resultadosBusqueda?faces-redirect=true&amp;busqueda="+busqueda;
    }

    public String buscarClienteEmail () throws Exception {
        return "resultadosBusqueda?faces-redirect=true&amp;busqueda="+busqueda;
    }
}