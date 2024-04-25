package DAO;

public abstract class TarjetaDeCreditoDAO {
    String asignarNumero() {
        return null;
    }
    public abstract Double calcularCupo(Double ingresos, Double gastos, Double deudas);
}
