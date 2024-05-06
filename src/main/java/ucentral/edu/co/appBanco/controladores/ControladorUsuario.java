package ucentral.edu.co.appBanco.controladores;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ucentral.edu.co.appBanco.entidades.Usuario;
import ucentral.edu.co.appBanco.servicios.ServicioUsuario;

import java.util.logging.Logger;


@Controller
public class ControladorUsuario {
    @Autowired
    ServicioUsuario servicioUsuario;


    @GetMapping({"/usuario/nuevo"})
    public String cargarUsuario(Model model){
        Usuario usuariollenar= new Usuario();

        model.addAttribute("usuariollenar",usuariollenar);
        System.out.println("PAso por aca formulario");
        return "formcrearusuario";
    }

    @GetMapping({"/usuario/iniciar"})
    public String iniciarUsuario(Model model){
        Usuario usuariollenar= new Usuario();

        model.addAttribute("usuariollenar",usuariollenar);
        System.out.println("PAso por aca formulario");
        return "formcrearusuario";
    }


    @PostMapping({"/accioncrear"})
    public String accioncrear(@ModelAttribute("usuariollenar")Usuario usuario){
        System.out.println("Paso por aca para guardar formulario");
        System.out.println(usuario);
        this.servicioUsuario.crear(usuario);
        return "redirect:http://localhost:8862/";
    }
    public void crearUsuario(Usuario usuario){servicioUsuario.crear(usuario);}

}
