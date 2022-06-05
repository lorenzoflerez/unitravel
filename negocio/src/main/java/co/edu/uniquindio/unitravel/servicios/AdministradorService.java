package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Region;

import java.util.List;
import java.util.Optional;

public interface AdministradorService {

    Administrador registrarAdministrador(Administrador administrador) throws Exception;

    Administrador actualizarAdministrador(Administrador administrador) throws Exception;

    Administrador buscarAdministradorPorId(Integer idAdministrador) throws Exception;

    void eliminarAdministrador(Integer idAdministrador) throws Exception;

    List<Administrador> listarAdministradores();

    Administrador validarAdministrador(String email, String password) throws Exception;

    Administrador recuperarClaveDeAcceso(String email) throws Exception;

    Administrador buscarAdministradorPorNickname(String nickname) throws Exception;

    Administrador buscarAdministradorPorEmail(String email) throws Exception;


    Region registrarRegion(Region region) throws Exception;

    Region actualizarRegion(Region region) throws Exception;

    Region buscarRegionPorId(Integer idRegion) throws Exception;

    void eliminarRegion(Integer idRegion) throws Exception;

    List<Region> listarRegiones();


    Ciudad registrarCiudad(Ciudad ciudad) throws Exception;

    Ciudad actualizarCiudad(Ciudad ciudad) throws Exception;

    Ciudad buscarCiudadPorId(Integer idCiudad) throws Exception;

    void eliminarCiudad(Integer idCiudad) throws Exception;

    List<Ciudad> listarCiudades();

    List<Ciudad> listarCiudadesRegion(Integer idRegion) throws Exception;

    Optional<Ciudad> buscarCiudadPorNombre(String ciudad);

    Optional<Ciudad> validarCiudad(Integer idRegion, String ciudad) throws Exception;
}
