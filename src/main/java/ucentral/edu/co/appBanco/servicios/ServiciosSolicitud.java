package ucentral.edu.co.appBanco.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucentral.edu.co.appBanco.entidades.Solicitud;
import ucentral.edu.co.appBanco.operaciones.OperacionesSolicitud;
import ucentral.edu.co.appBanco.repositorios.RepositorioSolicitud;

import java.util.Date;
import java.util.List;

@Service
public class ServiciosSolicitud implements OperacionesSolicitud {

    @Autowired
    RepositorioSolicitud repositorioSolicitud;

    @Override
    public Solicitud crear(Solicitud solicitud) {
        System.out.println("Before save: " + solicitud);
        solicitud.setFechaCreacion(new Date());
        solicitud.setEstado("No se ha hecho una solicitud");
        Solicitud savedSolicitud = repositorioSolicitud.save(solicitud);
        System.out.println("After save: " + savedSolicitud);
        return savedSolicitud;
    }

    @Transactional(readOnly = true)
    public Solicitud getUltimaSolicitud() {
        return repositorioSolicitud.findTopByOrderByFechaCreacionDesc();
    }


    public List<Solicitud> getTodasLasSolicitudes() {
        return repositorioSolicitud.findAll();
    }

    @Transactional(readOnly = true)
    public Solicitud buscarPorCodigo(int codigo) {
        return repositorioSolicitud.findByCodigo(codigo);
    }

    @Transactional
    public void enviarSolicitud(Solicitud solicitud) {
        repositorioSolicitud.save(solicitud);
    }



}
