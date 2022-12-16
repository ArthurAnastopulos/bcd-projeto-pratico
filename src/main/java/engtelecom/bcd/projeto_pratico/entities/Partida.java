package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPartida;

    @Column(nullable = false)
    @NonNull
    private Date data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstadio", nullable = false)
    @NonNull
    private Estadio estadio;

    @ManyToOne
    @JoinColumn(name = "idSelecao1", nullable = false)
    @NonNull
    private Selecao selecao1;

    @ManyToOne
    @JoinColumn(name = "idSelecao2", nullable = false)
    @NonNull
    private Selecao selecao2;

    @OneToMany(mappedBy = "partida", fetch = FetchType.EAGER)
    public Set<PartidasDaEdicao> setPartida = new HashSet<>();

    @OneToMany(mappedBy = "partida", fetch = FetchType.EAGER)
    public Set<JogadoresDaPartida> setPartida2 = new HashSet<>();
}
