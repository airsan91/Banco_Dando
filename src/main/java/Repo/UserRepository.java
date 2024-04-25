package Repo;

import modelo.Usuario;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

public interface UserRepository extends JpaRepositoriesAutoConfiguration<Usuario, Long> {

    Usuario findByUsername(String username){
        return null;
    }

}
