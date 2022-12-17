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
@IdClass(EventoDePartidaID.class)
public class EventoDePartida {

    @Id
    @ManyToOne
    @NonNull
    private JogadoresDaPartida jogadorHasPartida;

    @Id
    @ManyToOne
    private Evento evento;

    @Id
    @Column(name = "tempoDoEvento", nullable = false)
    private double tempoDoEvento;

}
