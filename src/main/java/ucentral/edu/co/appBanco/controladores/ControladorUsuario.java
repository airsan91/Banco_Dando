package ucentral.edu.co.appBanco.controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import ucentral.edu.co.appBanco.entidades.Usuario;
import ucentral.edu.co.appBanco.operaciones.OperacionesUsuario;
import ucentral.edu.co.appBanco.servicios.ServicioUsuario;




@Controller
public class ControladorUsuario {
    @Autowired
    private OperacionesUsuario operacionesUsuario;
    @Autowired
    ServicioUsuario servicioUsuario;

    @GetMapping({"/usuario/nuevo"})
    public String cargarUsuario(Model model) {
        Usuario usuariollenar = new Usuario();

        model.addAttribute("usuariollenar", usuariollenar);
        return "formcrearUsuario";
    }


    @PostMapping({"/accioncrear"})
    public String accioncrear(@ModelAttribute("usuariollenar") Usuario usuario) {
        System.out.println(usuario);
        operacionesUsuario.crear(usuario);
        return "pantallaUsuario";
    }
    public Usuario crearUsuario(Usuario usuario){
        return servicioUsuario.crear(usuario);
    }
}
