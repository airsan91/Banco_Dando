package ucentral.edu.co.appBanco.servicios;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.edu.co.appBanco.entidades.Empleado;
import ucentral.edu.co.appBanco.repositorios.RepositorioEmpleado;

@Service
public class ServicioEmpleado {
    @Autowired
    private RepositorioEmpleado repositorioEmpleado;

    public Empleado auntentificar(String usuario, String contrasena){
        return repositorioEmpleado.findByUsuarioEmpleadoAndContrasena(usuario,contrasena);
    }

}
