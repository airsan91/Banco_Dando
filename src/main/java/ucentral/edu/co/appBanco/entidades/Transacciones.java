package ucentral.edu.co.appBanco.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "TRANSACCIONES_REL") // Cambio de nombre de tabla
@ToString
public class Transacciones implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "TRANSACCION_ID", nullable = false)
        private int codigoTran;

        @Column(name = "TRAN_FECHA", nullable = false)
        private Date fecha;

        @Column(name = "TRAN_DESCRIPCION", nullable = false)
        private String descripcion;

        @Column(name = "TRAN_MONTO", nullable = false)
        private double monto;

        @Column(name = "TRAN_CUOTAS", nullable = false)
        private int cuotas;


        @Column(name = "TRAN_ESTABLECIMIENTO", nullable = false)
        private String establecimiento;

    }

