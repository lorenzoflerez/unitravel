package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Table(name = "caracteristica")
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {
    @Builder
    public Caracteristica(@NonNull String caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_caracteristica")
    private Integer idCaracteristica;

    @Column(nullable = false, length = 50, unique = true)
    @NotBlank
    @NonNull
    private String caracteristica;

    @ManyToMany
    @ToString.Exclude
    private List<Hotel> hoteles;

    @ManyToMany
    @ToString.Exclude
    private List<Habitacion> habitaciones;

}
