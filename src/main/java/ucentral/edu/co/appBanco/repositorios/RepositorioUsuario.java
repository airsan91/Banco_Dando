package ucentral.edu.co.appBanco.repositorios;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucentral.edu.co.appBanco.entidades.Usuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Integer>{



    }

