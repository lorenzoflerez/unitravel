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

    List<Vuelo> listarVuelosOrigen(Integer idOrigen) throws Exception;

    List<Vuelo> listarVuelosDestino(Integer idDestino) throws Exception;

    List<Vuelo> listarVuelosOrigenYDestino(Integer idOrigen, Integer idDestino) throws Exception;

    List<Vuelo> listarVuelosAerolinea(String aerolinea);

    List<Vuelo> listarVuelosEstado(String estado);

    List<Vuelo> listarVuelosHoraSalida(LocalDateTime fechaSalida);

    List<Vuelo> listarVuelosHoraLllegada(LocalDateTime fechaLlegada);

    List<Silla> listarSillasDisponiblesVuelo(Integer idVuelo, LocalDateTime fecha) throws Exception;


    Silla registrarSilla(Silla silla) throws Exception;

    Silla actualizarSilla(Silla silla) throws Exception;

    Silla buscarSillaPorId(Integer idSilla) throws Exception;

    void eliminarSilla(Integer idSilla) throws Exception;

    List<Silla> listarSillas();

}