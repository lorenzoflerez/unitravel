package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query("select h from Hotel h where h.nombre like concat('%', :nombre, '%') ")
    List<Hotel> buscarHotel(String nombre);

    @Query("select h from Hotel h where h.estrellas >= :numEstrellas")
    List<Hotel> listarHotelesPorEstrellas(Integer numEstrellas);

    @Query("select h from Hotel h where h.gerente.id = :idGerente")
    List<Hotel> listarHotelesGerente(Integer idGerente);

    @Query("select h from Hotel h where h.ciudad.idCiudad = :idCiudad")
    List<Hotel> listarHotelesCiudad(Integer idCiudad);

    @Query("select h from Hotel h inner join h.ciudad c where c.region.idRegion = :idRegion")
    List<Hotel> listarHotelesRegion(Integer idRegion);

    @Query("select h from Hotel h left join h.caracteristicas c where c.idCaracteristica = :idCaracteristica")
    List<Hotel> listarHotelesCaracteristica(Integer idCaracteristica);

    @Query("select h from Hotel h inner join h.habitaciones a where a.precio between :minimo and :maximo ")
    List<Hotel> listarHotelesRangoPrecio(Double minimo, Double maximo);

    @Query("select h from Hotel h inner join h.habitaciones a where a.capacidad >= :capacidad  ")
    List<Hotel> listarHotelesCapacidadHabitacion(Integer capacidad);

    @Query("select h from Hotel h inner join h.habitaciones a inner join a.camas c where c.tipoCama = :tipoCama")
    List<Hotel> listarHotelesTipoCama(String tipoCama);

    @Query("select h from Hotel h where h.comentarios is empty")
    List<Hotel> listarHotelesSinComentarios();

    @Query("select h from Hotel h order by h.estrellas")
    List<Hotel> ordenarHotelesPorEstrellas();

    @Query("select h.ciudad.ciudad, count(h) from Hotel h group by h.ciudad")
    List<Object[]> contarHotelesPorCiudad();

    @Query("select h, avg(c.calificacion) from Hotel h join h.comentarios c group by h order by avg(c.calificacion)")
    List<Object[]> ordenarHotelesPorCalificacion();

    @Query("select h, avg(c.calificacion) from Hotel h join h.comentarios c  where h.idHotel = :idHotel group by h")
    List<Object[]> obtenerCalificacionHotel(Integer idHotel);

    @Query("select h, count(r) from Hotel h join h.habitaciones a join a.reservas r where h.idHotel = :idHotel and r.reserva.fechaInicio <= :fecha and r.reserva.fechaFin >= :fecha")
    Optional<Object[]> contarReservasActivasHotel(Integer idHotel, LocalDateTime fecha);

    @Query("select h, count(r) from Hotel h join h.habitaciones a join a.reservas r where h.idHotel = :idHotel and r.reserva.fechaFin < :fecha")
    Optional<Object[]> contarHabitacionesDisponiblesHotel(Integer idHotel, LocalDateTime fecha);
}