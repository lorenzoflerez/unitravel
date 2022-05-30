package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Silla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SillaRepository extends JpaRepository<Silla, Integer> {

    @Query("select s from Vuelo v join v.sillas s join s.reservas r where v.idVuelo = :idVuelo and r.reserva.fechaFin < :fecha")
    List<Silla> listarSillasDisponiblesVuelo(Integer idVuelo, LocalDateTime fecha);

}