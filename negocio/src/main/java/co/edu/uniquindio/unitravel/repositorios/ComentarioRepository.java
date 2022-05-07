package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

    @Query("select c from Comentario c where c.hotel.idHotel = :idHotel")
    List<Comentario> listarComentariosHotel(Integer idHotel);

    @Query("select c from Comentario c where c.cliente.id = :idCliente")
    List<Comentario> listarComentariosCliente(Integer idCliente);
}