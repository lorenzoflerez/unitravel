package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Integer> {

    @Query("select c from Caracteristica c join c.hoteles h where h.idHotel = :idHotel")
    List<Caracteristica> listarCaracteristicasHotel(Integer idHotel);

    @Query("select c from Caracteristica c join c.habitaciones h where h.idHabitacion = :idHabitacion")
    List<Caracteristica> listarCaracteristicasHabitacion(Integer idHabitacion);

    @Query("select c from Caracteristica c where c.caracteristica = :caracteristica")
    Optional<Caracteristica> buscarCaracteristica(String caracteristica);
}