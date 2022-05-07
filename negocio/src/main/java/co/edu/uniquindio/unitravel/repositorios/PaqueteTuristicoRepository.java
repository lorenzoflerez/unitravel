package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.PaqueteTuristico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaqueteTuristicoRepository extends JpaRepository<PaqueteTuristico, Integer> {

    @Query("select p from PaqueteTuristico p join p.lugares l where l.ciudad.idCiudad = :idCiudad")
    List<PaqueteTuristico> listarPaquetesCiudad(Integer idCiudad);

    @Query("select p from PaqueteTuristico p where p.guia.id = :idGuia")
    List<PaqueteTuristico> listarPaquetesGuia(Integer idGuia);

    @Query("select p from PaqueteTuristico p join p.horarios h where h.dia like concat('%', :dias, '%')")
    List<PaqueteTuristico> listarPaquetesDiasHabiles(String dias);
}