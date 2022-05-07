package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    Cliente buscarClientePorId(Integer idCliente) throws Exception;

    void eliminarCliente(Integer idCliente) throws Exception;

    List<Cliente> listarClientes();

    Optional<Cliente> validarCliente(String email, String password);

    Optional<Cliente> buscarClienteNombre(String nombre);

    Optional<Cliente> buscarClienteEmail(String email);

    Optional<Cliente> findClienteByTelefonos(String telefono);

    List<Object[]> contarClientesPorCiudad();

    String registrarTelefono(Cliente cliente, String telefono) throws Exception;

    String actualizarTelefono(Cliente cliente, String telefono) throws Exception;

    void eliminarTelefono(String telefono) throws Exception;

    List<String> listarTelefonosCliente();

    Cliente recuperarClaveDeAcceso(String email) throws Exception;
}
