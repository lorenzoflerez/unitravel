package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    Cliente buscarClientePorId(Integer idCliente) throws Exception;

    void eliminarCliente(Integer idCliente) throws Exception;

    List<Cliente> listarClientes();

    Cliente validarCliente(String email, String password) throws Exception;

    Cliente buscarClienteNickname(String nickname) throws Exception;

    Cliente buscarClienteEmail(String email) throws Exception;

    Cliente buscarClienteTelefono(String telefono) throws Exception;

    List<Object[]> contarClientesPorCiudad();

    Cliente registrarTelefono(Cliente cliente, String telefono) throws Exception;

    Cliente actualizarTelefono(Cliente cliente, String antiguo, String nuevo) throws Exception;

    Cliente eliminarTelefono(Cliente cliente, String telefono) throws Exception;

    List<String> listarTelefonosCliente(Cliente cliente) throws Exception;

    Cliente recuperarClaveDeAcceso(String email) throws Exception;
}
