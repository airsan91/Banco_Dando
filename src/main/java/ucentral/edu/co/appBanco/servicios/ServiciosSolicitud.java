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
        solicitud.setEstado("No se ha enviado ninguna solicitud"); // Set the estado to "No se ha enviado ninguna solicitud"
        return repositorioSolicitud.save(solicitud);
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

    public void enviarSolicitud(Solicitud solicitud) {
        solicitud.setEstado("Solicitud Pendiente"); // Update the estado to "Solicitud Pendiente"
        repositorioSolicitud.save(solicitud);
    }

    public List<Solicitud> getSolicitudesPendientes() {
        return repositorioSolicitud.findAllByDecisionIsNull();
    }

    public void aceptarSolicitud(int codigo) {
        Solicitud solicitud = repositorioSolicitud.findByCodigo(codigo);
        if (solicitud != null) {
            solicitud.setDecision("Accepted");
            solicitud.setEstado("Solicitud Aceptada"); // Update the estado to "Solicitud Aceptada"
            repositorioSolicitud.save(solicitud);
        }
    }

    public void rechazarSolicitud(int codigo) {
        Solicitud solicitud = repositorioSolicitud.findByCodigo(codigo);
        if (solicitud != null) {
            solicitud.setDecision("Rejected");
            solicitud.setEstado("Solicitud Rechazada"); // Update the estado to "Solicitud Rechazada"
            repositorioSolicitud.save(solicitud);
        }
    }

}
