package ucentral.edu.co.appBanco.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ucentral.edu.co.appBanco.entidades.Transacciones;
import ucentral.edu.co.appBanco.operaciones.OperacionesTransacciones;
import ucentral.edu.co.appBanco.repositorios.RepositorioTransaccion;

import java.util.List;

@Service
public class ServiciosTransaccion implements OperacionesTransacciones {
    private final RepositorioTransaccion repositorioTransaccion;

    public ServiciosTransaccion(RepositorioTransaccion repositorioTransaccion) {
        this.repositorioTransaccion = repositorioTransaccion;
    }

    @Override
    public Transacciones crear(Transacciones transacciones) {
        return repositorioTransaccion.save(transacciones);
    }

    @Override
    public Transacciones actualizar(Transacciones transacciones) {
        if(this.consultarPk(transacciones.getCodigoTran())!=null)
            return  repositorioTransaccion.save(transacciones);
        return null;
    }

    @Override
    public void borrar(Transacciones transacciones) {
        repositorioTransaccion.delete(transacciones);
    }

    @Override
    public Page<Transacciones> consultarT(Pageable pageable) {
        return  repositorioTransaccion.findAll(pageable);
    }

    @Override
    public Transacciones consultarPk(int pk) {
        return   repositorioTransaccion.findById(pk).orElse(null);
    }
}


