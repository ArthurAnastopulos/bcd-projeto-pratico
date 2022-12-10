package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Posicao")
public class Posicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPosicao;
    @Column(nullable = false)
    @NonNull
    private String Titulo;

    @OneToOne(mappedBy = "posicao", fetch = FetchType.LAZY, optional = false)
    public Jogador_has_Partida jogadorHasPartida;
}
