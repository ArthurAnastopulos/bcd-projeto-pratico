package engtelecom.bcd.projeto_pratico.entities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PartidasDaEdicaoID {
    private Integer partida;
    private Integer edicao;
    private Integer fase;
}
