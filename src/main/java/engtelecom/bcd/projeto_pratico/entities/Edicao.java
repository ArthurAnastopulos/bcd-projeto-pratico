package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"selecoes", "setEdicao"})
@EqualsAndHashCode(exclude = {"selecoes", "setEdicao"})
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Edicao")
public class Edicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEdicao;

    @Column(name = "pais", nullable = false)
    @NonNull
    private String Pais;

    @Column(name = "ano", nullable = false)
    @NonNull
    private Integer Ano;

    @OneToMany(mappedBy = "edicao")
    private Set<Selecao> selecoes;

    @OneToMany(mappedBy = "edicao", fetch = FetchType.EAGER)
    private Set<PartidasDaEdicao> setEdicao = new HashSet<>();


}
