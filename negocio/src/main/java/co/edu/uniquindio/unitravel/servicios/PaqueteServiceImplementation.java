package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaqueteServiceImplementation implements PaqueteService{

    private final PaqueteTuristicoRepository paqueteTuristicoRepository;

    private final GuiaRepository guiaRepository;

    private final LugarRepository lugarRepository;

    private final HorarioRepository horarioRepository;

    private final CiudadRepository ciudadRepository;

    public PaqueteServiceImplementation(PaqueteTuristicoRepository paqueteTuristicoRepository,
                                        GuiaRepository guiaRepository, LugarRepository lugarRepository,
                                        HorarioRepository horarioRepository, CiudadRepository ciudadRepository) {
        this.paqueteTuristicoRepository = paqueteTuristicoRepository;
        this.guiaRepository = guiaRepository;
        this.lugarRepository = lugarRepository;
        this.horarioRepository = horarioRepository;
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public PaqueteTuristico registrarPaqueteTuristico(PaqueteTuristico paqueteTuristico) throws Exception {
        Optional<PaqueteTuristico> paqueteBuscado = paqueteTuristicoRepository.findById(paqueteTuristico.getIdPaquete());
        if(paqueteBuscado.isPresent())
            throw new Exception("El código del paquete turístico ya se encuentra registrado");
        buscarGuiaPorId(paqueteTuristico.getGuia().getId());
        return paqueteTuristicoRepository.save(paqueteTuristico);
    }

    @Override
    public PaqueteTuristico actualizarPaqueteTuristico(PaqueteTuristico paqueteTuristico) throws Exception {
        buscarPaqueteTuristicoPorId(paqueteTuristico.getIdPaquete());
        return paqueteTuristicoRepository.save(paqueteTuristico);
    }

    @Override
    public PaqueteTuristico buscarPaqueteTuristicoPorId(Integer idPaqueteTuristico) throws Exception {
        Optional<PaqueteTuristico> paqueteBuscado = paqueteTuristicoRepository.findById(idPaqueteTuristico);
        if(paqueteBuscado.isEmpty())
            throw new Exception("El código del paquete turístico no se encuentra registrado");
        return paqueteBuscado.get();
    }

    @Override
    public void eliminarPaqueteTuristico(Integer idPaqueteTuristico) throws Exception {
        buscarPaqueteTuristicoPorId(idPaqueteTuristico);
        paqueteTuristicoRepository.deleteById(idPaqueteTuristico);
    }

    @Override
    public List<PaqueteTuristico> listarPaquetesTuristicos() {
        return paqueteTuristicoRepository.findAll();
    }

    @Override
    public List<PaqueteTuristico> listarPaquetesCiudad(Integer idCiudad) throws Exception {
        Optional<Ciudad> ciudad = ciudadRepository.findById(idCiudad);
        if(ciudad.isEmpty())
            throw new Exception("La ciudad no se encuentra registrada");
        return paqueteTuristicoRepository.listarPaquetesCiudad(idCiudad);
    }

    @Override
    public List<PaqueteTuristico> listarPaquetesGuia(Integer idGuia) throws Exception {
        buscarGuiaPorId(idGuia);
        return paqueteTuristicoRepository.listarPaquetesGuia(idGuia);
    }

    @Override
    public List<PaqueteTuristico> listarPaquetesDiasHabiles(String dias) {
        return paqueteTuristicoRepository.listarPaquetesDiasHabiles(dias);
    }

    @Override
    public Lugar registrarLugar(Lugar lugar) throws Exception {
        Optional<Lugar> lugarBuscado = lugarRepository.findById(lugar.getIdLugar());
        if(lugarBuscado.isPresent())
            throw new Exception("El código del lugar ya se encuentra registrado");
        if(ciudadRepository.findByCiudad(lugar.getCiudad().getCiudad()).isEmpty())
            throw new Exception("La ciudad no se encuentra registrada");
        if(lugarRepository.validarCiudad(lugar.getIdLugar(),lugar.getNombre()).isPresent())
            throw new Exception("El lugar ya se encuentra registrado");
        return lugarRepository.save(lugar);
    }

    @Override
    public Lugar actualizarLugar(Lugar lugar) throws Exception {
        buscarLugarPorId(lugar.getIdLugar());
        return lugarRepository.save(lugar);
    }

    @Override
    public Lugar buscarLugarPorId(Integer idLugar) throws Exception {
        Optional<Lugar> lugarBuscado = lugarRepository.findById(idLugar);
        if(lugarBuscado.isEmpty())
            throw new Exception("El código del lugar no se encuentra registrado");
        return lugarBuscado.get();
    }

    @Override
    public void eliminarLugar(Integer idLugar) throws Exception {
        buscarLugarPorId(idLugar);
        lugarRepository.deleteById(idLugar);
    }

    @Override
    public List<Lugar> listarLugares() {
        return lugarRepository.findAll();
    }

    @Override
    public List<Lugar> listarLugaresCiudad(Integer idCiudad) throws Exception {
        Optional<Ciudad> ciudad = ciudadRepository.findById(idCiudad);
        if(ciudad.isEmpty())
            throw new Exception("La ciudad no se encuentra registrada");
        return lugarRepository.listarLugaresCiudad(idCiudad);
    }

    @Override
    public List<Lugar> listarLugaresPaquete(Integer idPaquete) throws Exception {
        Optional<PaqueteTuristico> paqueteTuristico = paqueteTuristicoRepository.findById(idPaquete);
        if(paqueteTuristico.isEmpty())
            throw new Exception("El paquete turístico no se encuentra registrada");
        return lugarRepository.listarLugaresPaquete(idPaquete);
    }

    @Override
    public List<Lugar> listarLugaresDiasHabiles(String dias) {
        return lugarRepository.listarLugaresDiasHabiles(dias);
    }

    @Override
    public List<Lugar> listarLugarNombre(String nombre) {
        return lugarRepository.listarLugarNombre(nombre);
    }

    @Override
    public Horario registrarHorario(Horario horario) throws Exception {
        Optional<Horario> horarioBuscado = horarioRepository.findById(horario.getIdHorario());
        if(horarioBuscado.isPresent())
            throw new Exception("El código del horario ya se encuentra registrado");
        if(validarHorario(horario.getDia(), horario.getHoraInicio(), horario.getHoraFin()))
            throw new Exception("El horario ya se encuentra registrado");
        return horarioRepository.save(horario);
    }

    @Override
    public Horario actualizarHorario(Horario horario) throws Exception {
        buscarHorarioPorId(horario.getIdHorario());
        return horarioRepository.save(horario);
    }

    @Override
    public Horario buscarHorarioPorId(Integer idHorario) throws Exception {
        Optional<Horario> horarioBuscado = horarioRepository.findById(idHorario);
        if(horarioBuscado.isEmpty())
            throw new Exception("El código del horario no se encuentra registrado");
        return horarioBuscado.get();
    }

    @Override
    public void eliminarHorario(Integer idHorario) throws Exception {
        buscarHorarioPorId(idHorario);
        horarioRepository.deleteById(idHorario);
    }

    @Override
    public List<Horario> listarHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public Boolean validarHorario(String dias, LocalTime inicio, LocalTime fin) throws Exception{
        return horarioRepository.validarHorario(dias,inicio,fin).isPresent();
    }

    @Override
    public Guia registrarGuia(Guia guia) throws Exception {
        Optional<Guia> guiaBuscado = guiaRepository.findById(guia.getId());
        if(guiaBuscado.isPresent())
            throw new Exception("El código del guia ya se encuentra registrado");
        guiaBuscado = guiaRepository.findByEmail(guia.getEmail());
        if(guiaBuscado.isPresent())
            throw new Exception("El email del guia ya se encuentra registrado");
        guiaBuscado = guiaRepository.findByNickname(guia.getNickname());
        if(guiaBuscado.isPresent())
            throw new Exception("El nickname del guia ya se encuentra registrado");
        guia.setFechaRegistro(LocalDateTime.now());
        return guiaRepository.save(guia);
    }

    @Override
    public Guia actualizarGuia(Guia guia) throws Exception {
        buscarGuiaPorId(guia.getId());
        return guiaRepository.save(guia);
    }

    @Override
    public Guia buscarGuiaPorId(Integer idGuia) throws Exception {
        Optional<Guia> guiaBuscado = guiaRepository.findById(idGuia);
        if(guiaBuscado.isEmpty())
            throw new Exception("El código del guia no se encuentra registrado");
        return guiaBuscado.get();
    }

    @Override
    public void eliminarGuia(Integer idGuia) throws Exception {
        buscarGuiaPorId(idGuia);
        guiaRepository.deleteById(idGuia);
    }

    @Override
    public List<Guia> listarGuias() {
        return guiaRepository.findAll();
    }

    @Override
    public Guia buscarAdministradorPorNickname(String nickname) throws Exception {
        return guiaRepository.findByNickname(nickname).orElseThrow(()-> new Exception("El nickname del guia no se encuentra registrado"));
    }

    @Override
    public Guia buscarAdministradorPorEmail(String email) throws Exception {
        return guiaRepository.findByEmail(email).orElseThrow(()-> new Exception("El email  del guia no se encuentra registrado"));
    }

    @Override
    public Guia validarGuia(String email, String password) throws Exception {
        return guiaRepository.validarGuia(email, password)
                .orElseThrow(()->new Exception("Los datos de autenticación del guia son incorrectos"));
    }

    @Override
    public List<Guia> listarGuiaNombre(String nombre) {
        return guiaRepository.listarGuiaNombre(nombre);
    }

    @Override
    public Guia recuperarClaveDeAcceso(String email) throws Exception {
        return null;
    }
}
