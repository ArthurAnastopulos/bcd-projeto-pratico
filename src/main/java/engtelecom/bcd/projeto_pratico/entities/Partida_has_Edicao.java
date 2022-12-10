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
@IdClass(Partida_has_Edicao_Id.class)
public class Partida_has_Edicao {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private Partida partida;

    @Id
    @ManyToOne(fetch =  FetchType.EAGER)
    private Edicao edicao;

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    private Fase fase;
}
