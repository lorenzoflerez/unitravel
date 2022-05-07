package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.Silla;
import co.edu.uniquindio.unitravel.entidades.Vuelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VueloService {

    Vuelo registrarVuelo(Vuelo vuelo) throws Exception;

    Vuelo actualizarVuelo(Vuelo vuelo) throws Exception;

    Vuelo buscarVueloPorId(Integer idVuelo) throws Exception;

    void eliminarVuelo(Integer idVuelo) throws Exception;

    List<Vuelo> listarVuelos();

    List<Vuelo> listarVuelosOrigen(Integer idOrigen);

    List<Vuelo> listarVuelosDestino(Integer idDestino);

    List<Vuelo> listarVuelosOrigenYDestino(Integer idOrigen, Integer idDestino);

    List<Vuelo> listarVuelosAerolinea(Integer idAerolinea);

    List<Vuelo> listarVuelosEstado(Integer idEstado);

    List<Vuelo> listarVuelosHoraSalida(LocalDateTime fechaSalida);

    List<Vuelo> listarVuelosHoraLllegada(LocalDateTime fechaLlegada);

    Optional<Object[]> contarSillasDisponiblesVuelo(Integer idVuelo, LocalDateTime fecha);


    Silla registrarSilla(Silla silla) throws Exception;

    Silla actualizarSilla(Silla silla) throws Exception;

    Silla buscarSillaPorId(Integer idSilla) throws Exception;

    void eliminarSilla(Integer idSilla) throws Exception;

    List<Silla> listarSillas();

}