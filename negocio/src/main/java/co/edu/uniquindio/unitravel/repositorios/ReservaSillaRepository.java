package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.ReservaSilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaSillaRepository extends JpaRepository<ReservaSilla, Integer> {

    @Query("select rs, s from Reserva r join r.sillas rs join rs.silla s where s.vuelo.idVuelo = :idVuelo and r.fechaInicio <= :fecha and r.fechaFin >= :fecha")
    List<Object[]> listarReservasActivasVuelo(Integer idVuelo, LocalDateTime fecha);

    @Query("select rs, rs.silla from Cliente c join c.reservas r join r.sillas rs where c.id = :idCliente and r.fechaInicio <= :fecha and r.fechaFin >= :fecha")
    List<Object[]> listarSillasReservadasCliente(Integer idCliente, LocalDateTime fecha);

    @Query("select rs, sum(rs.subTotal) from ReservaSilla rs where rs.reserva.idReserva = :idReserva group by rs.reserva")
    Optional<Object[]> calcularTotalReservaSilla(Integer idReserva);

}