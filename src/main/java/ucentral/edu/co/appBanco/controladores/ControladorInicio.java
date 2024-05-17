package ucentral.edu.co.appBanco.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ucentral.edu.co.appBanco.entidades.Usuario;
import ucentral.edu.co.appBanco.servicios.ServicioUsuario;

import java.util.Objects;

@Controller
public class ControladorInicio {

    @Autowired
    private ServicioUsuario servicioUsuario;
    @GetMapping({"/usuario/iniciarsesion"})
    public String iniciarUsuario(Model model){
        Usuario usuariollenar= new Usuario();

        model.addAttribute("usuariollenar",usuariollenar);

        return "iniciarsesionUsuario";
    }
    @Controller
    public class ControladorPAginaPrincipal {
        @GetMapping({"/usuario/principal"})
        public String principal(Model model){
            return "pantallaUsuario";
        }
    }
    @PostMapping("/inicio")
    public String iniciosesion(@RequestParam String nombreUsuario, @RequestParam String password, Model modelo){
        Usuario usuario= servicioUsuario.findByNombreUsuario(nombreUsuario);
        if(usuario!=null && Objects.equals(usuario.getContrasena(), password)){
            return "listaTransacciones";
        }
        else {
            return "index";
        }

    }


}

