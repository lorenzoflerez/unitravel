package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Silla;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepository;
import co.edu.uniquindio.unitravel.repositorios.SillaRepository;
import co.edu.uniquindio.unitravel.repositorios.VueloRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VueloServiceImplementation implements VueloService{

    private final VueloRepository vueloRepository;
    private final SillaRepository sillaRepository;
    private final CiudadRepository ciudadRepository;

    public VueloServiceImplementation(VueloRepository vueloRepository, SillaRepository sillaRepository, CiudadRepository ciudadRepository) {
        this.vueloRepository = vueloRepository;
        this.sillaRepository = sillaRepository;
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public Vuelo registrarVuelo(Vuelo vuelo) throws Exception {
        if(vuelo.getOrigen().equals(vuelo.getDestino()))
            throw new Exception("El origen y el destino no pueden ser iguales");
        System.out.println("genaro");
        System.out.println(vuelo.toString());
        if(vuelo.getFechaLlegada().isBefore(vuelo.getFechaSalida()))
            throw new Exception("La fecha de llegada debe ser posterior a la fecha de salida");
        System.out.println("nirvana");
        return vueloRepository.save(vuelo);
    }

    @Override
    public Vuelo actualizarVuelo(Vuelo vuelo) throws Exception {
        buscarVueloPorId(vuelo.getIdVuelo());
        return vueloRepository.save(vuelo);
    }

    @Override
    public Vuelo buscarVueloPorId(Integer idVuelo) throws Exception {
        Optional<Vuelo> vuelo = vueloRepository.findById(idVuelo);
        if (vuelo.isEmpty())
            throw new Exception("El código no se encuentra registrado");
        return vuelo.get();
    }

    @Override
    public void eliminarVuelo(Integer idVuelo) throws Exception {
        buscarVueloPorId(idVuelo);
        vueloRepository.deleteById(idVuelo);
    }

    @Override
    public List<Vuelo> listarVuelos() {
        return vueloRepository.findAll();
    }

    @Override
    public List<Vuelo> listarVuelosOrigen(Integer idOrigen) throws Exception {
        if(ciudadRepository.findById(idOrigen).isEmpty())
            throw new Exception("La ciudad no se encuentra registrada");
        return vueloRepository.listarVuelosOrigen(idOrigen);
    }

    @Override
    public List<Vuelo> listarVuelosDestino(Integer idDestino) throws Exception{
        if(ciudadRepository.findById(idDestino).isEmpty())
            throw new Exception("La ciudad no se encuentra registrada");
        return vueloRepository.listarVuelosDestino(idDestino);
    }

    @Override
    public List<Vuelo> listarVuelosOrigenYDestino(Integer idOrigen, Integer idDestino) throws Exception{
        if(ciudadRepository.findById(idOrigen).isEmpty() || ciudadRepository.findById(idDestino).isEmpty())
            throw new Exception("La ciudad no se encuentra registrada");
        if(ciudadRepository.findById(idDestino).get().equals(ciudadRepository.findById(idDestino).get()))
            throw new Exception("El origen y el destino no pueden ser iguales");
        return vueloRepository.listarVuelosOrigenYDestino(idOrigen, idDestino);
    }

    @Override
    public List<Vuelo> listarVuelosAerolinea(String aerolinea) {
        return vueloRepository.listarVuelosAerolinea(aerolinea);
    }

    @Override
    public List<Vuelo> listarVuelosEstado(String estado) {
        return vueloRepository.listarVuelosEstado(estado);
    }

    @Override
    public List<Vuelo> listarVuelosHoraSalida(LocalDateTime fechaSalida) {
        return vueloRepository.listarVuelosHoraSalida(fechaSalida);
    }

    @Override
    public List<Vuelo> listarVuelosHoraLllegada(LocalDateTime fechaLlegada) {
        return vueloRepository.listarVuelosHoraLllegada(fechaLlegada);
    }

    @Override
    public List<Silla> listarSillasDisponiblesVuelo(Integer idVuelo, LocalDateTime fecha) throws Exception {
        if(vueloRepository.findById(idVuelo).isEmpty())
            throw new Exception("El vuelo no se encuentra registrado");
        return sillaRepository.listarSillasDisponiblesVuelo(idVuelo, fecha);
    }

    @Override
    public Silla registrarSilla(Silla silla) throws Exception {
        Optional<Silla> sillaBuscada = sillaRepository.findById(silla.getIdSilla());
        if(sillaBuscada.isPresent())
            throw new Exception("El código de la silla ya se encuentra registrado");
        if(vueloRepository.findById(sillaBuscada.get().getVuelo().getIdVuelo()).isEmpty())
            throw new Exception("El vuelo no se encuentra registrado");
        return sillaRepository.save(silla);
    }

    @Override
    public Silla actualizarSilla(Silla silla) throws Exception {
        buscarSillaPorId(silla.getIdSilla());
        return sillaRepository.save(silla);
    }

    @Override
    public Silla buscarSillaPorId(Integer idSilla) throws Exception {
        Optional<Silla> silla = sillaRepository.findById(idSilla);
        if (silla.isEmpty())
            throw new Exception("El código no se encuentra registrado");
        return silla.get();
    }

    @Override
    public void eliminarSilla(Integer idSilla) throws Exception {
        buscarSillaPorId(idSilla);
        sillaRepository.deleteById(idSilla);
    }

    @Override
    public List<Silla> listarSillas() {
        return sillaRepository.findAll();
    }
}
