package engtelecom.bcd.projeto_pratico.repositories;

import engtelecom.bcd.projeto_pratico.entities.Selecao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SelecaoRepository extends CrudRepository<Selecao, Integer> {

}
