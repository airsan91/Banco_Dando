package ucentral.edu.co.appBanco.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ucentral.edu.co.appBanco.entidades.Solicitud;
import ucentral.edu.co.appBanco.servicios.ServiciosSolicitud;

@Controller
public class ControladorSolicitud {
    @Autowired
    ServiciosSolicitud serviciosSolicitud;

    @GetMapping({"/solicitud/nuevo"})
    public String cargarSolicitud(Model model){
        Solicitud solicitudllenar= new Solicitud();

        model.addAttribute("solicitudllenar",solicitudllenar);
        System.out.println("paso para registrar una nueva solicitud");
        return "formcrearSolicitud";
    }

    @PostMapping({"/accioncrearsolicitud"})
    public String accioncrearsolicitud(@ModelAttribute("solicitudllenar")Solicitud solicitud){
        System.out.println("guardo la solicitud");
        System.out.println(solicitud);
        this.serviciosSolicitud.crear(solicitud);
        return "listaTransacciones";
    }
    public void crearSolicitud(Solicitud solicitud){serviciosSolicitud.crear(solicitud);}
}
