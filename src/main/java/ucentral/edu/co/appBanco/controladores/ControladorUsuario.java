package ucentral.edu.co.appBanco.controladores;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import ucentral.edu.co.appBanco.entidades.Usuario;
import ucentral.edu.co.appBanco.servicios.ServicioUsuario;

import java.util.logging.Logger;


@Controller
public class ControladorUsuario {
    @Autowired
    ServicioUsuario servicioUsuario;


    @PostMapping("/usuario/autenticar")
    public String autenticar(@RequestBody Usuario Usuario) {
        Usuario usuario = servicioUsuario.auntentificar(Usuario.getNombreUsuario(), Usuario.getContrasena());

        if (usuario != null) {
            return "listaTransacciones";
        } else {
            return "formcrearUsuario";
        }
    }

    @GetMapping({"/usuario/nuevo"})
    public String cargarUsuario(Model model){
        Usuario usuariollenar= new Usuario();

        model.addAttribute("usuariollenar",usuariollenar);
        System.out.println("PAso por aca formulario");
        return "formcrearUsuario";
    }



    @PostMapping({"/accioncrear"})
    public String accioncrear(@ModelAttribute("usuariollenar")Usuario usuario){
        System.out.println("Paso por aca para guardar formulario");
        System.out.println(usuario);
        this.servicioUsuario.crear(usuario);
        return "redirect:http://localhost:8862/";
    }
    public  Usuario crearUsuario(Usuario usuario){return servicioUsuario.crear(usuario);}

}
