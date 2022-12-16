package engtelecom.bcd.projeto_pratico;

import engtelecom.bcd.projeto_pratico.entities.*;
import engtelecom.bcd.projeto_pratico.repositories.*;
import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.*;

@SpringBootApplication
public class ProjetoPraticoApplication {
	private final EventoRepository eventoRepository;

	public ProjetoPraticoApplication(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPraticoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(JogadorRepository jogadorRepository,
									TecnicoRepository tecnicoRepository,
									SelecaoRepository selecaoRepository,
									EdicaoRepository edicaoRepository,
									FaseRepository faseRepository,
									PosicaoRepository posicaoRepository,
									PartidaRepository partidaRepository,
									EstadioRepository estadioRepository,
									ClassificaoRepository classificaoRepository,
									EventoDePartidaRepository eventoDePartidaRepository,
									JogadoresDaPartidaRepository jogadoresDaPartidaRepository,
									PartidasDaEdicaoRepository partidasDaEdicaoRepository)
	{
		return (args) -> {
			System.out.println("---- Iniciando a Aplicação ----");
			Scanner scanner = new Scanner(System.in);

			boolean isRunning = true;
			while (isRunning)
			{
				System.out.println("Digite a letra relcionado a Operação que deseja fazer, ou qual quer outra tecla para sair:");
				System.out.println("""
					C - Para Inserção\s
					R - Para Seleção\s
					U - Para Atualizar\s
					D - Para Deletar""");

				String opcao = scanner.nextLine();

				switch (opcao.toLowerCase())
				{
					case "c":
						System.out.println("Opção de Inserção Selecionada");
						insertMenu(jogadorRepository,
								tecnicoRepository,
								selecaoRepository,
								edicaoRepository,
								faseRepository,
								posicaoRepository,
								partidaRepository,
								estadioRepository,
								classificaoRepository,
								eventoDePartidaRepository,
								jogadoresDaPartidaRepository,
								partidasDaEdicaoRepository);
						break;
					case "r":
						System.out.println("Opção de Seleção Selecionada");
						selectMenu(jogadorRepository,
								tecnicoRepository,
								selecaoRepository,
								edicaoRepository,
								faseRepository,
								posicaoRepository,
								partidaRepository,
								estadioRepository,
								classificaoRepository,
								eventoDePartidaRepository,
								jogadoresDaPartidaRepository,
								partidasDaEdicaoRepository);
						break;
					case "u":
						System.out.println("Opção de Atualização Selecionada");
						updateMenu(jogadorRepository,
								tecnicoRepository,
								selecaoRepository,
								edicaoRepository,
								faseRepository,
								posicaoRepository,
								partidaRepository,
								estadioRepository,
								classificaoRepository,
								eventoDePartidaRepository,
								jogadoresDaPartidaRepository,
								partidasDaEdicaoRepository);
						break;
					case "d":
						System.out.println("Opção para Deletar Selecionada");
						break;
					default:
						isRunning = false;
						System.out.println("---- Encerrando Aplicação ----");
						break;

				}
			}
		};
	}

	public void insertMenu(JogadorRepository jogadorRepository,
						   TecnicoRepository tecnicoRepository,
						   SelecaoRepository selecaoRepository,
						   EdicaoRepository edicaoRepository,
						   FaseRepository faseRepository,
						   PosicaoRepository posicaoRepository,
						   PartidaRepository partidaRepository,
						   EstadioRepository estadioRepository,
						   ClassificaoRepository classificaoRepository,
						   EventoDePartidaRepository eventoDePartidaRepository,
						   JogadoresDaPartidaRepository jogadoresDaPartidaRepository,
						   PartidasDaEdicaoRepository partidasDaEdicaoRepository)
	{
		boolean isRunning = true;
		Scanner scanner = new Scanner(System.in);
		while (isRunning)
		{
			System.out.println("Digite o número da lista abaixo, para fazer a Operação selecionada:");
			System.out.println("""
				1 - Adicionar informações (Evento) de uma partida (em andamento)\s
				2 - Adicionar uma partida\s
				3 - Adicionar um Jogador\s
				4 - Adicionar um Tecnico\s
				5 - Adicionar uma selecao\s
				6 - Adicionar uma edição\s
				7 - Adicionar um Estadio\s
				8 - Adicionar uma Classificação a uma Seleção\s
				9 - Adicionar um Jogador a uma partida
				10 - Adicionar um Jogador a uma seleção
				11 - Adicionar um Tecnico a uma seleção\s
				12 - Adicionar uma posição de Futebol\s
				13 - Adicionar uma Classificação \s
				14 - Adicionar um tipo de Evento\s
				15 - Adicionar uma Fase\s
				16 - Adicionar uma Edição a uma Partida""");
			String opcao = scanner.nextLine();
			switch (opcao)
			{
				case "1":
					System.out.println("Adicionando Eventos em uma partida selecionado. Informe qual é a partida com suas informações: \n");
					System.out.print("Digite o número indentificador da Partida: ");
					String partidaStr = scanner.nextLine();

					Optional<Partida> partida = partidaRepository.findById(Integer.parseInt(partidaStr));
					if(partida.isEmpty()){
						System.out.println("Partida não encontrada");
						break;
					}

					System.out.print("Digite o número identificador do Jogador relacionado com o Evento: ");
					String jogadorStr = scanner.nextLine();

					Optional<Jogador> jogador = jogadorRepository.findById(Integer.parseInt(jogadorStr));
					if (jogador.isEmpty()){
						System.out.println("Jogador não encontrado");
						break;
					}

					Optional<JogadoresDaPartida> jogadoresDaPartida = jogadoresDaPartidaRepository.findByJogadorAndPartida(jogador.get(), partida.get());
					if(jogadoresDaPartida.isEmpty()){
						System.out.println("Este jogador não participou da partida");
						break;
					}

					System.out.print("Digite o numero identificador do Evento ocorrido: ");
					String eventoStr = scanner.nextLine();

					Optional<Evento> evento = eventoRepository.findById(Integer.parseInt(eventoStr));
					if (evento.isEmpty()){
						System.out.println("O Sistema não possui este evento");
						break;
					}

					System.out.print("Digite o minuto em que ocorreu o Evento (Valor do Tipo Double): ");
					String tempoDeJogo = scanner.nextLine();

					EventoDePartida eventoDePartida = new EventoDePartida(jogadoresDaPartida.get(), evento.get(), Double.parseDouble(tempoDeJogo));
					eventoDePartidaRepository.save(eventoDePartida);
					System.out.println("Evento registrado com sucesso.");
					break;
				case "2":
					System.out.println("Adicionando uma partida selecionado. Informe os dados da partida: \n");
					System.out.print("Qual é data que ocorreu/vai ocorrer a partida (Formato: **Ano-Mes-Dia** ): ");
					String _dateStr = scanner.nextLine();
					System.out.println("Qual é o número identificador do estadio em vai ocorrer a partida: ");
					String estadioID = scanner.nextLine();
					Optional<Estadio> estadio = estadioRepository.findById(Integer.parseInt(estadioID));
					if(estadio.isEmpty()) {
						System.out.println("Estadio não encontrado no Database");
						break;
					}
					System.out.print("Qual é o numero identificador da primeira Seleção a jogar na Partida: ");
					String selecao1_ = scanner.nextLine();
					Optional<Selecao> selecaoCasa = selecaoRepository.findById(Integer.parseInt(selecao1_));
					if(selecaoCasa.isEmpty()){
						System.out.println("Selecao não encontrada");
						break;
					}
					System.out.print("Qual é o numero identificador da segunda Seleção a jogar na Partida: ");
					String selecao2_ = scanner.nextLine();
					Optional<Selecao> selecaoConvidada = selecaoRepository.findById(Integer.parseInt(selecao1_));
					if(selecaoConvidada.isEmpty()){
						System.out.println("Selecao não encontrada");
						break;
					}
					if(!Objects.equals(selecaoCasa.get().getEdicao().getIdEdicao(), selecaoConvidada.get().getEdicao().getIdEdicao()))
					{
						System.out.println("As Seleções não são da mesma edição.");
						break;
					}
					Date date_ = Date.valueOf(_dateStr);
					Partida novaPartida = new Partida(date_, estadio.get(), selecaoCasa.get(), selecaoConvidada.get());
					partidaRepository.save(novaPartida);
					System.out.println("Partida adicionada com Sucesso.");
					break;
				case "3":
					System.out.println("Adicionando um jogador selecionado. Informe os dados do jogador: \n");
					System.out.print("Informe o Nome do Jogador: ");
					String nameJogador = scanner.nextLine();
					System.out.print("Informe o Sobrenome do Jogador: ");
					String lastNameJogador = scanner.nextLine();
					System.out.print("Qual é data em que ele nasceu  (Formato: **Ano-Mes-Dia** ): ");
					String dateNascJogador = scanner.nextLine();
					Date dateNascJogador_ = Date.valueOf(dateNascJogador);
					System.out.print("Informe a Nacionalidade do Jogador: ");
					String nacionalidadeJogador = scanner.nextLine();
					Jogador novoJogador = new Jogador(nameJogador, lastNameJogador, dateNascJogador_, nacionalidadeJogador);
					jogadorRepository.save(novoJogador);
					System.out.println("Jogador salvo com sucesso.");
					break;
				case "4":
					System.out.println("Adicionando um tecnico selecionado. Informe os dados do Tecnico: \n");
					System.out.print("Informe o Nome do Tecnico: ");
					String nameTecnico = scanner.nextLine();
					System.out.print("Informe o Sobrenome do Tecnico: ");
					String lastNameTecnico = scanner.nextLine();
					System.out.print("Qual é data em que ele nasceu  (Formato: **Ano-Mes-Dia** ): ");
					String dateNascTecnico = scanner.nextLine();
					Date dateNascTecnico_ = Date.valueOf(dateNascTecnico);
					System.out.print("Informe a Nacionalidade do Tecnico: ");
					String nacionalidadeTecnico = scanner.nextLine();
					Tecnico novoTecnico = new Tecnico(nameTecnico, lastNameTecnico, dateNascTecnico_, nacionalidadeTecnico);
					tecnicoRepository.save(novoTecnico);
					System.out.println("Tecnico salvo com sucesso.");
					break;
				case "5":
					System.out.println("Adicionando uma Seleção selecionado. Informe os dados da Seleção: \n");
					System.out.print("Informe o Pais da Seleção: ");
					String paisSelecao = scanner.nextLine();
					System.out.print("Informe o numero Identificador Edição da Copa que este país vai participar: ");
					String EdicaoID = scanner.nextLine();
					Optional<Edicao> edicao_ = edicaoRepository.findById(Integer.parseInt(EdicaoID));
					if(edicao_.isEmpty()){
						System.out.println("Edição de Copa não encontrada");
						break;
					}
					Selecao novaSelecao = new Selecao(paisSelecao, edicao_.get());
					selecaoRepository.save(novaSelecao);
					System.out.println("Selecao salva com sucesso.");
					break;
				case "6":
					System.out.println("Adicionando uma Edição selecionado. Informe os dados da edição: \n");
					System.out.print("Informe o Ano em que ocorre/ocorreu/ocorrerá a Edição de Copa: ");
					String anoEdicao = scanner.nextLine();
					System.out.print("Informe o país em que ocorre/ocorreu/ocorrerá a Edição de Copa: ");
					String paisEdicao = scanner.nextLine();
					Edicao edicao = new Edicao(paisEdicao, Integer.parseInt(anoEdicao));
					edicaoRepository.save(edicao);
					System.out.println("Edição salva com sucesso.");
					break;
				case "7":
					System.out.println("Adicionando um Estadio selecionado. Informe os dados do Estadio: \n");
					System.out.print("Informe o local do Estadio: ");
					String localEstadio = scanner.nextLine();
					System.out.print("Informe o nome do Estadio: ");
					String nomeEstadio = scanner.nextLine();
					Estadio estadio__ = new Estadio(nomeEstadio, localEstadio);
					estadioRepository.save(estadio__);
					System.out.println("Estadio salvo com Sucesso.");
					break;
				case "8":
					System.out.println("Adicionando uma Classifição a uma Seleção: \n");
					System.out.print("Informe o numero Identificador da Seleção a ser classificada: ");
					String idSelecaoClassf = scanner.nextLine();
					Optional<Selecao> sClassf = selecaoRepository.findById(Integer.parseInt(idSelecaoClassf));
					if(sClassf.isEmpty()) {
						System.out.println("Não foi encontrado esta seleção");
						break;
					}
					System.out.print("Informe o numero identificador da posição a ser atribuida a seleção: ");
					String  idClassf = scanner.nextLine();
					Optional<Classificao> classf = classificaoRepository.findById(Integer.parseInt(idClassf));
					if (classf.isEmpty())
					{
						System.out.println("Não foi encontrado esta classifcaoção");
						break;
					}
					sClassf.get().setClassificao(classf.get());
					selecaoRepository.save(sClassf.get());
					System.out.println("Classifcao salva com Sucesso.");
					break;
				case "9":
					System.out.println("Adicionando um Jogador em uma partida selecionado. Informe qual é o Jogador com suas informações: \n");
					System.out.print("Informe o numero indentificador do Jogador desejado: ");
					String jogadorInformado = scanner.nextLine();

					Optional <Jogador> findJogador = jogadorRepository.findById(Integer.parseInt(jogadorInformado));
					if(findJogador.isEmpty())
					{
						System.out.println("Jogador não Econtrado");
						break;
					}

					System.out.print("Informe o número identificador da posição em que o Jogador está na partida: ");
					String posicaoPartida = scanner.nextLine();

					Optional<Posicao>  findPosicao = posicaoRepository.findById(Integer.parseInt(posicaoPartida));
					if(findPosicao.isEmpty()){
						System.out.println("Posição não Encontrada");
						break;
					}

					System.out.print("Informe o número identificador Partida em que o Jogador está jogando: ");
					String partidaInfromada = scanner.nextLine();

					Optional <Partida>  findPartida = partidaRepository.findById(Integer.parseInt(partidaInfromada));
					if(findPartida.isEmpty()){
						System.out.println("Partida não encontrada");
						break;
					}

					JogadoresDaPartida jogadoresDaPartida_ = new JogadoresDaPartida(findJogador.get(), findPartida.get(), findPosicao.get());
					jogadoresDaPartidaRepository.save(jogadoresDaPartida_);
					System.out.println("Jogador adicionada a Partida com Sucesso.");
					break;
				case "10":
					System.out.println("Adicionando um Jogador em uma seleção selecionado. Informe qual é o Jogador com suas informações: \n");
					System.out.print("Informe o numero indentificador do Jogador desejado: ");
					String jogadorSelc = scanner.nextLine();

					Optional<Jogador> findJogador_ = jogadorRepository.findById(Integer.parseInt(jogadorSelc));
					if(findJogador_.isEmpty()){
						System.out.println("Jogador não encontrado");
						break;
					}

					System.out.print("Informe o numero indentificador da Seleção do Jogador: ");
					String selcJogador = scanner.nextLine();

					Optional<Selecao> findSelecao_ = selecaoRepository.findById(Integer.parseInt(selcJogador));
					if(findSelecao_.isEmpty()) {
						System.out.println("Selecao não encontrada");
						break;
					}


					findSelecao_.get().adicionarJogador(findJogador_.get());
					selecaoRepository.save(findSelecao_.get());

					System.out.println("Adicionado um Jogador a uma seleção com sucesso");
					break;
				case "11":
					System.out.println("Adicionando um Jogador em uma seleção selecionado. Informe qual é o Jogador com suas informações: \n");
					System.out.print("Informe o numero indentificador do Jogador desejado: ");
					String tecnicoSelc = scanner.nextLine();

					Optional<Tecnico> findTecnico_ = tecnicoRepository.findById(Integer.parseInt(tecnicoSelc));
					if(findTecnico_.isEmpty()){
						System.out.println("Tecnico não Encontrado");
					}

					System.out.print("Informe o numero indentificador da Seleção do Tecnico: ");
					String selcTecnico = scanner.nextLine();

					Optional<Selecao> _findSelecao = selecaoRepository.findById(Integer.parseInt(selcTecnico));
					if(_findSelecao.isEmpty()) {
						System.out.println("Selecao não encontrada");
						break;
					}

					_findSelecao.get().adicionarTecnico(findTecnico_.get());
					selecaoRepository.save(_findSelecao.get());

					System.out.println("Adicionado um Tecnico a uma seleção com sucesso");
					break;
				case "12":
					System.out.println("Adicionando uma posição de Futebol. Informe quais são suas informações: \n");
					System.out.print("Informe o titulo da posição: ");
					String tituloPos = scanner.nextLine();

					Posicao posicao = new Posicao(tituloPos);
					posicaoRepository.save(posicao);
					System.out.println("Sucesso");
					break;
				case "13":
					System.out.println("Adicionando uma Classifação (01, 02, 03, ... Lugar). Informe quais são suas informações: \n");
					System.out.print("Informe qual a classificação: ");
					String classSel = scanner.nextLine();

					Classificao classificao = new Classificao(Double.parseDouble(classSel));
					classificaoRepository.save(classificao);
					System.out.println("Sucesso");
					break;
				case "14":
					System.out.println("Adicionando uma Evento de Futebol (Gol, Cartao Amarelo, Cartao Vermelho, etc). Informe quais são suas informações: \n");
					System.out.print("Informe a descrição do Evento: ");
					String tituloEvent = scanner.nextLine();

					Evento evento_ = new Evento(tituloEvent);
					eventoRepository.save(evento_);
					System.out.println("Sucesso");
					break;
				case "15":
					System.out.println("Adicionando uma Fase da Copa Mundial. Informe quais são suas informações: \n");
					System.out.print("Informe a descrição da Fase: ");
					String faseStr = scanner.nextLine();

					Fase fase = new Fase(faseStr);
					faseRepository.save(fase);
					System.out.println("Sucesso");
					break;
				case "16":
					System.out.println("Adicionando uma edição a uma Partida. Informe quais são suas informações: \n");
					System.out.print("Informe o numero indentificador da Partida: ");
					String partidaStr_ = scanner.nextLine();
					Optional<Partida> optionalPartida = partidaRepository.findById(Integer.parseInt(partidaStr_));
					if (optionalPartida.isEmpty()){
						System.out.println("Partida não encontrada");
						break;
					}
					System.out.print("Informe o numero indentificador da Edição: ");
					String edicaoStr_ = scanner.nextLine();
					Optional<Edicao> edicaoOptional = edicaoRepository.findById(Integer.parseInt(edicaoStr_));
					if(edicaoOptional.isEmpty()){
						System.out.println("Edição não encontrada");
						break;
					}
					System.out.print("Informe o numero identificador da Fase que pertence esta partida: ");
					String faseStr_ = scanner.nextLine();
					Optional<Fase> faseOptional = faseRepository.findById(Integer.parseInt(faseStr_));
					if (faseOptional.isEmpty()){
						System.out.println("Fase não existe no sistema");
						break;
					}

					PartidasDaEdicao partidasDaEdicao = new PartidasDaEdicao(optionalPartida.get(), edicaoOptional.get(), faseOptional.get());
					partidasDaEdicaoRepository.save(partidasDaEdicao);
					System.out.println("Sucesso");
					break;
				default:
					isRunning = false;
					System.out.println("---- Saindo do Menu de Inserções ----");
					break;
			}
		}
	}

	public void selectMenu(JogadorRepository jogadorRepository,
						   TecnicoRepository tecnicoRepository,
						   SelecaoRepository selecaoRepository,
						   EdicaoRepository edicaoRepository,
						   FaseRepository faseRepository,
						   PosicaoRepository posicaoRepository,
						   PartidaRepository partidaRepository,
						   EstadioRepository estadioRepository,
						   ClassificaoRepository classificaoRepository,
						   EventoDePartidaRepository eventoDePartidaRepository,
						   JogadoresDaPartidaRepository jogadoresDaPartidaRepository,
						   PartidasDaEdicaoRepository partidasDaEdicaoRepository)
	{
		boolean isRunning = true;
		Scanner scanner = new Scanner(System.in);
		while (isRunning)
		{
			System.out.println("Digite o número da lista abaixo, para fazer a Operação selecionada:");
			System.out.println("""
				1 - Quais os jogadores e técnicos de cada seleção\s
				2 - Quais jogadores participaram de quais partidas\s
				3 -  Informações sobre um Determinado Jogador (Data de Nascimento, Nacionalidade)\s
				4 - Qual a posição de um Jogador em uma determinada partida\s
				5 - Qual goleiro foi menos vazado (não levou gol) em cada edição\s
				6 - Qual jogador é o maior goleador de todas as copas\s
				7 - Quais jogadores foram artilheiros (maior goleador) de cada edição\s
				8 - Qual jogador participou de mais edições de copa\s
				9 - Qual jogador mais novo que participou de uma copa\s
				10 - Qual jogador mais velho que participou de uma copa\s
				11 - Qual jogador conquistou mais copas\s
				12 - Qual seleção ganhou mais partidas em todas edições\s
				13 - Quantas copas possui cada seleção\s
				14 - Qual seleção participou de mais copas\s
				15 - Listar todos os atacantes de todos os times, da edição x
				16 - Listar o total de gols de todos os atacantes de todos as seleções do Brasil (todas edições)\s
				17 - Qual jogador é o maior goleador de todas as copas""");
			String opcao = scanner.nextLine();
			switch (opcao)
			{

			}
		}
	}

	public void updateMenu(JogadorRepository jogadorRepository,
						   TecnicoRepository tecnicoRepository,
						   SelecaoRepository selecaoRepository,
						   EdicaoRepository edicaoRepository,
						   FaseRepository faseRepository,
						   PosicaoRepository posicaoRepository,
						   PartidaRepository partidaRepository,
						   EstadioRepository estadioRepository,
						   ClassificaoRepository classificaoRepository,
						   EventoDePartidaRepository eventoDePartidaRepository,
						   JogadoresDaPartidaRepository jogadoresDaPartidaRepository,
						   PartidasDaEdicaoRepository partidasDaEdicaoRepository)
	{
		boolean isRunning = true;
		Scanner scanner = new Scanner(System.in);
		while (isRunning)
		{
			System.out.println("Digite o número da lista abaixo, para fazer a Operação selecionada:");
			System.out.println("""
				1 - Atualizar as informações (Evento) de uma partida em andamento\s
				2 -  Atualizar as informações de  uma partida\s
				3 -  Atualizar as informações de  um Jogador\s
				4 -  Atualizar as informações de um Tecnico\s
				5 -  Atualizar as informações de  uma selecao\s
				6 -  Atualizar as informações de uma edição\s
				7 -  Atualizar as informações de  um Estadio\s
				8 -  Atualizar as informações de uma Classificação a uma Seleção""");
			String opcao = scanner.nextLine();
			switch (opcao)
			{

			}
		}
	}
}
