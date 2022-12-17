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
@IdClass(ClassificaoDasSelecoesID.class)
public class ClassificaoDasSelecoes {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private Classificao classificao;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private Selecao selecao;

    @Id
    @ManyToOne
    private Fase fase;
}
