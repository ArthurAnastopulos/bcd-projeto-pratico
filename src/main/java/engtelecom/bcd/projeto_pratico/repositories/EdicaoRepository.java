package engtelecom.bcd.projeto_pratico.repositories;

import engtelecom.bcd.projeto_pratico.entities.Edicao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EdicaoRepository extends CrudRepository<Edicao, Integer>{

    Optional<Edicao> findByAno(Integer ano);
}
