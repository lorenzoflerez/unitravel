package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepository;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepository clienteRepository;


    @Test
    public void registrar() {
        Ciudad ciudad = new Ciudad("armenia");
        Cliente cliente = new Cliente(1, "pepito", "perez", "pepe@gmail.com", "123", "pepe", ciudad);
        Cliente clienteGuardado = clienteRepository.save(cliente);

        Assertions.assertNotNull(clienteGuardado);
    }

    @Test
    public void eliminar() {
        Ciudad ciudad = new Ciudad("armenia");
        Cliente cliente = new Cliente(1, "pepito", "perez", "pepe@gmail.com", "123", "pepe", ciudad);
        Cliente clienteGuardado = clienteRepository.save(cliente);

        clienteRepository.delete(clienteGuardado);
        Cliente clienteBuscado = clienteRepository.findById(1).orElse(null);
        Assertions.assertNull(clienteBuscado);
    }

    @Test
    public void actualizar() {
        Ciudad ciudad = new Ciudad("armenia");
        Cliente cliente = new Cliente(1, "pepito", "perez", "pepe@gmail.com", "1234", "pepe", ciudad);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        clienteGuardado.setPassword("lolita");
        clienteRepository.save(clienteGuardado);

        Cliente clienteBuscado = clienteRepository.findById(1).orElse(null);

        Assertions.assertEquals("lolita", clienteBuscado.getPassword());

    }

    @Test
    public void listar() {
        Ciudad ciudad = new Ciudad("armenia");
        Cliente cliente = new Cliente(1, "pepito", "perez", "pepe@gmail.com", "1234", "pepe", ciudad);
        clienteRepository.save(cliente);

        List<Cliente> clientes = clienteRepository.findAll();
        System.out.println(clientes);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        System.out.println(clientes);
    }


}