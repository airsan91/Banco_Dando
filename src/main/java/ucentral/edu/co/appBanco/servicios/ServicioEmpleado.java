package ucentral.edu.co.appBanco.servicios;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucentral.edu.co.appBanco.entidades.Empleado;
import ucentral.edu.co.appBanco.entidades.SolicitarTarjeta;
import ucentral.edu.co.appBanco.entidades.Tarjeta_De_Credito;
import ucentral.edu.co.appBanco.repositorios.RepositorioEmpleado;
import ucentral.edu.co.appBanco.repositorios.RepositorioSolicitarTarjeta;
import ucentral.edu.co.appBanco.repositorios.RepositorioTarjeta_De_Credito;

import java.util.List;

@Service
public class ServicioEmpleado {
    @Autowired
    private RepositorioEmpleado repositorioEmpleado;
    private RepositorioTarjeta_De_Credito RepositorioTarjeta_De_Credito;
    private RepositorioSolicitarTarjeta repositorioSolicitarTarjeta;

    public Empleado auntentificar(String usuario, String contrasena){
        return repositorioEmpleado.findByUsuarioEmpleadoAndContrasena(usuario,contrasena);
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

}
