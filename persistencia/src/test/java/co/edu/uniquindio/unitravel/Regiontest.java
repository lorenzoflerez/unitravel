package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Region;
import co.edu.uniquindio.unitravel.repositorios.RegionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Regiontest {

    @Autowired
    private RegionRepository regionRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarRegiones() {
        List<Region> regiones = regionRepository.findAll();
        System.out.println(regiones);
    }
}
