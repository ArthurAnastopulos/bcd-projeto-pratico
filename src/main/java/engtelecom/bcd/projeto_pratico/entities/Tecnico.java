package engtelecom.bcd.projeto_pratico.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"selecoes"})
@EqualsAndHashCode(exclude = {"selecoes"})
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTecnico;

    @Column(nullable = false)
    @NonNull
    private String Nome;

    @Column(nullable = false)
    @NonNull
    private String Sobrenome;

    @Column(nullable = false)
    @NonNull
    private Date dataNasc;

    @Column(nullable = false)
    @NonNull
    private String Nacionalidade;

    @ManyToMany(mappedBy = "tecnicos", fetch = FetchType.EAGER)
    private Set<Selecao> selecoes = new HashSet<>();


}
