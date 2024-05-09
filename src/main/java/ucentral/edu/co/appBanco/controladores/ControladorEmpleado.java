package ucentral.edu.co.appBanco.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ucentral.edu.co.appBanco.DTO.EmpleadoDTO;
import ucentral.edu.co.appBanco.entidades.Empleado;
import ucentral.edu.co.appBanco.servicios.ServicioEmpleado;
import org.springframework.ui.Model;
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
}
