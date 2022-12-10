package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    @Column
    @NonNull
    private String descricao;

}
