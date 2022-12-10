package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"jogadores", "tecnicos", "partidasSelecao1", "partidasSelecao2"})
@EqualsAndHashCode(exclude = {"jogadores", "tecnicos", "partidasSelecao1", "partidasSelecao2"})
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Selecao")
public class Selecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSelecao;

    @Column(nullable = false)
    @NonNull
    private String Pais;

    @ManyToOne
    @JoinColumn(name = "idEdicao", nullable = false)
    @NonNull
    private Edicao edicao;

    @ManyToMany
    @JoinTable(name = "Jogador_has_Selecao",
            joinColumns = {
                    @JoinColumn(name="idSelecao",
                            referencedColumnName = "idSelecao",
                            nullable = false, updatable = false),
            },
            inverseJoinColumns = {
                    @JoinColumn(name="idJogador",
                            referencedColumnName = "idJogador",
                            nullable = false, updatable = false)
            })
    @NonNull
    private Set<Jogador> jogadores;

    @ManyToMany
    @JoinTable(name = "Tecnico_has_Selecao",
            joinColumns = {
                    @JoinColumn(name="idSelecao",
                            referencedColumnName = "idSelecao",
                            nullable = false, updatable = false),
            },
            inverseJoinColumns = {
                    @JoinColumn(name="idTecnico",
                            referencedColumnName = "idTecnico",
                            nullable = false, updatable = false)
            })
    @NonNull
    private Set<Tecnico> tecnicos;

    @OneToMany(mappedBy = "selecao1")
    private Set<Partida> partidasSelecao1;

    @OneToMany(mappedBy = "selecao1")
    private Set<Partida> partidasSelecao2;

    @ManyToOne
    @JoinColumn(name = "idClassificao")
    private Classificao classificao;

}
