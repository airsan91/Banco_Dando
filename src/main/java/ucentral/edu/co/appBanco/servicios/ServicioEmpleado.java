package ucentral.edu.co.appBanco.servicios;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ucentral.edu.co.appBanco.entidades.Empleado;
import ucentral.edu.co.appBanco.entidades.SolicitarTarjeta;
import ucentral.edu.co.appBanco.entidades.Solicitud;
import ucentral.edu.co.appBanco.entidades.Tarjeta_De_Credito;
import ucentral.edu.co.appBanco.repositorios.RepositorioEmpleado;
import ucentral.edu.co.appBanco.repositorios.RepositorioSolicitarTarjeta;
import ucentral.edu.co.appBanco.repositorios.RepositorioSolicitud;
import ucentral.edu.co.appBanco.repositorios.RepositorioTarjeta_De_Credito;

import java.util.List;

@Service
public class ServicioEmpleado {
    @Autowired
    private RepositorioEmpleado repositorioEmpleado;
    @Autowired
    private RepositorioTarjeta_De_Credito RepositorioTarjeta_De_Credito;
    @Autowired
    private RepositorioSolicitarTarjeta repositorioSolicitarTarjeta;
    @Autowired
    private RepositorioSolicitud repositorioSolicitud;

    public Empleado auntentificar(String usuario, String contrasena){
        Empleado empleado = repositorioEmpleado.findByUsuarioEmpleadoAndContrasena(usuario,contrasena);
        return empleado;
    }

    public List<SolicitarTarjeta> getAllSolicitarTarjeta() {
        return repositorioSolicitarTarjeta.findAll();
    }

    public void acceptRequest(Long requestId) {
        SolicitarTarjeta request = repositorioSolicitarTarjeta.findById(Math.toIntExact(requestId)).orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus("Accepted");
        repositorioSolicitarTarjeta.save(request);
    }

    public void rejectRequest(Long requestId) {
        SolicitarTarjeta request = repositorioSolicitarTarjeta.findById(Math.toIntExact(requestId)).orElseThrow(() -> new RuntimeException("Request not found"));
        request.setStatus("Rejected");
        repositorioSolicitarTarjeta.save(request);
    }

    public void toggleCardBlock(String numTarjeta, boolean block) {
        Tarjeta_De_Credito tarjeta = RepositorioTarjeta_De_Credito.findByNumeroTarjeta(numTarjeta);
        if (tarjeta != null) {
            tarjeta.setBloqueada(block);
            RepositorioTarjeta_De_Credito.save(tarjeta);
        }
    }

    public Empleado createEmpleado(String usuario, String contrasena) {
        Empleado empleado = new Empleado();
        empleado.setUsuarioEmpleado(usuario);
        empleado.setContrasena(contrasena);

        return repositorioEmpleado.save(empleado);
    }

    @PostConstruct
    public void init() {
        if (repositorioEmpleado.findByUsuarioEmpleadoAndContrasena("SuperAdmin", "SuperPassword2024") == null) {
            createEmpleado("SuperAdmin", "SuperPassword2024");
        }


    }

    public Solicitud crearSolicitud(Solicitud solicitud) {
        return repositorioSolicitud.save(solicitud);
    }
    public void aceptarSolicitud(int codigo) {
        Solicitud solicitud = repositorioSolicitud.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Solicitud no encontrada con el código: " + codigo));
        solicitud.setEstado("Aceptada");
        repositorioSolicitud.save(solicitud);
    }

    public void rechazarSolicitud(int codigo) {
        Solicitud solicitud = repositorioSolicitud.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Solicitud no encontrada con el código: " + codigo));
        solicitud.setEstado("Rechazada");
        repositorioSolicitud.save(solicitud);
    }
    public List<Solicitud> getSolicitudesPendientes() {
        return repositorioSolicitud.findAllByDecisionIsNull();
    }
}
