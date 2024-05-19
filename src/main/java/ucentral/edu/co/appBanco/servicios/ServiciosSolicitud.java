package ucentral.edu.co.appBanco.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.edu.co.appBanco.entidades.Solicitud;
import ucentral.edu.co.appBanco.operaciones.OperacionesSolicitud;
import ucentral.edu.co.appBanco.repositorios.RepositorioSolicitud;

import java.util.Date;

@Service
public class ServiciosSolicitud implements OperacionesSolicitud {

    @Autowired
    RepositorioSolicitud repositorioSolicitud;

    @Override
    public Solicitud crear(Solicitud solicitud) {
        solicitud.setFechaCreacion(new Date());
        return repositorioSolicitud.save(solicitud);
    }

    public Solicitud getUltimaSolicitud() {
        return repositorioSolicitud.findTopByOrderByFechaCreacionDesc();
    }
}
