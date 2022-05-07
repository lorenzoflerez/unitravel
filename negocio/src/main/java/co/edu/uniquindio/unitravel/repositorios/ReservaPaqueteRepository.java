package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.ReservaPaquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaPaqueteRepository extends JpaRepository<ReservaPaquete, Integer> {


    @Query("select rp, rp.paquete from Cliente c join c.reservas r join r.paquetes rp where c.id = :idCliente and r.fechaInicio <= :fecha and r.fechaFin >= :fecha")
    List<Object[]> listarPaqueteReservadosCliente(Integer idCliente, LocalDateTime fecha);

    @Query("select rp, sum(rp.subTotal) from ReservaPaquete rp where rp.reserva.idReserva = :idReserva group by rp.reserva")
    Optional<Object[]> calcularTotalReservaPaquete(Integer idReserva);

}