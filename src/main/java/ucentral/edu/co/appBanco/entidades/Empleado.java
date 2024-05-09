package ucentral.edu.co.appBanco.entidades;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID_EMPLEADO", nullable = false)
    private int id;

    @Column(name = "EMP_USUARIO", nullable = false)
    private String usuarioEmpleado;

    @Column(name = "EMP_CONTRASENA", nullable = false)
    private String contrasena;
}
