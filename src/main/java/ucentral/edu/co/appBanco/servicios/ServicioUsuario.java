package ucentral.edu.co.appBanco.servicios;



import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucentral.edu.co.appBanco.entidades.Usuario;
import ucentral.edu.co.appBanco.operaciones.OperacionesUsuario;
import ucentral.edu.co.appBanco.repositorios.RepositorioUsuario;


@Service

public class ServicioUsuario implements OperacionesUsuario {


    @Autowired
    RepositorioUsuario repositorioUsuario;


    @Override
    public Usuario crear(Usuario usuario) {

        return repositorioUsuario.save(usuario);
    }
    public boolean existeUsuario(Integer codigo){
        return repositorioUsuario.existsById(codigo);
    }
}

