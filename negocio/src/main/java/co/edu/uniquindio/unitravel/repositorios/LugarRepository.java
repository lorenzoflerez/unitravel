package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LugarRepository extends JpaRepository<Lugar, Integer> {

    @Query("select l from Lugar l where l.ciudad.idCiudad = :idCiudad")
    List<Lugar> listarLugaresCiudad(Integer idCiudad);

    @Query("select l from Lugar l join l.paquetes p where p.idPaquete = :idPaquete")
    List<Lugar> listarLugaresPaquete(Integer idPaquete);

    @Query("select l from Lugar l join l.paquetes p join p.horarios h where h.dia like concat('%', :dias, '%')")
    List<Lugar> listarLugaresDiasHabiles(String dias);

    @Query("select l from Lugar l where l.nombre like concat('%', :nombre, '%')")
    List<Lugar> listarLugarNombre(String nombre);
}