package ucentral.edu.co.appBanco.operaciones;



import ucentral.edu.co.appBanco.entidades.Transacciones;

import java.util.List;

public interface OperacionesTransacciones {
    public Transacciones crear(Transacciones transacciones);
    public Transacciones actualizar(Transacciones transacciones);
    public void borrar(Transacciones transacciones);
    public List<Transacciones> consultarT();
    public Transacciones consultarPk(int pk);
}
