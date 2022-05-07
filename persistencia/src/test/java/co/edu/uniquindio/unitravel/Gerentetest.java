package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Gerente;
import co.edu.uniquindio.unitravel.repositorios.GerenteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Gerentetest {

    @Autowired
    private GerenteRepository gerenteRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarGerentes() {
        List<Gerente> gerentes = gerenteRepository.findAll();
        System.out.println(gerentes);
    }

}
