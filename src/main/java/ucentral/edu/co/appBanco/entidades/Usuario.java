package ucentral.edu.co.appBanco.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Usuario")
@Table(name = "USUARIOS_REL") // Cambio de nombre de tabla
@ToString
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO_REL")
    @SequenceGenerator(name = "SEQ_USUARIO_REL", sequenceName = "SEQ_USUARIO_REL", allocationSize = 1)
    @Column(name = "USU_ID_USUARIO", nullable = false)
    private long serial;

    @Column(name = "USU_NOMBRE", nullable = false)
    private String nombreUsuario;

    @Column(name = "USU_CONTRASENA", nullable = false)
    private String contrasena;
}
