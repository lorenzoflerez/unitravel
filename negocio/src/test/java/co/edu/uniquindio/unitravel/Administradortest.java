package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Administradortest {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdministradores() {
        List<Administrador> administradores = administradorRepository.findAll();
        System.out.println(administradores);
    }
}
