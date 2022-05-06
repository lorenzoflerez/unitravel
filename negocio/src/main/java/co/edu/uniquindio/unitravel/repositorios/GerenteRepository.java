package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer> {

    @Query("select g from Gerente g where g.email = :email and g.password = :password")
    Optional<Gerente> validarGerente(String email, String password);

    @Query("select g from Gerente g join g.hoteles h where h.ciudad.idCiudad = :idCiudad")
    List<Gerente> listarGerentesCiudad(Integer idCiudad);
}