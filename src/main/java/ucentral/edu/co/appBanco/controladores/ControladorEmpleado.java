package ucentral.edu.co.appBanco.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ucentral.edu.co.appBanco.DTO.EmpleadoDTO;
import ucentral.edu.co.appBanco.entidades.Empleado;
import ucentral.edu.co.appBanco.entidades.SolicitarTarjeta;
import ucentral.edu.co.appBanco.servicios.ServicioEmpleado;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ControladorEmpleado {
    @Autowired
    private ServicioEmpleado servicioEmpleado;

    @PostMapping("/empleado/autenticar")
    public String autenticar(@RequestBody EmpleadoDTO EmpleadoDTO){
        Empleado empleado = servicioEmpleado.auntentificar(EmpleadoDTO.getUsuarioEmpleado(), EmpleadoDTO.getContrasena());

        if(empleado != null){
            return "Bienvenido";
    }else {
        return "Usuario o contraseña incorrecta";
    }
    }
    @GetMapping("/solicitarTarjeta")
    public String getAllSolicitarTarjeta(Model model) {
        List<SolicitarTarjeta> solicitarTarjetas = servicioEmpleado.getAllSolicitarTarjeta();
        model.addAttribute("solicitarTarjetas", solicitarTarjetas);
        return "solicitarTarjeta";
    }

    @PostMapping("/acceptRequest")
    public String acceptRequest(@RequestParam("requestId") Long requestId) {
        servicioEmpleado.acceptRequest(requestId);
        return "redirect:/solicitarTarjeta";
    }

    @PostMapping("/rejectRequest")
    public String rejectRequest(@RequestParam("requestId") Long requestId) {
        servicioEmpleado.rejectRequest(requestId);
        return "redirect:/solicitarTarjeta";
    }
}
