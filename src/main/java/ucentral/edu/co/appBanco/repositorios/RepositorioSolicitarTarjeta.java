package ucentral.edu.co.appBanco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucentral.edu.co.appBanco.entidades.SolicitarTarjeta;
@Repository
public interface RepositorioSolicitarTarjeta extends JpaRepository<SolicitarTarjeta, Integer> {

}
