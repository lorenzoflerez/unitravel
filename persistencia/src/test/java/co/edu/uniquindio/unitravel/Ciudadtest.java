package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Ciudadtest {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudad() {
        List<Ciudad> ciudades = ciudadRepository.findAll();
        System.out.println(ciudades);
    }
}
