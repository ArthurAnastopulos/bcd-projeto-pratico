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
@Table(name = "estadio")
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadio;

    @Column(name = "nome", nullable = false)
    @NonNull
    private String Nome;

    @Column(name = "local", nullable = false)
    @NonNull
    private String Local;

    @OneToMany(mappedBy = "estadio", fetch = FetchType.EAGER )
    private Set<Partida> partidas;


}
