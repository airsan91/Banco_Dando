package ucentral.edu.co.appBanco.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Usuario")
@Table(name = "USUARIOS_REL") // Cambio de nombre de tabla
@ToString
@Builder
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USU_ID_USUARIO", nullable = false)
    private int codigo;

    @Column(name = "USU_NOMBRE", nullable = false)
    private String nombreUsuario;

    @Column(name = "USU_CORREO", nullable = false)
    private String correoUsuario;

    @Column(name = "USU_TELEFONO", nullable = false)
    private long telefonoUsuario;

    @Column(name = "USU_CONTRASENA", nullable = false)
    private String contrasena;
}

