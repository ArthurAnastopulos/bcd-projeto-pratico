package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"selecoes"})
@EqualsAndHashCode(exclude = {"selecoes"})
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJogador;

    @Column(nullable = false)
    @NonNull
    private String Nome;

    @Column(nullable = false)
    @NonNull
    private String Sobrenome;

    @Column(nullable = false)
    @NonNull
    private Date dataNasc;

    @Column(nullable = false)
    @NonNull
    private String Nacionalidade;

    @ManyToMany(mappedBy = "jogadores")
    private Set<Selecao> selecoes = new HashSet<>();

    @OneToMany(mappedBy = "jogador", fetch = FetchType.EAGER)
    public Set<Jogador_has_Partida> setJogador = new HashSet<>();

}
