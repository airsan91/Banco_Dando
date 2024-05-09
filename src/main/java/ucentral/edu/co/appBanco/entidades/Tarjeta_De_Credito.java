package ucentral.edu.co.appBanco.entidades;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Tarjeta_De_Credito")
public class Tarjeta_De_Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TAR_ID_TARJETA_DE_CREDITO", nullable = false)
    private int String;

    @Column(name = "TAR_CUPO", nullable = false)
    private float cupo;

    @Column(name = "TAR_SALDO", nullable = false)
    private float saldo;
}
