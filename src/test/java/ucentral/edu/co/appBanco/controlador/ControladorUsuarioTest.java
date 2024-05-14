package ucentral.edu.co.appBanco.controlador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;


import ucentral.edu.co.appBanco.controladores.ControladorUsuario;
import ucentral.edu.co.appBanco.entidades.Usuario;
import ucentral.edu.co.appBanco.servicios.ServicioUsuario;

@ExtendWith(MockitoExtension.class)
 class ControladorUsuarioTest {
    @Mock
    private ServicioUsuario servicioUsuario;

    @InjectMocks
    private ControladorUsuario controladorUsuario;

    @BeforeEach
    public  void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test guardar controlador thymeleaf")
    @Test
    void testGuardar() throws Exception{
        Usuario usuario= Usuario
                .builder()
                .codigo(1)
                .nombreUsuario("erick trujillo")
                .correoUsuario("etrujillo@gmail.com")
                .telefonoUsuario(31125554)
                .contrasena("12345")
                .build();
        given(servicioUsuario.crear(any(Usuario.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));
        //when
        Usuario usuarioG=controladorUsuario.crearUsuario(usuario);

        assertThat(usuarioG).isNotNull();



    }
}
