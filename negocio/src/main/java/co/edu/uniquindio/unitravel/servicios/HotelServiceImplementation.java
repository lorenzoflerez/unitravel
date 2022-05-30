package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImplementation implements HotelService{

    private final HotelRepository hotelRepository;
    private final HabitacionRepository habitacionRepository;
    private final GerenteRepository gerenteRepository;
    private final CamaRepository camaRepository;
    private final CaracteristicaRepository caracteristicaRepository;
    private final FotoRepository fotoRepository;
    private final CiudadRepository ciudadRepository;
    private final RegionRepository regionRepository;

    public HotelServiceImplementation(HotelRepository hotelRepository, HabitacionRepository habitacionRepository,
                                      GerenteRepository gerenteRepository, CamaRepository camaRepository,
                                      CaracteristicaRepository caracteristicaRepository, FotoRepository fotoRepository,
                                      CiudadRepository ciudadRepository, RegionRepository regionRepository) {
        this.hotelRepository = hotelRepository;
        this.habitacionRepository = habitacionRepository;
        this.gerenteRepository = gerenteRepository;
        this.camaRepository = camaRepository;
        this.caracteristicaRepository = caracteristicaRepository;
        this.fotoRepository = fotoRepository;
        this.ciudadRepository = ciudadRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public Hotel registrarHotel(Hotel hotel) throws Exception {
        Optional<Hotel> hotelBuscado = hotelRepository.findById(hotel.getIdHotel());
        if(hotelBuscado.isPresent())
            throw new Exception("El código ya se encuentra registrado");
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel actualizarHotel(Hotel hotel) throws Exception {
        buscarHotelPorId(hotel.getIdHotel());
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel buscarHotelPorId(Integer idHotel) throws Exception {
        Optional<Hotel> hotel = hotelRepository.findById(idHotel);
        if (hotel.isEmpty())
            throw new Exception("El código no se encuentra registrado");
        return hotel.get();
    }

    @Override
    public void eliminarHotel(Integer idHotel) throws Exception {
        buscarHotelPorId(idHotel);
        hotelRepository.deleteById(idHotel);
    }

    @Override
    public List<Hotel> listarHoteles() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> buscarHotel(String nombre) {
        return hotelRepository.buscarHotel(nombre);
    }

    @Override
    public List<Hotel> listarHotelesPorEstrellas(Integer numEstrellas) {
        return hotelRepository.listarHotelesPorEstrellas(numEstrellas);
    }

    @Override
    public List<Hotel> listarHotelesGerente(Integer idGerente) throws Exception{
        Optional<Gerente> gerenteBuscado = gerenteRepository.findById(idGerente);
        if(gerenteBuscado.isEmpty())
            throw new Exception("La región no se encuentra registrada");
        return hotelRepository.listarHotelesGerente(idGerente);
    }

    @Override
    public List<Hotel> listarHotelesCiudad(Integer idCiudad) throws Exception{
        Optional<Ciudad> ciudadBuscada = ciudadRepository.findById(idCiudad);
        if(ciudadBuscada.isEmpty())
            throw new Exception("La ciudad no se encuentra registrada");
        return hotelRepository.listarHotelesCiudad(idCiudad);
    }

    @Override
    public List<Hotel> listarHotelesRegion(Integer idRegion) throws Exception{
        Optional<Region> regionBuscada = regionRepository.findById(idRegion);
        if(regionBuscada.isEmpty())
            throw new Exception("La región no se encuentra registrada");
        return hotelRepository.listarHotelesRegion(idRegion);
    }

    @Override
    public List<Hotel> listarHotelesCaracteristica(Integer idCaracteristica) throws Exception {
        Optional<Caracteristica> caracteristicaBuscada = caracteristicaRepository.findById(idCaracteristica);
        if(caracteristicaBuscada.isEmpty())
            throw new Exception("La caracteristica no se encuentra registrada");
        return hotelRepository.listarHotelesRegion(idCaracteristica);
    }

    @Override
    public List<Hotel> listarHotelesRangoPrecio(Double minimo, Double maximo) {
        return hotelRepository.listarHotelesRangoPrecio(minimo,maximo);
    }

    @Override
    public List<Hotel> listarHotelesCapacidadHabitacion(Integer capacidad) {
        return hotelRepository.listarHotelesCapacidadHabitacion(capacidad);
    }

    @Override
    public List<Hotel> listarHotelesTipoCama(String tipoCama) {
        return hotelRepository.listarHotelesTipoCama(tipoCama);
    }

    @Override
    public List<Hotel> listarHotelesSinComentarios() {
        return hotelRepository.listarHotelesSinComentarios();
    }

    @Override
    public List<Hotel> ordenarHotelesPorEstrellas() {
        return hotelRepository.ordenarHotelesPorEstrellas();
    }

    @Override
    public List<Object[]> contarHotelesPorCiudad() {
        return hotelRepository.contarHotelesPorCiudad();
    }

    @Override
    public List<Object[]> ordenarHotelesPorCalificacion() {
        return hotelRepository.ordenarHotelesPorCalificacion();
    }

    @Override
    public List<Object[]> obtenerCalificacionHotel(Integer idHotel) throws Exception {
        buscarHotelPorId(idHotel);
        return hotelRepository.obtenerCalificacionHotel(idHotel);
    }

    @Override
    public Optional<Object[]> contarReservasActivasHotel(Integer idHotel, LocalDateTime fecha) throws Exception{
        buscarHotelPorId(idHotel);
        return hotelRepository.contarReservasActivasHotel(idHotel, LocalDateTime.now());
    }

    @Override
    public Optional<Object[]> contarHabitacionesDisponiblesHotel(Integer idHotel, LocalDateTime fecha) throws Exception {
        buscarHotelPorId(idHotel);
        return hotelRepository.contarHabitacionesDisponiblesHotel(idHotel, LocalDateTime.now());
    }

    @Override
    public Habitacion registrarHabitacion(Habitacion habitacion) throws Exception {
        Optional<Habitacion> habitacionBusacada = habitacionRepository.findById(habitacion.getIdHabitacion());
        if(habitacionBusacada.isPresent())
            throw new Exception("El código ya se encuentra registrado");
        return habitacionRepository.save(habitacion);
    }

    @Override
    public Habitacion actualizarHabitacion(Habitacion habitacion) throws Exception {
        buscarHabitacionPorId(habitacion.getIdHabitacion());
        return habitacionRepository.save(habitacion);
    }

    @Override
    public Habitacion buscarHabitacionPorId(Integer idHabitacion) throws Exception {
        Optional<Habitacion> habitacion = habitacionRepository.findById(idHabitacion);
        if (habitacion.isEmpty())
            throw new Exception("El código no se encuentra registrado");
        return habitacion.get();
    }

    @Override
    public void eliminarHabitacion(Integer idHabitacion) throws Exception {
        buscarHabitacionPorId(idHabitacion);
        habitacionRepository.deleteById(idHabitacion);
    }

    @Override
    public List<Habitacion> listarHabitaciones() {
        return habitacionRepository.findAll();
    }

    @Override
    public List<Habitacion> listarHabitacionesCaracteristica(Integer idCaracteristica) throws Exception {
        Optional<Caracteristica> caracteristicaBuscada = caracteristicaRepository.findById(idCaracteristica);
        if(caracteristicaBuscada.isEmpty())
            throw new Exception("La caracteristica no se encuentra registrada");
        return habitacionRepository.listarHabitacionesCaracteristica(idCaracteristica);
    }

    @Override
    public List<Habitacion> listarHabitacionesTipoCama(String tipoCama) {
        return habitacionRepository.listarHabitacionesTipoCama(tipoCama);
    }

    @Override
    public Optional<Object[]> contarCamasHabitacion(Integer idHabitacion) throws Exception{
        Optional<Habitacion>habitacionBuscada = habitacionRepository.findById(idHabitacion);
        if(habitacionBuscada.isEmpty())
            throw new Exception("La habitación no se encuentra registrada");
        return habitacionRepository.contarCamasHabitacion(idHabitacion);
    }

    @Override
    public Foto registrarFoto(Foto foto) throws Exception {
        Optional<Foto> fotoBuscada = fotoRepository.findById(foto.getIdFoto());
        if(fotoBuscada.isPresent())
            throw new Exception("El código ya se encuentra registrado");
        if(buscarFotoPorUrl(foto.getUrl()))
            throw new Exception("La foto ya se encuentra registrada");
        return fotoRepository.save(foto);
    }

    @Override
    public Foto actualizarFoto(Foto foto) throws Exception {
        buscarFotoPorId(foto.getIdFoto());
        if(buscarFotoPorUrl(foto.getUrl()))
            throw new Exception("La url ya se encuentra registrada");
        return fotoRepository.save(foto);
    }

    @Override
    public Foto buscarFotoPorId(Integer idFoto) throws Exception {
        Optional<Foto> foto = fotoRepository.findById(idFoto);
        if (foto.isEmpty())
            throw new Exception("El código no se encuentra registrado");
        return foto.get();
    }

    @Override
    public Boolean buscarFotoPorUrl(String url) {
        return fotoRepository.buscarFoto(url).isPresent();
    }

    @Override
    public void eliminarFoto(Integer idFoto) throws Exception {
        buscarFotoPorId(idFoto);
        fotoRepository.deleteById(idFoto);
    }

    @Override
    public List<Foto> listarFotos() {
        return fotoRepository.findAll();
    }

    @Override
    public List<Foto> listarFotosHotel(Integer idHotel) throws Exception {
        buscarHotelPorId(idHotel);
        return fotoRepository.listarFotosHotel(idHotel);
    }

    @Override
    public List<Foto> listarFotosHabitacion(Integer idHabitacion) throws Exception {
        buscarHabitacionPorId(idHabitacion);
        return fotoRepository.listarFotosHabitacion(idHabitacion);
    }

    @Override
    public Cama registrarCama(Cama cama) throws Exception {
        Optional<Cama> camaBusacada = camaRepository.findById(cama.getIdCama());
        if(camaBusacada.isPresent())
            throw new Exception("El código ya se encuentra registrado");
        return camaRepository.save(cama);
    }

    @Override
    public Cama actualizarCama(Cama cama) throws Exception {
        buscarCamaPorId(cama.getIdCama());
        return camaRepository.save(cama);
    }

    @Override
    public Cama buscarCamaPorId(Integer idCama) throws Exception {
        Optional<Cama> cama = camaRepository.findById(idCama);
        if (cama.isEmpty())
            throw new Exception("El código no se encuentra registrado");
        return cama.get();
    }

    @Override
    public void eliminarCama(Integer idCama) throws Exception {
        buscarCamaPorId(idCama);
        camaRepository.deleteById(idCama);
    }

    @Override
    public List<Cama> listarCamas() {
        return camaRepository.findAll();
    }

    @Override
    public Caracteristica registrarCaracteristica(Caracteristica caracteristica) throws Exception {
        Optional<Caracteristica> caracteristicaBuscada = caracteristicaRepository.findById(caracteristica.getIdCaracteristica());
        if(caracteristicaBuscada.isPresent())
            throw new Exception("El código ya se encuentra registrado");
        if(buscarCaracteristicaPorNombre(caracteristica.getCaracteristica()))
            throw new Exception("La caracteristica ya se encuentra registrada");
        return caracteristicaRepository.save(caracteristica);
    }

    @Override
    public Caracteristica actualizarCaracteristica(Caracteristica caracteristica) throws Exception {
        buscarCaracteristicaPorId(caracteristica.getIdCaracteristica());
        if(buscarCaracteristicaPorNombre(caracteristica.getCaracteristica()))
            throw new Exception("La caracteristica ya se encuentra registrada");
        return caracteristicaRepository.save(caracteristica);
    }

    @Override
    public Caracteristica buscarCaracteristicaPorId(Integer idCaracteristica) throws Exception {
        Optional<Caracteristica> caracteristica = caracteristicaRepository.findById(idCaracteristica);
        if (caracteristica.isEmpty())
            throw new Exception("El código no se encuentra registrado");
        return caracteristica.get();
    }

    @Override
    public Boolean buscarCaracteristicaPorNombre(String caracteristica) {
        return caracteristicaRepository.buscarCaracteristica(caracteristica).isPresent();
    }

    @Override
    public void eliminarCaracteristica(Integer idCaracteristica) throws Exception {
        buscarCaracteristicaPorId(idCaracteristica);
        caracteristicaRepository.deleteById(idCaracteristica);
    }

    @Override
    public List<Caracteristica> listarCaracteristicas() {
        return caracteristicaRepository.findAll();
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHotel(Integer idHotel) throws Exception {
        buscarHotelPorId(idHotel);
        return caracteristicaRepository.listarCaracteristicasHotel(idHotel);
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHabitacion(Integer idHabitacion) throws Exception  {
        buscarHabitacionPorId(idHabitacion);
        return caracteristicaRepository.findAll();
    }

    @Override
    public Gerente registrarGerente(Gerente gerente) throws Exception {
        Optional<Gerente> gerenteBuscado = gerenteRepository.findById(gerente.getId());
        if(gerenteBuscado.isPresent())
            throw new Exception("El código ya se encuentra registrado");
        gerenteBuscado = gerenteRepository.buscarPorEmail(gerente.getEmail());
        if(gerenteBuscado.isPresent())
            throw new Exception("El email ya se encuentra registrado");
        gerenteBuscado = gerenteRepository.buscarPorNickname(gerente.getNickname());
        if(gerenteBuscado.isPresent())
            throw new Exception("El nickname ya se encuentra registrado");
        gerente.setFechaRegistro(LocalDateTime.now());
        return gerenteRepository.save(gerente);
    }

    @Override
    public Gerente actualizarGerente(Gerente gerente) throws Exception {
        buscarGerentePorId(gerente.getId());
        return gerenteRepository.save(gerente);
    }

    @Override
    public Gerente buscarGerentePorId(Integer idGerente) throws Exception {
        Optional<Gerente> gerente = gerenteRepository.findById(idGerente);
        if (gerente.isEmpty())
            throw new Exception("El código no se encuentra registrado");
        return gerente.get();
    }

    @Override
    public void eliminarGerente(Integer idGerente) throws Exception {
        buscarGerentePorId(idGerente);
        gerenteRepository.deleteById(idGerente);
    }

    @Override
    public List<Gerente> listarGerentes() {
        return gerenteRepository.findAll();
    }

    @Override
    public Gerente validarGerente(String email, String password) throws Exception {
        return gerenteRepository.validarGerente(email, password)
                .orElseThrow(()->new Exception("Los datos de autenticación son incorrectos"));
    }

    @Override
    public Gerente recuperarClaveDeAcceso(String email) throws Exception {
        return null;
    }

    @Override
    public List<Gerente> listarGerentesCiudad(Integer idCiudad) throws Exception {
        Optional<Ciudad> ciudad = ciudadRepository.findById(idCiudad);
        if (ciudad.isEmpty())
            throw new Exception("El código no se encuentra registrado");
        return gerenteRepository.listarGerentesCiudad(ciudad.get().getIdCiudad());
    }
}
