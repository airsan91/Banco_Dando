package ucentral.edu.co.appBanco.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ucentral.edu.co.appBanco.entidades.Transacciones;

public interface RepositorioTransaccion extends JpaRepository<Transacciones,Integer> {
}
