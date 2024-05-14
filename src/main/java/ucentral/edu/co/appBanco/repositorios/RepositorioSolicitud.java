package ucentral.edu.co.appBanco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import ucentral.edu.co.appBanco.entidades.Solicitud;

public interface RepositorioSolicitud extends JpaRepository<Solicitud,Integer> {
}
