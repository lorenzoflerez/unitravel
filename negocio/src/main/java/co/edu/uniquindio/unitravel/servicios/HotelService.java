package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HotelService {

    Hotel registrarHotel(Hotel hotel) throws Exception;

    Hotel actualizarHotel(Hotel hotel) throws Exception;

    Hotel buscarHotelPorId(Integer idHotel) throws Exception;

    void eliminarHotel(Integer idHotel) throws Exception;

    List<Hotel> listarHoteles();

    List<Hotel> buscarHotel(String nombre);

    List<Hotel> listarHotelesPorEstrellas(Integer numEstrellas);

    List<Hotel> listarHotelesGerente(Integer idGerente);

    List<Hotel> listarHotelesCiudad(Integer idCiudad);

    List<Hotel> listarHotelesRegion(Integer idRegion);

    List<Hotel> listarHotelesCaracteristica(Integer idCaracteristica);

    List<Hotel> listarHotelesRangoPrecio(Double minimo, Double maximo);

    List<Hotel> listarHotelesCapacidadHabitacion(Integer capacidad);

    List<Hotel> listarHotelesTipoCama(String tipoCama);

    List<Hotel> listarHotelesSinComentarios();

    List<Hotel> ordenarHotelesPorEstrellas();

    List<Object[]> contarHotelesPorCiudad();

    List<Object[]> ordenarHotelesPorCalificacion();

    List<Object[]> obtenerCalificacionHotel(Integer idHotel);

    Optional<Object[]> contarReservasActivasHotel(Integer idHotel, LocalDateTime fecha);

    Optional<Object[]> contarHabitacionesDisponiblesHotel(Integer idHotel, LocalDateTime fecha);


    Habitacion registrarHabitacion(Habitacion habitacion) throws Exception;

    Habitacion actualizarHabitacion(Habitacion habitacion) throws Exception;

    Habitacion buscarHabitacionPorId(Integer idHabitacion) throws Exception;

    void eliminarHabitacion(Integer idHabitacion) throws Exception;

    List<Habitacion> listarHabitaciones();

    List<Habitacion> listarHabitacionesCaracteristica(Integer idCaracteristica);

    List<Habitacion> listarHabitacionesTipoCama(String tipoCama);

    Optional<Object[]> contarCamasHabitacion(Integer idHabitacion);


    Foto registrarFoto(Foto habitacion) throws Exception;

    Foto actualizarFoto(Foto habitacion) throws Exception;

    Foto buscarFotoPorId(Integer idFoto) throws Exception;

    void eliminarFoto(Integer idFoto) throws Exception;

    List<Foto> listarFotos();

    List<Foto> listarFotosHotel(Integer idHotel);

    List<Foto> listarFotosHabitacion(Integer idHabitacion);


    Cama registrarCama(Cama cama) throws Exception;

    Cama actualizarCama(Cama cama) throws Exception;

    Cama buscarCamaPorId(Integer idCama) throws Exception;

    void eliminarCama(Integer idCama) throws Exception;

    List<Cama> listarCamas();


    Caracteristica registrarCaracteristica(Caracteristica caracteristica) throws Exception;

    Caracteristica actualizarCaracteristica(Caracteristica caracteristica) throws Exception;

    Caracteristica buscarCaracteristicaPorId(Integer idCaracteristica) throws Exception;

    void eliminarCaracteristica(Integer idCaracteristica) throws Exception;

    List<Caracteristica> listarCaracteristicas();

    List<Caracteristica> listarCaracteristicasHotel(Integer idHotel);

    List<Caracteristica> listarCaracteristicasHabitacion(Integer idHabitacion);


    Gerente registrarGerente(Gerente gerente) throws Exception;

    Gerente actualizarGerente(Gerente gerente) throws Exception;

    Gerente buscarGerentePorId(Integer idGerente) throws Exception;

    void eliminarGerente(Integer idGerente) throws Exception;

    List<Gerente> listarGerentes();

    Optional<Gerente> validarGerente(String email, String password);

    Gerente recuperarClaveDeAcceso(String email) throws Exception;

    List<Gerente> listarGerentesCiudad(Integer idCiudad);
}
