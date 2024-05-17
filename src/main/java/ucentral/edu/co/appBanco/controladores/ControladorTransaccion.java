package ucentral.edu.co.appBanco.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ucentral.edu.co.appBanco.entidades.Transacciones;
import ucentral.edu.co.appBanco.servicios.ServiciosTransaccion;

@Controller
public class ControladorTransaccion {
    @Autowired
    ServiciosTransaccion serviciosTransaccion;

    @GetMapping({"/transaccion/lista"})
    public String listartransaccion(Model model){
        model.addAttribute("listatransaccionT",serviciosTransaccion.consultarT());
        for (Transacciones lasTransacciones: serviciosTransaccion.consultarT()){
            System.out.println(lasTransacciones);
        }

        return "listaTransacciones";
    }

    @GetMapping({"/transaccion/nuevo"})
    public String cargarTransaccionModal(Model model){
        Transacciones transaccionesllenar=new Transacciones();


        model.addAttribute("transaccionesllenar",transaccionesllenar);


        return "formcreatransaccion";

    }

    @PostMapping({"/accioncreartransaccion"})
    public String accioncrearTran(@ModelAttribute("transaccionllenar")Transacciones transacciones){
        System.out.println(transacciones);
        this.serviciosTransaccion.crear(transacciones);
        return "redirect:/transaccion/lista";
    }


    public void crearTransaccion(Transacciones transacciones){
        serviciosTransaccion.crear(transacciones);
    }

}

