package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Estadio")
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadio;

    @Column(nullable = false)
    @NonNull
    private String Nome;

    @Column(nullable = false)
    @NonNull
    private String Local;

    @OneToMany(mappedBy = "estadio", fetch = FetchType.LAZY )
    private Set<Partida> partidas;


}
