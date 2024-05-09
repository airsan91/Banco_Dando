package ucentral.edu.co.appBanco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucentral.edu.co.appBanco.entidades.Empleado;
import ucentral.edu.co.appBanco.entidades.Transacciones;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado,Integer> {
    Empleado findByUsuarioEmpleadoAndContrasena(String usuarioEmpleado, String contrasena);
}
