package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer> {

    @Query("select f from Foto f where f.hotel.idHotel = :idHotel")
    List<Foto> listarFotosHotel(Integer idHotel);

    @Query("select f from Foto f where f.habitacion.idHabitacion = :idHabitacion")
    List<Foto> listarFotosHabitacion(Integer idHabitacion);

    @Query("select f from Foto f where f.url = :url")
    Optional<Foto> buscarFoto(String url);

}