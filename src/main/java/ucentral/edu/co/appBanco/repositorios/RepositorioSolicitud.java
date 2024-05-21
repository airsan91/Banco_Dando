package ucentral.edu.co.appBanco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import ucentral.edu.co.appBanco.entidades.Solicitud;

import java.util.List;

public interface RepositorioSolicitud extends JpaRepository<Solicitud,Integer> {
    Solicitud findTopByOrderByFechaCreacionDesc();
    Solicitud findByCodigo(int codigo);
}
