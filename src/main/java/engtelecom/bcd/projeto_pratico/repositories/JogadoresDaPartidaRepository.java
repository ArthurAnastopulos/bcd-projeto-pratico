package engtelecom.bcd.projeto_pratico.repositories;

import engtelecom.bcd.projeto_pratico.entities.Jogador;
import engtelecom.bcd.projeto_pratico.entities.JogadoresDaPartida;
import engtelecom.bcd.projeto_pratico.entities.Partida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JogadoresDaPartidaRepository extends CrudRepository<JogadoresDaPartida, Integer> {

    Optional<JogadoresDaPartida> findByJogadorAndPartida(Jogador jogador, Partida partida);
}
