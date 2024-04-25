package impl;

import DAO.TarjetaDeCreditoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class TarjetaDeCreditoDAOImpl extends TarjetaDeCreditoDAO {

    @Autowired
    private TarjetaDeCreditoRepository tarjetaDeCreditoRepository;

    @Override
    public String asignarNumero() {
        // Generar un número de tarjeta aleatorio de 16 dígitos
        String numeroTarjeta = "";
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            numeroTarjeta += random.nextInt(10);
        }
        return numeroTarjeta;
    }

    @Override
    public Double calcularCupo(Double ingresos, Double gastos, Double deudas) {
        // Calcular el cupo disponible utilizando una fórmula simple
        Double cupoDisponible = ingresos - (gastos + deudas);
        if (cupoDisponible < 0) {
            cupoDisponible = 0.0;
        }
        return cupoDisponible;
    }

}