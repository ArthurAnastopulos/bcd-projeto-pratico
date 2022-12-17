package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Classificao")
public class Classificao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClassificao;

    @Column(name= "classificao", nullable = false)
    @NonNull
    private Double classificao;

    @OneToMany(mappedBy = "classificao", fetch = FetchType.EAGER)
    public Set<ClassificaoDasSelecoes> classificaoDasSelecoesSet = new HashSet<>();
}
