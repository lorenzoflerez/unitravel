package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("select r from Reserva r where r.cliente.id = :idCliente")
    List<Reserva> listarReservasUsuario(Integer idCliente);

    @Query("select r.cliente, a.habitacion, a from Reserva r inner join r.habitaciones a where a.habitacion.hotel.idHotel = :idHotel")
    List<Object[]> listarReservasHotel(Integer idHotel);

    @Query("select r.cliente, s.silla, s from Reserva r inner join r.sillas s where s.silla.vuelo.idVuelo = :idVuelo")
    List<Object[]> listarReservasVuelo(Integer idVuelo);

    @Query("select r.cliente, p.paquete, p from Reserva r inner join r.paquetes p where p.paquete.idPaquete = :idPaquete")
    List<Object[]> listarReservasPaquete(Integer idPaquete);

    @Query("select r from Reserva r where r.fechaFin <= :actual")
    List<Object[]> listarReservasActivas(LocalDateTime actual);

    @Query("select r, sum(rh.subTotal + rs.subTotal + rp.subTotal) from Reserva r join r.habitaciones rh join r.sillas rs join r.paquetes rp where r.idReserva = :idReserva group by r")
    List<Object[]> calcularTotalReserva(Integer idReserva);

    Optional<Reserva> validarReservaHabitacion(Integer idHabitacion, LocalDateTime inicio, LocalDateTime fin);
}