package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@ToString
@IdClass(JogadoresDaPartidaID.class)
public class JogadoresDaPartida {


    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private Jogador jogador;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private Partida partida;

    @ManyToOne(fetch = FetchType.EAGER)
    private Posicao posicao;

}
