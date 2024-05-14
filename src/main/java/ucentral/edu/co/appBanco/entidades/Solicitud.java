package ucentral.edu.co.appBanco.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "SOLICITUDES_REL")
@ToString
public class Solicitud  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "SOL_CODIGO",nullable = false)
    private int codigo;

    @Column(name="SOL_NOMBRE", nullable = false)
    private String nombre;

    @Column(name="SOL_DOCUMENTO", nullable = false)
    private String documento;

    @Column(name="SOL_INGRESOS", nullable = false)
    private long ingresos;

    @Column(name="SOL_GASTOS", nullable = false)
    private long gastos;

    @Column(name="SOL_DEUDAS", nullable = false)
    private long deudas;
}
