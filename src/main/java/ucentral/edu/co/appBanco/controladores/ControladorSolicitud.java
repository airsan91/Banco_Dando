package ucentral.edu.co.appBanco.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ucentral.edu.co.appBanco.entidades.Solicitud;
import ucentral.edu.co.appBanco.entidades.Transacciones;
import ucentral.edu.co.appBanco.servicios.ServiciosSolicitud;
import ucentral.edu.co.appBanco.servicios.ServiciosTransaccion;

import java.util.List;

@Controller
public class ControladorSolicitud {
    @Autowired
    ServiciosSolicitud serviciosSolicitud;
    @Autowired
    ServiciosTransaccion serviciosTransaccion;

    @GetMapping({"/solicitud/nuevo"})
    public String cargarSolicitud(Model model){
        Solicitud solicitudllenar= new Solicitud();

        model.addAttribute("solicitudllenar",solicitudllenar);

        return "formcrearSolicitud";
    }

    @PostMapping("/enviarSolicitud")
    public String enviarSolicitud(@ModelAttribute Solicitud solicitud, Model model) {
        Solicitud solicitudExistente = serviciosSolicitud.buscarPorCodigo(solicitud.getCodigo());
        System.out.println("Solicitud recibida: " + solicitud);
        System.out.println("Solicitud existente antes de la actualización: " + solicitudExistente);

        if (solicitudExistente != null) {
            solicitudExistente.setEstado("pendiente");
            serviciosSolicitud.enviarSolicitud(solicitudExistente);
            System.out.println("Solicitud existente después de la actualización: " + solicitudExistente);
        } else {
            solicitud.setEstado("pendiente");
            solicitud.setCodigo(solicitud.getCodigo());
            serviciosSolicitud.enviarSolicitud(solicitud);
            System.out.println("Nueva solicitud después de la creación: " + solicitud);
        }

        model.addAttribute("solicitudes", serviciosSolicitud.getTodasLasSolicitudes());
        return "solicitarTarjeta";
    }

    @PostMapping({"/accioncrearsolicitud"})
    public String accioncrearsolicitud(@ModelAttribute("solicitudllenar")Solicitud solicitud, RedirectAttributes redirectAttributes){
        // Validación de los campos de la solicitud
        if (solicitud.getNombre() == null || solicitud.getDocumento() == 0 || solicitud.getIngresos() == 0 || solicitud.getGastos() == 0 || solicitud.getDeudas() == 0) {
            redirectAttributes.addFlashAttribute("message", "Todos los campos son requeridos.");
            return "formcrearSolicitud";
        }

        this.serviciosSolicitud.crear(solicitud);
        redirectAttributes.addFlashAttribute("message", "Solicitud creada con éxito.");
        return "redirect:/listaTransacciones";
    }
    public void crearSolicitud(Solicitud solicitud){serviciosSolicitud.crear(solicitud);}

    @GetMapping("/estado-solicitud")
    public String estadoSolicitud(Model model, RedirectAttributes redirectAttributes) {
        Solicitud solicitud = serviciosSolicitud.getUltimaSolicitud();

        if (solicitud != null) {
            model.addAttribute("solicitud", solicitud);

            redirectAttributes.addFlashAttribute("message", "Estado de la solicitud: " + solicitud.getEstado());
        } else {
            redirectAttributes.addFlashAttribute("message", "No hay solicitudes pendientes.");
        }

        return "estadoSolicitud";
    }

    @PostMapping("/solicitarTarjeta")
    public String solicitarTarjeta(@ModelAttribute Solicitud solicitud) {
        solicitud.setEstado("Pendiente");
        serviciosSolicitud.crear(solicitud);
        return "redirect:/estado-solicitud";
    }
    @GetMapping("/listaTransacciones")
    public String listaTransacciones(Model model) {
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("codigoTran"));
        Page<Transacciones> page = serviciosTransaccion.consultarT(pageable);
        List<Transacciones> transacciones = page.getContent();
        model.addAttribute("listatransaccionT", transacciones);
        return "listaTransacciones";
    }
    @GetMapping("/solicitar-tarjeta")
    public String solicitarTarjeta(Model model) {
        // Obtén todas las solicitudes
        List<Solicitud> solicitudes = serviciosSolicitud.getTodasLasSolicitudes();

        // Agrega las solicitudes al modelo
        model.addAttribute("solicitudes", solicitudes);

        // Devuelve la vista solicitar-tarjeta
        return "solicitarTarjeta";
    }
}
