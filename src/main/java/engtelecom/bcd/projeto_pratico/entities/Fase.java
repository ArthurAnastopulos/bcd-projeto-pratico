package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude ={"partidaHasEdicao"})
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Fase")
public class Fase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFase;

    @Column(nullable = false)
    @NonNull
    private String Descricao;

    @OneToOne(mappedBy = "fase", fetch = FetchType.EAGER, optional = false)
    public PartidasDaEdicao partidaHasEdicao;

    @OneToMany(mappedBy = "fase", fetch = FetchType.EAGER)
    public Set<ClassificaoDasSelecoes> classificaoDasSelecoesSet = new HashSet<>();
}
