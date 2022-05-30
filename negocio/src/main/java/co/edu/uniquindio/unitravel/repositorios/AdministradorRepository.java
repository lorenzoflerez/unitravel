package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 */
@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    @Query("select a from Administrador a where a.email = :email and a.password = :password")
    Optional<Administrador> validarGerente(String email, String password);

    Optional<Administrador> findByNickname(String nickname);

    Optional<Administrador> findByEmail(String email);

}