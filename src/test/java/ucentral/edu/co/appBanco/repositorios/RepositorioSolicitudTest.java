package ucentral.edu.co.appBanco.repositorios;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ucentral.edu.co.appBanco.entidades.Solicitud;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
 class RepositorioSolicitudTest {

    @Autowired
    RepositorioSolicitud repositorioSolicitud;

    @Autowired
    TestEntityManager testEntityManager;

    @DisplayName("test de solicitud")
    @Test
    void testsoliciTartarjeta(){
        Solicitud solicitud= Solicitud
                .builder()
                .nombre("laura")
                .documento(136697554)
                .ingresos(780000)
                .gastos(62000)
                .deudas(23000)
                .build();

        Solicitud solicitud1= repositorioSolicitud.save(solicitud);

        assertThat(solicitud1).isNotNull();
        assertThat(solicitud1.getCodigo()).isGreaterThan(0);


    }
}