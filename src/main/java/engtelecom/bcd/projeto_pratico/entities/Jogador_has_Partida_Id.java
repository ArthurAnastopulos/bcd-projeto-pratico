package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Jogador_has_Partida_Id {

    private Integer jogador;

    private Integer partida;

    private Integer posicao;
}
