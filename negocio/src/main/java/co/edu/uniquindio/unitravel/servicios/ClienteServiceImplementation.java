package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImplementation implements ClienteService{

    private final ClienteRepository clienteRepository;

    public ClienteServiceImplementation(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {
        Optional<Cliente> clienteBuscado = clienteRepository.findById(cliente.getId());
        if(clienteBuscado.isPresent())
            throw new Exception("El código ya se encuentra registrado");
        clienteBuscado = clienteRepository.buscarClienteEmail(cliente.getEmail());
        if(clienteBuscado.isPresent())
            throw new Exception("El email ya se encuentra registrado");
        clienteBuscado = clienteRepository.buscarClienteNickname(cliente.getNickname());
        if(clienteBuscado.isPresent())
            throw new Exception("El nickname ya se encuentra registrado");
        cliente.setFechaRegistro(LocalDateTime.now());
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception {
        buscarClientePorId(cliente.getId());
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) throws Exception {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if (cliente.isEmpty())
            throw new Exception("El código no se encuentra registrado");
        return cliente.get();
    }

    @Override
    public void eliminarCliente(Integer idCliente) throws Exception {
        buscarClientePorId(idCliente);
        clienteRepository.deleteById(idCliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente validarCliente(String email, String password) throws Exception {
        return clienteRepository.validarCliente(email, password)
                .orElseThrow(()->new Exception("Los datos de autenticación son incorrectos"));
    }

    @Override
    public Cliente buscarClienteNickname(String nickname) throws Exception {
        return clienteRepository.buscarClienteNickname(nickname)
                .orElseThrow(()->new Exception("Los datos de autenticación son incorrectos"));
    }

    @Override
    public Cliente buscarClienteEmail(String email) throws Exception {
        return clienteRepository.buscarClienteEmail(email)
                .orElseThrow(()-> new Exception("El email no se encuentra registrado"));
    }

    @Override
    public Cliente buscarClienteTelefono(String telefono) throws Exception {
        return clienteRepository.findClienteByTelefonos(telefono)
                .orElseThrow(()-> new Exception("El teléfono no se encuentra registrado"));
    }

    @Override
    public List<Object[]> contarClientesPorCiudad() {
        return clienteRepository.contarClientesPorCiudad();
    }

    @Override
    public Cliente registrarTelefono(Cliente cliente, String telefono) throws Exception {
        Cliente clienteBuscado = buscarClientePorId(cliente.getId());
        List<String> telefonos = clienteBuscado.getTelefonos();
        if(telefonos.contains(telefono))
            throw new Exception("El teléfono ya se encuentra registrado");
        telefonos.add(telefono);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarTelefono(Cliente cliente, String antiguo, String nuevo) throws Exception {
        Cliente clienteBuscado = buscarClientePorId(cliente.getId());
        List<String> telefonos = clienteBuscado.getTelefonos();
        if(!telefonos.contains(antiguo))
            throw new Exception("El teléfono no se encuentra registrado");
        telefonos.remove(antiguo);
        telefonos.add(nuevo);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente eliminarTelefono(Cliente cliente, String telefono) throws Exception {
        Cliente clienteBuscado = buscarClientePorId(cliente.getId());
        List<String> telefonos = clienteBuscado.getTelefonos();
        if(!telefonos.contains(telefono))
            throw new Exception("El teléfono no se encuentra registrado");
        telefonos.remove(telefono);
        return clienteRepository.save(cliente);
    }

    @Override
    public List<String> listarTelefonosCliente(Cliente cliente) throws Exception{
        Cliente clienteBuscado = buscarClientePorId(cliente.getId());
        return new ArrayList<>();
        //return clienteRepository.listarTelefonosCliente(clienteBuscado.getId());
    }

    @Override
    public Cliente recuperarClaveDeAcceso(String email) throws Exception {
        return null;
    }
}
