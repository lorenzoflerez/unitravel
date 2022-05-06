package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    @Query("select h from Habitacion h join h.caracteristicas c where c.idCaracteristica = :idCaracteristica")
    List<Habitacion> listarHabitacionesCaracteristica(Integer idCaracteristica);

    @Query("select h from Habitacion h join h.camas c where c.tipoCama = :tipoCama")
    List<Habitacion> listarHabitacionesTipoCama(String tipoCama);

    @Query("select h, count(c) from Habitacion h join h.camas c where h.idHabitacion = :idHabitacion group by h")
    Optional<Object[]> contarCamasHabitacion(Integer idHabitacion);
}