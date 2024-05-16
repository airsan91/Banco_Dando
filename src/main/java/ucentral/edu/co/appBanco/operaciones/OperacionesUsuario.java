package ucentral.edu.co.appBanco.operaciones;



import ucentral.edu.co.appBanco.entidades.Usuario;

public interface OperacionesUsuario {
   public Usuario crear(Usuario usuario);
   public Usuario findByNombreUsuario(String nombreUsuario);
}
