package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@ToString
@IdClass(Jogador_has_Partida_Id.class)
public class Jogador_has_Partida {


    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private Jogador jogador;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private Partida partida;

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    private Posicao posicao;

}
