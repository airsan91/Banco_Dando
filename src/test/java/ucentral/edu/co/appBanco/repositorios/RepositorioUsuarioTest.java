package ucentral.edu.co.appBanco.repositorios;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ucentral.edu.co.appBanco.entidades.Usuario;
import ucentral.edu.co.appBanco.repositorios.RepositorioUsuario;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
 class RepositorioUsuarioTest {
    @Autowired
    RepositorioUsuario repositorioUsuario;

    @Autowired
    TestEntityManager testEntityManager;
    @DisplayName("Test de usuarios")
    @Test
    void testguardarUsuario(){
        Usuario usuario= Usuario
                .builder()
                .nombreUsuario("juan")
                .cedula(123456)
                .correoUsuario("juan@ucentral.edu.co")
                .telefonoUsuario(125478)
                .contrasena("juan1234")
                .build();

        Usuario usuario1= repositorioUsuario.save(usuario);

        assertThat(usuario1).isNotNull();
        assertThat(usuario1.getCodigo()).isGreaterThan(0);
    }
}
