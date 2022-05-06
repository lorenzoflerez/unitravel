package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {

    @Query("select v from Vuelo v where v.origen = :idOrigen")
    List<Vuelo> listarVuelosOrigen(Integer idOrigen);

    @Query("select v from Vuelo v where v.destino = :idDestino")
    List<Vuelo> listarVuelosDestino(Integer idDestino);

    @Query("select v from Vuelo v where v.origen = :idOrigen and v.destino = :idDestino")
    List<Vuelo> listarVuelosOrigenYDestino(Integer idOrigen, Integer idDestino);

    @Query("select v from Vuelo v where v.aerolinea = :idAerolinea")
    List<Vuelo> listarVuelosAerolinea(Integer idAerolinea);

    @Query("select v from Vuelo v where v.estado = :idEstado")
    List<Vuelo> listarVuelosEstado(Integer idEstado);

    @Query("select v from Vuelo v where v.fechaSalida = :fechaSalida")
    List<Vuelo> listarVuelosHoraSalida(LocalDateTime fechaSalida);

    @Query("select v from Vuelo v where v.fechaLlegada = :fechaLlegada")
    List<Vuelo> listarVuelosHoraLllegada(LocalDateTime fechaLlegada);

    @Query("select v, count(r) from Vuelo v join v.sillas s join s.reservas r where v.idVuelo = :idVuelo and r.reserva.fechaFin < :fecha")
    Optional<Object[]> contarSillasDisponiblesVuelo(Integer idVuelo, LocalDateTime fecha);
}