package ucentral.edu.co.appBanco.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Tarjeta_De_Credito")
public class Tarjeta_De_Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TAR_ID_NUMEROTARJETA", nullable = false)
    private String numeroTarjeta;

    @Column(name = "TAR_CUPO", nullable = false)
    private float cupo;

    @Column(name = "TAR_SALDO", nullable = false)
    private float saldo;

    @Column(name = "TAR_FECHAEXP", nullable = false)
    private LocalDate fechaExp;

    @Column(name = "TAR_BLOQUEADA", nullable = false)
    private boolean bloqueada;
}
