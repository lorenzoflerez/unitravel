package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Table(name = "ciudad")
@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @Builder
    public Ciudad(@NonNull String ciudad) {
        this.ciudad = ciudad;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCiudad;

    @Column(nullable = false, length = 50)
    @NotBlank
    @NonNull
    private String ciudad;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "origen")
    @ToString.Exclude
    private List<Vuelo> origenes;

    @OneToMany(mappedBy = "destino")
    @ToString.Exclude
    private List<Vuelo> destinos;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Lugar> lugares;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
