package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Table(name = "sitio_de_interes")
@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lugar implements Serializable {

    @Builder
    public Lugar(@NonNull String nombre, @NonNull Double tarifa, Ciudad ciudad) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.ciudad = ciudad;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idLugar;

    @Column(nullable = false, length = 50)
    @NotBlank
    @NonNull
    private String nombre;

    @Positive
    @NonNull
    private Double tarifa;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    @ManyToMany
    @ToString.Exclude
    private List<PaqueteTuristico> paquetes;
}
