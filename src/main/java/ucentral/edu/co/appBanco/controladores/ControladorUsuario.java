package ucentral.edu.co.appBanco.controladores;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ucentral.edu.co.appBanco.dto.UsuarioDto;
import ucentral.edu.co.appBanco.servicios.ServicioUsuario;

import java.util.logging.Logger;

@Log4j2
@Controller
public class ControladorUsuario {
    private static final Logger logger = Logger.getLogger(String.valueOf(ControladorUsuario.class));
    @Autowired
    ServicioUsuario servicioUsuario;

    @GetMapping("/usuario/nuevo")
    public String mostrarFormulario(Model model){
        UsuarioDto usuarioDto = new UsuarioDto();
        model.addAttribute("usuario", usuarioDto);
        return "crear_usuario";
    }
    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioDto usuario){
        servicioUsuario.crear(usuario);
        return "redirect:/usuario";
    }
}
