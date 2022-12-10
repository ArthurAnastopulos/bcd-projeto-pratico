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
@Table(name = "Classificao")
public class Classificao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClassificao;

    @Column
    @NonNull
    private Double classificao;

    @OneToMany(mappedBy = "classificao")
    private Set<Selecao> selecoes;
}
