package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Table(name = "reserva_silla")
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaSilla implements Serializable {

    @Builder
    public ReservaSilla(@NonNull Double subTotal, Reserva reserva, Silla silla) {
        this.subTotal = subTotal;
        this.reserva = reserva;
        this.silla = silla;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_reserva_silla")
    private Integer idReservaSilla;

    @Positive
    @NonNull
    private Double subTotal;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "silla_id")
    private Silla silla;
}
