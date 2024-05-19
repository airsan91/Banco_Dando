package ucentral.edu.co.appBanco.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

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
    private long documento;

    @Column(name="SOL_INGRESOS", nullable = false)
    private long ingresos;

    @Column(name="SOL_GASTOS", nullable = false)
    private long gastos;

    @Column(name="SOL_DEUDAS", nullable = false)
    private long deudas;

    @Setter
    @Column(name="SOL_ESTADO", nullable = false)
    private String estado;

    @Setter
    @Getter
    @Column(name="SOL_FECHA_CREACION", nullable = false)
    private Date fechaCreacion;
}
