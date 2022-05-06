package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Guia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuiaRepository extends JpaRepository<Guia, Integer> {

    @Query("select g from Guia g where g.email = :email and g.password = :password")
    Optional<Guia> validarGuia(String email, String password);

    @Query("select g from Guia g where g.nombre like concat('%', :nombre, '%')")
    List<Guia> listarGuiaNombre(String nombre);
}