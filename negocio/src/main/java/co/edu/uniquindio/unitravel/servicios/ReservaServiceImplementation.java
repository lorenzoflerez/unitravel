package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.ReservaHabitacion;
import co.edu.uniquindio.unitravel.entidades.ReservaPaquete;
import co.edu.uniquindio.unitravel.entidades.ReservaSilla;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImplementation implements ReservaService{

    private final ReservaRepository reservaRepository;

    private final ReservaHabitacionRepository reservaHabitacionRepository;

    private final ReservaSillaRepository reservaSillaRepository;

    private final ReservaPaqueteRepository reservaPaqueteRepository;

    private final ClienteRepository clienteRepository;

    private final HotelRepository hotelRepository;

    private final VueloRepository vueloRepository;

    private final PaqueteTuristicoRepository paqueteTuristicoRepository;

    public ReservaServiceImplementation(ReservaRepository reservaRepository, ClienteRepository clienteRepository,
                                        ReservaHabitacionRepository reservaHabitacionRepository, HotelRepository hotelRepository,
                                        ReservaSillaRepository reservaSillaRepository, VueloRepository vueloRepository,
                                        ReservaPaqueteRepository reservaPaqueteRepository, PaqueteTuristicoRepository paqueteTuristicoRepository) {
        this.reservaRepository = reservaRepository;
        this.clienteRepository = clienteRepository;
        this.reservaHabitacionRepository = reservaHabitacionRepository;
        this.hotelRepository = hotelRepository;
        this.reservaSillaRepository = reservaSillaRepository;
        this.vueloRepository = vueloRepository;
        this.reservaPaqueteRepository = reservaPaqueteRepository;
        this.paqueteTuristicoRepository = paqueteTuristicoRepository;
    }

    @Override
    public Reserva registrarReserva(Reserva reserva) throws Exception {
        return null;
    }

    @Override
    public Reserva actualizarReserva(Reserva reserva) throws Exception {
        buscarReservaPorId(reserva.getIdReserva());
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva buscarReservaPorId(Integer idReserva) throws Exception {
        Optional<Reserva> reserva = reservaRepository.findById(idReserva);
        if(reserva.isEmpty())
            throw new Exception("La reserva no se encuentra registrada");
        return reserva.get();
    }

    @Override
    public void eliminarReserva(Integer idReserva) throws Exception {
        buscarReservaPorId(idReserva);
        reservaRepository.deleteById(idReserva);
    }

    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public List<Reserva> listarReservasUsuario(Integer idCliente) throws Exception{
        if(clienteRepository.findById(idCliente).isEmpty())
            throw new Exception("El cliente no esta registrado");
        return reservaRepository.listarReservasUsuario(idCliente);
    }

    @Override
    public List<Object[]> listarReservasHotel(Integer idHotel) throws Exception{
        if(hotelRepository.findById(idHotel).isEmpty())
            throw new Exception("El hotel no esta registrado");
        return reservaRepository.listarReservasHotel(idHotel);
    }

    @Override
    public List<Object[]> listarReservasVuelo(Integer idVuelo) throws Exception{
        if(vueloRepository.findById(idVuelo).isEmpty())
            throw new Exception("El vuelo no esta registrado");
        return reservaRepository.listarReservasVuelo(idVuelo);
    }

    @Override
    public List<Object[]> listarReservasPaquete(Integer idPaquete) throws Exception {
        if(paqueteTuristicoRepository.findById(idPaquete).isEmpty())
            throw new Exception("El paquete turístico no esta registrado");
        return reservaRepository.listarReservasPaquete(idPaquete);
    }

    @Override
    public List<Object[]> listarReservasActivas(LocalDateTime actual) {
        return reservaRepository.listarReservasActivas(actual);
    }

    @Override
    public List<Object[]> calcularTotalReserva(Integer idReserva) throws Exception {
        buscarReservaPorId(idReserva);
        return reservaRepository.calcularTotalReserva(idReserva);
    }

    @Override
    public ReservaHabitacion registrarReservaHabitacion(ReservaHabitacion reservaHabitacion) throws Exception {
        Optional<ReservaHabitacion> habitacion = reservaHabitacionRepository.findById(reservaHabitacion.getIdReservaHabitacion());
        if(habitacion.isPresent())
            throw new Exception("El código de la reserva ya se encuentra registrado");
        Reserva reserva = buscarReservaPorId(reservaHabitacion.getReserva().getIdReserva());
        if(reservaHabitacionRepository.validarReservaHabitacion(reservaHabitacion.getIdReservaHabitacion(),reserva.getFechaInicio(),reserva.getFechaFin()).isPresent())
            throw new Exception("La habitación ya se encuentra reservada");
        return reservaHabitacionRepository.save(reservaHabitacion);
    }

    @Override
    public ReservaHabitacion actualizarReservaHabitacion(ReservaHabitacion reservaHabitacion) throws Exception {
        return null;
    }

    @Override
    public ReservaHabitacion buscarReservaHabitacionPorId(Integer idReservaHabitacion) throws Exception {
        Optional<ReservaHabitacion> reserva = reservaHabitacionRepository.findById(idReservaHabitacion);
        if(reserva.isEmpty())
            throw new Exception("La reserva no se encuentra registrada");
        return reserva.get();
    }

    @Override
    public void eliminarReservaHabitacion(Integer idReservaHabitacion) throws Exception {

    }

    @Override
    public List<ReservaHabitacion> listarReservasHabitacion() {
        return null;
    }

    @Override
    public List<Object[]> listarReservasActivasHotel(Integer idHotel, LocalDateTime fecha) {
        return null;
    }

    @Override
    public List<Object[]> listarHabitacionesReservadasCliente(Integer idCliente, LocalDateTime fecha) {
        return null;
    }

    @Override
    public Optional<Object[]> calcularTotalReservaHabitacion(Integer idReserva) {
        return Optional.empty();
    }

    @Override
    public ReservaPaquete registrarReservaPaquete(ReservaPaquete reservaPaquete) throws Exception {
        Optional<ReservaPaquete> paquete = reservaPaqueteRepository.findById(reservaPaquete.getIdReservaPaquete());
        if(paquete.isPresent())
            throw new Exception("El paquete ya ha sido reservado");
        buscarReservaPorId(reservaPaquete.getReserva().getIdReserva());
        return reservaPaqueteRepository.save(reservaPaquete);
    }

    @Override
    public ReservaPaquete actualizarReservaPaquete(ReservaPaquete reservaPaquete) throws Exception {
        return null;
    }

    @Override
    public ReservaPaquete buscarReservaPaquetePorId(Integer idReservaPaquete) throws Exception {
        Optional<ReservaPaquete> reserva = reservaPaqueteRepository.findById(idReservaPaquete);
        if(reserva.isEmpty())
            throw new Exception("La reserva no se encuentra registrada");
        return reserva.get();
    }

    @Override
    public void eliminarReservaPaquete(Integer idReservaPaquete) throws Exception {

    }

    @Override
    public List<ReservaPaquete> listarReservasPaquete() {
        return null;
    }

    @Override
    public List<Object[]> listarPaqueteReservadosCliente(Integer idCliente, LocalDateTime fecha) {
        return null;
    }

    @Override
    public Optional<Object[]> calcularTotalReservaPaquete(Integer idReserva) {
        return Optional.empty();
    }

    @Override
    public ReservaSilla registrarReservaSilla(ReservaSilla reservaSilla) throws Exception {
        Optional<ReservaSilla> silla = reservaSillaRepository.findById(reservaSilla.getIdReservaSilla());
        if(silla.isPresent())
            throw new Exception("La silla ya se encuentra reservada");
        buscarReservaPorId(reservaSilla.getReserva().getIdReserva());
        return reservaSillaRepository.save(reservaSilla);
    }

    @Override
    public ReservaSilla actualizarReservaSilla(ReservaSilla reservaSilla) throws Exception {
        return null;
    }

    @Override
    public ReservaSilla buscarReservaSillaPorId(Integer idReservaSilla) throws Exception {
        Optional<ReservaSilla> reserva = reservaSillaRepository.findById(idReservaSilla);
        if(reserva.isEmpty())
            throw new Exception("La reserva no se encuentra registrada");
        return reserva.get();
    }

    @Override
    public void eliminarReservaSilla(Integer idReservaSilla) throws Exception {

    }

    @Override
    public List<ReservaSilla> listarReservasSilla() {
        return null;
    }

    @Override
    public List<Object[]> listarReservasActivasVuelo(Integer idVuelo, LocalDateTime fecha) {
        return null;
    }

    @Override
    public List<Object[]> listarSillasReservadasCliente(Integer idCliente, LocalDateTime fecha) {
        return null;
    }

    @Override
    public Optional<Object[]> calcularTotalReservaSilla(Integer idReserva) {
        return Optional.empty();
    }
}
