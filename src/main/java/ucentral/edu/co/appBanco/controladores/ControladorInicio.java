package ucentral.edu.co.appBanco.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ucentral.edu.co.appBanco.entidades.Usuario;
import ucentral.edu.co.appBanco.servicios.ServicioUsuario;

@Controller
public class ControladorInicio {

    @Autowired
    ServicioUsuario servicioUsuario;
    @GetMapping({"/usuario/iniciarsesion"})
    public String iniciarUsuario(Model model){
        Usuario usuariollenar= new Usuario();

        model.addAttribute("usuariollenar",usuariollenar);
        System.out.println("Paso por aca para iniciar");
        return "iniciarsesionUsuario";
    }
    @Controller
    public class ControladorPAginaPrincipal {
        @GetMapping({"/usuario/principal"})
        public String principal(Model model){
            return "pantallaUsuario";
        }
    }


}

