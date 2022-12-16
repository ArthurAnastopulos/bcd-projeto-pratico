package engtelecom.bcd.projeto_pratico.entities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EventoDePartidaID {

    private Integer evento;

    private JogadoresDaPartidaID jogadorHasPartida;
}
