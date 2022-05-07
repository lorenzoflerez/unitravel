package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("select c from Cliente c where c.email = :email and c.password = :password")
    Optional<Cliente> validarCliente(String email, String password);

    @Query("select c from Cliente c where c.email = :nombre")
    Optional<Cliente> buscarClienteNombre(String nombre);

    @Query("select c from Cliente c where c.email = :email")
    Optional<Cliente> buscarClienteEmail(String email);

    @Query("select c from Cliente c where c.telefonos = :telefono")
    Optional<Cliente> findClienteByTelefonos(String telefono);

    @Query("select c.ciudad.ciudad, count(c) from Cliente c group by c.ciudad")
    List<Object[]> contarClientesPorCiudad();
}