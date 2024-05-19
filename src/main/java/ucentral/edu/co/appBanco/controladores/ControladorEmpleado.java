package ucentral.edu.co.appBanco.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ucentral.edu.co.appBanco.DTO.EmpleadoDTO;
import ucentral.edu.co.appBanco.entidades.Empleado;
import ucentral.edu.co.appBanco.entidades.SolicitarTarjeta;
import ucentral.edu.co.appBanco.entidades.Solicitud;
import ucentral.edu.co.appBanco.repositorios.RepositorioEmpleado;
import ucentral.edu.co.appBanco.servicios.ServicioEmpleado;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ControladorEmpleado {
    @Autowired
    private ServicioEmpleado servicioEmpleado;

    private RepositorioEmpleado repositorioEmpleado;

    @GetMapping("/solicitarTarjeta")
    public String getAllSolicitarTarjeta(Model model) {
        List<SolicitarTarjeta> solicitarTarjetas = servicioEmpleado.getAllSolicitarTarjeta();
        model.addAttribute("solicitarTarjetas", solicitarTarjetas);
        return "solicitarTarjeta";
    }

    @GetMapping("/aceptarSolicitud/{id}")
    public String aceptarSolicitud(@PathVariable int id) {
        servicioEmpleado.aceptarSolicitud(id);
        return "redirect:/solicitarTarjeta";
    }

    @GetMapping("/rechazarSolicitud/{id}")
    public String rechazarSolicitud(@PathVariable int id) {
        servicioEmpleado.rechazarSolicitud(id);
        return "redirect:/solicitarTarjeta";
    }

    @GetMapping("/iniciarSesionEmpleado")
    public String iniciarSesionEmpleado() {
        return "inicioEmpleado";
    }
    @PostMapping("/inicioEmpleado")
    public String iniciarSesion(@RequestParam String usuario, @RequestParam String contrasena, Model model) {
        Empleado empleado = servicioEmpleado.auntentificar(usuario, contrasena);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "redirect:/solicitarTarjeta";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "inicioEmpleado"; // redirige de nuevo a la página de inicio de sesión
        }
    }
    public Empleado createEmpleado(String usuario, String contrasena) {
        Empleado empleado = new Empleado();
        empleado.setUsuarioEmpleado(usuario);
        empleado.setContrasena(contrasena);

        return repositorioEmpleado.save(empleado);
    }

}
