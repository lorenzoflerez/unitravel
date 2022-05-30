package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservaService {

    Reserva registrarReserva(Reserva reserva) throws Exception;

    Reserva actualizarReserva(Reserva reserva) throws Exception;

    Reserva buscarReservaPorId(Integer idReserva) throws Exception;

    void eliminarReserva(Integer idReserva) throws Exception;

    List<Reserva> listarReservas();

    List<Reserva> listarReservasUsuario(Integer idCliente) throws Exception;

    List<Object[]> listarReservasHotel(Integer idHotel) throws Exception;

    List<Object[]> listarReservasVuelo(Integer idVuelo) throws Exception;

    List<Object[]> listarReservasPaquete(Integer idPaquete) throws Exception;

    List<Object[]> listarReservasActivas(LocalDateTime actual);

    List<Object[]> calcularTotalReserva(Integer idReserva) throws Exception;


    ReservaHabitacion registrarReservaHabitacion(ReservaHabitacion reservaHabitacion) throws Exception;

    ReservaHabitacion actualizarReservaHabitacion(ReservaHabitacion reservaHabitacion) throws Exception;

    ReservaHabitacion buscarReservaHabitacionPorId(Integer idReservaHabitacion) throws Exception;

    void eliminarReservaHabitacion(Integer idReservaHabitacion) throws Exception;

    List<ReservaHabitacion> listarReservasHabitacion();

    List<Object[]> listarReservasActivasHotel(Integer idHotel, LocalDateTime fecha);

    List<Object[]> listarHabitacionesReservadasCliente(Integer idCliente, LocalDateTime fecha);

    Optional<Object[]> calcularTotalReservaHabitacion(Integer idReserva);


    ReservaPaquete registrarReservaPaquete(ReservaPaquete reservaPaquete) throws Exception;

    ReservaPaquete actualizarReservaPaquete(ReservaPaquete reservaPaquete) throws Exception;

    ReservaPaquete buscarReservaPaquetePorId(Integer idReservaPaquete) throws Exception;

    void eliminarReservaPaquete(Integer idReservaPaquete) throws Exception;

    List<ReservaPaquete> listarReservasPaquete();

    List<Object[]> listarPaqueteReservadosCliente(Integer idCliente, LocalDateTime fecha);

    Optional<Object[]> calcularTotalReservaPaquete(Integer idReserva);


    ReservaSilla registrarReservaSilla(ReservaSilla reservaSilla) throws Exception;

    ReservaSilla actualizarReservaSilla(ReservaSilla reservaSilla) throws Exception;

    ReservaSilla buscarReservaSillaPorId(Integer idReservaSilla) throws Exception;

    void eliminarReservaSilla(Integer idReservaSilla) throws Exception;

    List<ReservaSilla> listarReservasSilla();

    List<Object[]> listarReservasActivasVuelo(Integer idVuelo, LocalDateTime fecha);

    List<Object[]> listarSillasReservadasCliente(Integer idCliente, LocalDateTime fecha);

    Optional<Object[]> calcularTotalReservaSilla(Integer idReserva);
}
