package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"jogadorHasPartida"})
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

    @OneToMany(mappedBy = "posicao", fetch = FetchType.EAGER)
    public Set<JogadoresDaPartida> jogadorHasPartida;
}
