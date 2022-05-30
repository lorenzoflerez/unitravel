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

    List<Hotel> listarHotelesGerente(Integer idGerente) throws Exception;

    List<Hotel> listarHotelesCiudad(Integer idCiudad) throws Exception;

    List<Hotel> listarHotelesRegion(Integer idRegion) throws Exception;

    List<Hotel> listarHotelesCaracteristica(Integer idCaracteristica) throws Exception;

    List<Hotel> listarHotelesRangoPrecio(Double minimo, Double maximo);

    List<Hotel> listarHotelesCapacidadHabitacion(Integer capacidad);

    List<Hotel> listarHotelesTipoCama(String tipoCama);

    List<Hotel> listarHotelesSinComentarios();

    List<Hotel> ordenarHotelesPorEstrellas();

    List<Object[]> contarHotelesPorCiudad();

    List<Object[]> ordenarHotelesPorCalificacion();

    List<Object[]> obtenerCalificacionHotel(Integer idHotel) throws Exception;

    Optional<Object[]> contarReservasActivasHotel(Integer idHotel, LocalDateTime fecha) throws Exception;

    Optional<Object[]> contarHabitacionesDisponiblesHotel(Integer idHotel, LocalDateTime fecha) throws Exception;


    Habitacion registrarHabitacion(Habitacion habitacion) throws Exception;

    Habitacion actualizarHabitacion(Habitacion habitacion) throws Exception;

    Habitacion buscarHabitacionPorId(Integer idHabitacion) throws Exception;

    void eliminarHabitacion(Integer idHabitacion) throws Exception;

    List<Habitacion> listarHabitaciones();

    List<Habitacion> listarHabitacionesCaracteristica(Integer idCaracteristica) throws Exception;

    List<Habitacion> listarHabitacionesTipoCama(String tipoCama);

    Optional<Object[]> contarCamasHabitacion(Integer idHabitacion) throws Exception;


    Foto registrarFoto(Foto habitacion) throws Exception;

    Foto actualizarFoto(Foto habitacion) throws Exception;

    Foto buscarFotoPorId(Integer idFoto) throws Exception;

    Boolean buscarFotoPorUrl(String url);

    void eliminarFoto(Integer idFoto) throws Exception;

    List<Foto> listarFotos();

    List<Foto> listarFotosHotel(Integer idHotel) throws Exception;

    List<Foto> listarFotosHabitacion(Integer idHabitacion) throws Exception;


    Cama registrarCama(Cama cama) throws Exception;

    Cama actualizarCama(Cama cama) throws Exception;

    Cama buscarCamaPorId(Integer idCama) throws Exception;

    void eliminarCama(Integer idCama) throws Exception;

    List<Cama> listarCamas();


    Caracteristica registrarCaracteristica(Caracteristica caracteristica) throws Exception;

    Caracteristica actualizarCaracteristica(Caracteristica caracteristica) throws Exception;

    Caracteristica buscarCaracteristicaPorId(Integer idCaracteristica) throws Exception;

    Boolean buscarCaracteristicaPorNombre(String caracteristica);

    void eliminarCaracteristica(Integer idCaracteristica) throws Exception;

    List<Caracteristica> listarCaracteristicas();

    List<Caracteristica> listarCaracteristicasHotel(Integer idHotel) throws Exception;

    List<Caracteristica> listarCaracteristicasHabitacion(Integer idHabitacion) throws Exception;


    Gerente registrarGerente(Gerente gerente) throws Exception;

    Gerente actualizarGerente(Gerente gerente) throws Exception;

    Gerente buscarGerentePorId(Integer idGerente) throws Exception;

    void eliminarGerente(Integer idGerente) throws Exception;

    List<Gerente> listarGerentes();

    Gerente validarGerente(String email, String password) throws Exception;

    Gerente recuperarClaveDeAcceso(String email) throws Exception;

    List<Gerente> listarGerentesCiudad(Integer idCiudad) throws Exception;
}
