package ucentral.edu.co.appBanco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioDto implements Serializable {
    private long serial;
    private String nombreUsuario;
    private String contrasena;
}
