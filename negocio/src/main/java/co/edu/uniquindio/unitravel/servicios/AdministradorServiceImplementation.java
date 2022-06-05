package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Region;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepository;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepository;
import co.edu.uniquindio.unitravel.repositorios.RegionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio
 */
@Service
public class AdministradorServiceImplementation implements AdministradorService{

   private final AdministradorRepository administradorRepository;
   private final CiudadRepository ciudadRepository;
   private final RegionRepository regionRepository;

    public AdministradorServiceImplementation(AdministradorRepository administradorRepository,
                                              CiudadRepository ciudadRepository, RegionRepository regionRepository) {
        this.administradorRepository = administradorRepository;
        this.ciudadRepository = ciudadRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public Administrador registrarAdministrador(Administrador administrador) throws Exception {
        Optional<Administrador> administradorBuscado = administradorRepository.findById(administrador.getId());
        if(administradorBuscado.isPresent())
            throw new Exception("El código del administrador ya se encuentra registrado");
        administradorBuscado = administradorRepository.findByEmail(administrador.getEmail());
        if(administradorBuscado.isPresent())
            throw new Exception("El email del administrador ya se encuentra registrado");
        administradorBuscado = administradorRepository.findByNickname(administrador.getNickname());
        if(administradorBuscado.isPresent())
            throw new Exception("El nickname del administrador ya se encuentra registrado");
        administrador.setFechaRegistro(LocalDateTime.now());
        return administradorRepository.save(administrador);
    }

    @Override
    public Administrador actualizarAdministrador(Administrador administrador) throws Exception {
        buscarAdministradorPorId(administrador.getId());
        return administradorRepository.save(administrador);
    }

    @Override
    public Administrador buscarAdministradorPorId(Integer idAdministrador) throws Exception {
        Optional<Administrador> administrador = administradorRepository.findById(idAdministrador);
        if (administrador.isEmpty())
            throw new Exception("El código del administrador no se encuentra registrado");
        return administrador.get();
    }

    @Override
    public void eliminarAdministrador(Integer idAdministrador) throws Exception {
        buscarAdministradorPorId(idAdministrador);
        administradorRepository.deleteById(idAdministrador);
    }

    @Override
    public List<Administrador> listarAdministradores() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador validarAdministrador(String email, String password) throws Exception {
        return administradorRepository.validarGerente(email, password)
                .orElseThrow(()->new Exception("Los datos de autenticación del administrador son incorrectos"));
    }

    @Override
    public Administrador recuperarClaveDeAcceso(String email) throws Exception {
        return null;
    }

    @Override
    public Administrador buscarAdministradorPorNickname(String nickname) throws Exception {
        return administradorRepository.findByNickname(nickname).orElseThrow(()-> new Exception("El nickname del administrador no se encuentra registrado"));
    }

    @Override
    public Administrador buscarAdministradorPorEmail(String email) throws Exception{
        return administradorRepository.findByEmail(email).orElseThrow(()-> new Exception("El email  del administrador no se encuentra registrado"));
    }

    @Override
    public Region registrarRegion(Region region) throws Exception {
        Optional<Region> regionBuscada = regionRepository.findByRegion(region.getRegion());
        if(regionBuscada.isPresent())
            throw new Exception("La región ya se encuentra registrada");
        return regionRepository.save(region);
    }

    @Override
    public Region actualizarRegion(Region region) throws Exception {
        buscarRegionPorId(region.getIdRegion());
        return regionRepository.save(region);
    }

    @Override
    public Region buscarRegionPorId(Integer idRegion) throws Exception {
        Optional<Region> region = regionRepository.findById(idRegion);
        if (region.isEmpty())
            throw new Exception("El código de la región no se encuentra registrado");
        return region.get();
    }

    @Override
    public void eliminarRegion(Integer idRegion) throws Exception {
        buscarRegionPorId(idRegion);
        regionRepository.deleteById(idRegion);
    }

    @Override
    public List<Region> listarRegiones() {
        return regionRepository.findAll();
    }

    @Override
    public Ciudad registrarCiudad(Ciudad ciudad) throws Exception {
        Optional<Ciudad> ciudadBuscada = ciudadRepository.findByCiudad(ciudad.getCiudad());
        if(ciudadBuscada.isPresent())
            throw new Exception("La ciudad ya se encuentra registrada");
        return ciudadRepository.save(ciudad);
    }

    @Override
    public Ciudad actualizarCiudad(Ciudad ciudad) throws Exception {
        buscarCiudadPorId(ciudad.getIdCiudad());
        Optional<Ciudad> ciudadExistente = validarCiudad(ciudad.getRegion().getIdRegion(), ciudad.getCiudad());
        if(ciudadExistente.isPresent())
            throw new Exception("La ciudad ya se encuentra registrada");
        return ciudadRepository.save(ciudad);
    }

    @Override
    public Ciudad buscarCiudadPorId(Integer idCiudad) throws Exception {
        Optional<Ciudad> ciudad = ciudadRepository.findById(idCiudad);
        if (ciudad.isEmpty())
            throw new Exception("El código de la ciudad no se encuentra registrado");
        return ciudad.get();
    }

    @Override
    public void eliminarCiudad(Integer idCiudad) throws Exception {
        buscarCiudadPorId(idCiudad);
        ciudadRepository.deleteById(idCiudad);
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepository.findAll();
    }

    @Override
    public List<Ciudad> listarCiudadesRegion(Integer idRegion) throws Exception{
        buscarRegionPorId(idRegion);
        return ciudadRepository.listarCiudadesRegion(idRegion);
    }

    @Override
    public Optional<Ciudad> buscarCiudadPorNombre(String ciudad) {
        return ciudadRepository.findByCiudad(ciudad);
    }

    @Override
    public Optional<Ciudad> validarCiudad(Integer idRegion, String ciudad) throws Exception {
        buscarRegionPorId(idRegion);
        Optional<Ciudad> ciudad1 = ciudadRepository.validarCiudad(idRegion, ciudad);
        System.out.println(ciudad1);
        return ciudad1;
    }
}
