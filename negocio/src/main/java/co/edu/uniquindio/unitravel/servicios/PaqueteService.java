package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;
import java.util.Optional;

public interface PaqueteService {

    PaqueteTuristico registrarPaqueteTuristico(PaqueteTuristico paqueteTuristico) throws Exception;

    PaqueteTuristico actualizarPaqueteTuristico(PaqueteTuristico paqueteTuristico) throws Exception;

    PaqueteTuristico buscarPaqueteTuristicoPorId(Integer idPaqueteTuristico) throws Exception;

    void eliminarPaqueteTuristico(Integer idPaqueteTuristico) throws Exception;

    List<PaqueteTuristico> listarPaquetesTuristicos();

    List<PaqueteTuristico> listarPaquetesCiudad(Integer idCiudad);

    List<PaqueteTuristico> listarPaquetesGuia(Integer idGuia);

    List<PaqueteTuristico> listarPaquetesDiasHabiles(String dias);


    Lugar registrarLugar(Lugar lugar) throws Exception;

    Lugar actualizarLugar(Lugar lugar) throws Exception;

    Lugar buscarLugarPorId(Integer idLugar) throws Exception;

    void eliminarLugar(Integer idLugar) throws Exception;

    List<Lugar> listarLugares();

    List<Lugar> listarLugaresCiudad(Integer idCiudad);

    List<Lugar> listarLugaresPaquete(Integer idPaquete);

    List<Lugar> listarLugaresDiasHabiles(String dias);

    List<Lugar> listarLugarNombre(String nombre);


    Horario registrarHorario(Horario horario) throws Exception;

    Horario actualizarHorario(Horario horario) throws Exception;

    Horario buscarHorarioPorId(Integer idHorario) throws Exception;

    void eliminarHorario(Integer idHorario) throws Exception;

    List<Horario> listarHorarios();


    Guia registrarGuia(Guia guia) throws Exception;

    Guia actualizarGuia(Guia guia) throws Exception;

    Guia buscarGuiaPorId(Integer idGuia) throws Exception;

    void eliminarGuia(Integer idGuia) throws Exception;

    List<Guia> listarGuias();

    Optional<Guia> validarGuia(String email, String password);

    List<Guia> listarGuiaNombre(String nombre);

    Guia recuperarClaveDeAcceso(String email) throws Exception;
}
