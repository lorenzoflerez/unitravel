package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

    @Query("select c from Ciudad c where c.region.idRegion = :idRegion")
    List<Ciudad> listarCiudadesRegion(Integer idRegion);

    @Query("select c from Ciudad c where c.ciudad = :ciudad")
    Optional<Ciudad> findByCiudad(String ciudad);
}