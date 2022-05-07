package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepository;
import co.edu.uniquindio.unitravel.repositorios.HotelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Hoteltest {

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHoteles() {
        List<Hotel> hoteles = hotelRepository.findAll();
        System.out.println(hoteles);
    }

}
