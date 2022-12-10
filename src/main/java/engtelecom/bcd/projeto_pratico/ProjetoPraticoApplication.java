package engtelecom.bcd.projeto_pratico;

import engtelecom.bcd.projeto_pratico.entities.Edicao;
import engtelecom.bcd.projeto_pratico.entities.Jogador;
import engtelecom.bcd.projeto_pratico.entities.Selecao;
import engtelecom.bcd.projeto_pratico.entities.Tecnico;
import engtelecom.bcd.projeto_pratico.repositories.EdicaoRepository;
import engtelecom.bcd.projeto_pratico.repositories.JogadorRepository;
import engtelecom.bcd.projeto_pratico.repositories.SelecaoRepository;
import engtelecom.bcd.projeto_pratico.repositories.TecnicoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ProjetoPraticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPraticoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(JogadorRepository jogadorRepository,
									TecnicoRepository tecnicoRepository,
									SelecaoRepository selecaoRepository,
									EdicaoRepository edicaoRepository)
	{
		return (args) -> {
			System.out.println("Iniciando a Aplicação");

			Date sqlDate1 = new Date(1987, 6, 24);
			Jogador jogador = new Jogador("Lionel", "Messi", sqlDate1, "Argentina");

			//jogadorRepository.save(jogador);

			Set<Jogador> jogadores = new HashSet<Jogador>();
			jogadores.add(jogador);


			Date sqlDate2 = new Date(1995, 5, 16);
			Tecnico tecnico = new Tecnico("Lionel", "Scaloni", sqlDate2, "Argentina");

			//tecnicoRepository.save(tecnico);

			Set<Tecnico> tecnicos = new HashSet<Tecnico> ();
			tecnicos.add(tecnico);

			Edicao edicao = new Edicao("Catar", 2022);

			//edicaoRepository.save(edicao);

			Selecao selecaoArgentina = new Selecao("Argentina", edicao, jogadores, tecnicos);

			//selecaoRepository.save(selecaoArgentina);

			System.out.println("----- Teste Tabela -----");
			System.out.println("Jogadores");
			jogadorRepository.findAll().forEach(System.out::println);

			System.out.println("Tecnicos");
			tecnicoRepository.findAll().forEach(System.out::println);

			System.out.println("Edicoes");
			edicaoRepository.findAll().forEach(System.out::println);

			System.out.println("Selecoes");
			selecaoRepository.findAll().forEach(System.out::println);
		};
	}
}
