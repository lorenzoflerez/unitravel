package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.ReservaHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaHabitacionRepository extends JpaRepository<ReservaHabitacion, Integer> {

    @Query("select rh, a from Reserva r join r.habitaciones rh join rh.habitacion a where a.hotel.idHotel = :idHotel and r.fechaInicio <= :fecha and r.fechaFin >= :fecha")
    List<Object[]> listarReservasActivasHotel(Integer idHotel, LocalDateTime fecha);

    @Query("select rh, rh.habitacion from Cliente c join c.reservas r join r.habitaciones rh where c.id = :idCliente and r.fechaInicio <= :fecha and r.fechaFin >= :fecha")
    List<Object[]> listarHabitacionesReservadasCliente(Integer idCliente, LocalDateTime fecha);

    @Query("select rh, sum(rh.subTotal) from ReservaHabitacion rh where rh.reserva.idReserva = :idReserva group by rh.reserva")
    Optional<Object[]> calcularTotalReservaHabitacion(Integer idReserva);

    @Query("select rh from ReservaHabitacion rh join rh.reserva r where rh.habitacion.idHabitacion = :idHabitacion and r.fechaInicio <= :inicio and r.fechaFin >= :fin")
    Optional<Reserva> validarReservaHabitacion(Integer idHabitacion, LocalDateTime inicio, LocalDateTime fin);
}