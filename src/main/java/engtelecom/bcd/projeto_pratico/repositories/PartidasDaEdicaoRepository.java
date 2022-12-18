package engtelecom.bcd.projeto_pratico.repositories;

import engtelecom.bcd.projeto_pratico.entities.Edicao;
import engtelecom.bcd.projeto_pratico.entities.PartidasDaEdicao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PartidasDaEdicaoRepository extends CrudRepository<PartidasDaEdicao, Integer> {

    Optional<Iterable<PartidasDaEdicao>> findByEdicao(Edicao edicao);
}
