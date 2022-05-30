package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    @Query("select h from Horario h where h.dia = :dias and h.horaInicio = :inicio and h.horaFin = :fin")
    Optional<Horario> validarHorario(String dias, LocalTime inicio, LocalTime fin);
}