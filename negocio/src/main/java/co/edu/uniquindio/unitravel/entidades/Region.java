package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Table(name = "region")
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Region implements Serializable {

    @Builder
    public Region(@NonNull String region) {
        this.region = region;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_region")
    private Integer idRegion;

    @Column(nullable = false, length = 50, unique = true)
    @NotBlank
    @NonNull
    private String region;

    @OneToMany(mappedBy = "ciudad")
    @ToString.Exclude
    private List<Ciudad> ciudades;

}
