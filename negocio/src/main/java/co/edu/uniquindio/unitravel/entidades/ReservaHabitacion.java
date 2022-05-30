package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Table(name = "reserva_habitacion")
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaHabitacion implements Serializable {

    @Builder
    public ReservaHabitacion(@NonNull Double subTotal, Reserva reserva, Habitacion habitacion) {
        this.subTotal = subTotal;
        this.reserva = reserva;
        this.habitacion = habitacion;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_reserva_habitacion")
    private Integer idReservaHabitacion;

    @Positive
    @NonNull
    private Double subTotal;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;
}
