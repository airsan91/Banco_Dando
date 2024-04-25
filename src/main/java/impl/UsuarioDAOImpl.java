package impl;

import DAO.TarjetaDeCreditoDAO;
import DAO.UsuarioDAO;
import Repo.UserRepository;
import modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// Implementación de la clase UsuarioDAO
@Repository
public class UsuarioDAOImpl extends UsuarioDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Usuario autenticarUsuario(String username, String password) {
        Usuario usuario = userRepository.findByUsername(username);
        if (usuario != null && passwordEncoder.matches(password, usuario.getPassword())) {
            return usuario;
        } else {
            return null;
        }
    }

    // Implementación de los demás métodos de la clase UsuarioDAO (SolicitarTarjeta, aprobarTarjeta, RegistroCompra)
}

// Implementación de la clase TarjetaDeCreditoDAO
@Repository
public class TarjetaDeCreditoDAOImpl extends TarjetaDeCreditoDAO {

    @Autowired
    private TarjetaDeCreditoRepository tarjetaDeCreditoRepository;

    @Override
    public String asignarNumero() {
        // Implementación de la lógica para asignar un número de tarjeta
        return "1234567890123456"; // Ejemplo
    }

    @Override
    public Double calcularCupo(Double ingresos, Double gastos, Double deudas) {
        // Implementación de la lógica para calcular el cupo
        return ingresos - (gastos + deudas); // Ejemplo
    }

    // Implementación de los demás métodos de la clase TarjetaDeCreditoDAO
}