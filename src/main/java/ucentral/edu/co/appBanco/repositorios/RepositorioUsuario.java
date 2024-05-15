package ucentral.edu.co.appBanco.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ucentral.edu.co.appBanco.entidades.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

   Usuario findByNombreUsuarioAndContrasena (String nombreUsuario, String contrasena);

    }

