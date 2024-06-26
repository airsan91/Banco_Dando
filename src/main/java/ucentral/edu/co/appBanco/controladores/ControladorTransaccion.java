package ucentral.edu.co.appBanco.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ucentral.edu.co.appBanco.entidades.Solicitud;
import ucentral.edu.co.appBanco.entidades.Transacciones;
import ucentral.edu.co.appBanco.servicios.ServiciosSolicitud;
import ucentral.edu.co.appBanco.servicios.ServiciosTransaccion;

import java.util.Date;


@Controller
public class ControladorTransaccion {
    @Autowired
    private ServiciosTransaccion serviciosTransaccion;
    @Autowired
    private ServiciosSolicitud serviciosSolicitud;

    @GetMapping("/listaTransaccionesT")
    public String listaTransacciones(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Transacciones> transacciones = (Page<Transacciones>) serviciosTransaccion.consultarT(PageRequest.of(page, 10));
        model.addAttribute("listatransaccionT", transacciones);
        return "listaTransacciones";
    }

    @GetMapping({"/transaccion/nuevo"})
    public String cargarTransaccionModal(Model model){
        Transacciones transaccionesllenar=new Transacciones();


        model.addAttribute("transaccionesllenar",transaccionesllenar);


        return "formcreatransaccion";

    }

    @PostMapping({"/accioncreartransaccion"})
    public String accioncrearTran(@ModelAttribute("transaccionllenar")Transacciones transacciones, Model model){
        System.out.println(transacciones);

        transacciones.setFecha(new Date());
        this.serviciosTransaccion.crear(transacciones);
        Solicitud ultimaSolicitud = serviciosSolicitud.getUltimaSolicitud();
        if (ultimaSolicitud != null) {
            model.addAttribute("estadoSolicitud", ultimaSolicitud.getEstado());
        } else {
            model.addAttribute("estadoSolicitud", "No hay solicitudes");
        }
        return "redirect:/listaTransacciones";
    }


    public void crearTransaccion(Transacciones transacciones){
        serviciosTransaccion.crear(transacciones);
    }

}



