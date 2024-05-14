package ucentral.edu.co.appBanco.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPAginaPrincipal {
    @GetMapping({"/usuario/principal"})
    public String principal(Model model){
        return "pantallaUsuario";
    }
}
