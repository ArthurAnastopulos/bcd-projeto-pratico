package engtelecom.bcd.projeto_pratico;

import engtelecom.bcd.projeto_pratico.entities.*;
import engtelecom.bcd.projeto_pratico.repositories.*;
import org.hibernate.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class ProjetoPraticoApplication {
	private final EventoRepository eventoRepository;
	private final ClassificaoDasSelecoesRepository classificaoDasSelecoesRepository;

	public ProjetoPraticoApplication(EventoRepository eventoRepository,
									 ClassificaoDasSelecoesRepository classificaoDasSelecoesRepository) {
		this.eventoRepository = eventoRepository;
		this.classificaoDasSelecoesRepository = classificaoDasSelecoesRepository;
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
									PartidasDaEdicaoRepository partidasDaEdicaoRepository,
									ClassificaoDasSelecoesRepository classificaoDasSelecoesRepository)
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
					U - Para Atualizar (Não Implementado por falta de tempo Hábil)\s
					D - Para Deletar (Não Implementado por falta de tempo Hábil)""");

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
								partidasDaEdicaoRepository,
								classificaoDasSelecoesRepository);
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
								partidasDaEdicaoRepository,
								classificaoDasSelecoesRepository);
						break;
					case "u":
						System.out.println("Opção de Atualização Selecionada");
						/*updateMenu(jogadorRepository,
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
								partidasDaEdicaoRepository,
								classificaoDasSelecoesRepository);*/
						System.out.println("Não Implementado por Falta de Tempo Hábil");
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
						   PartidasDaEdicaoRepository partidasDaEdicaoRepository,
						   ClassificaoDasSelecoesRepository classificaoDasSelecoesRepository)
	{
		boolean isRunning = true;
		Scanner scanner = new Scanner(System.in);
		while (isRunning)
		{
			System.out.println("Digite o número da lista abaixo, para fazer a Operação selecionada. Ou para voltar para atras digite qualquer outro botão não mencionado:");
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

					System.out.print("Informe a fase em que está ocorrendo a Classifição: ");
					String idFase_ = scanner.nextLine();
					Optional<Fase> classFase = faseRepository.findById(Integer.parseInt(idFase_));
					if(classFase.isEmpty()){
						System.out.println("Fase não encontrada");
						break;
					}

					ClassificaoDasSelecoes classificaoDasSelecoes = new ClassificaoDasSelecoes(classf.get(), sClassf.get(), classFase.get());
					classificaoDasSelecoesRepository.save(classificaoDasSelecoes);
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
						   PartidasDaEdicaoRepository partidasDaEdicaoRepository,
						   ClassificaoDasSelecoesRepository classificaoDasSelecoesRepository)
	{
		boolean isRunning = true;
		Scanner scanner = new Scanner(System.in);
		while (isRunning)
		{
			System.out.println("Digite o número da lista abaixo, para fazer a Operação selecionada. Ou para voltar para atras digite qualquer outro botão não mencionado:");
			System.out.println("""
					1 - Quais os jogadores e técnicos de cada seleção\s
					2 - Quais jogadores participaram de uma determinada partida\s
					3 - Informações sobre um Determinado Jogador (Data de Nascimento, Nacionalidade)\s
					4 - Qual a posição de um Jogador em uma determinada partida\s
					5 - Listar todos os atacantes de todos os times, da edição x
					6 - Quantas copas possui cada seleção\s
					7 - Qual seleção participou de mais copas""");
			String opcao = scanner.nextLine();
			switch (opcao)
			{
				case "1":
					System.out.println("Selecionado opção para Listar Todos os Jogadores e Técnicos de cada Seleção");

					Iterable<Selecao> todasSelecoes = selecaoRepository.findAll();

					StringBuilder sb1 = new StringBuilder();

					sb1.append(String.format("|%-25s|%-25s|%-25s|%-25s|\n", "Seleção", "Edição" ,"Nome", "Sobrenome"));
					sb1.append("----------------------------------------------------------------\n");

					todasSelecoes.forEach(selecao -> {
						Set<Jogador> sbPlayers = selecao.getJogadores();
						sbPlayers.forEach(jogador -> {
							sb1.append(String.format("|%-25s|%-25s", selecao.getPais(), selecao.getEdicao().getAno()));
							sb1.append(String.format("|%-25s|%-25s|\n", jogador.getNome(), jogador.getSobrenome()));
						});
						Set<Tecnico> sbTecnico = selecao.getTecnicos();
						sbTecnico.forEach(tecnico -> {
							sb1.append(String.format("|%-25s|%-25s", selecao.getPais(), selecao.getEdicao().getAno()));
							sb1.append(String.format("|%-25s|%-25s|\n", tecnico.getNome(), tecnico.getSobrenome()));
						});
					});
					System.out.println(sb1);
					break;
				case "2":
					System.out.println("Selecionado opção para Listar os Jogadores que participaram de uma Determinada partida: ");
					System.out.print("Digite numero identificador da partida: ");
					String procurarPartida = scanner.nextLine();

					Optional<Partida> partida_ = partidaRepository.findById(Integer.parseInt(procurarPartida));
					if(partida_.isEmpty()){
						System.out.println("Partida não encontrada");
						break;
					}

					Optional<Iterable<JogadoresDaPartida>> jogadoresDaPartida = jogadoresDaPartidaRepository.findByPartida(partida_.get());
					if (jogadoresDaPartida.isEmpty()){
						System.out.println("Não encontrou nenhum jogador na partida");
						break;
					}

					jogadoresDaPartida.get().forEach(jogadoresDaPartida1 -> {
						System.out.println("Teste");
					});
					break;
				case  "3":
					System.out.println("Selecionado busca de um determindado Jogador: ");
					System.out.print("Digite o numero identificador deste Jogador: ");
					String buscaJogador = scanner.nextLine();

					Optional<Jogador> jogadorOptional_ = jogadorRepository.findById(Integer.parseInt(buscaJogador));
					if (jogadorOptional_.isEmpty()){
						System.out.println("Jogador nao encontrado");
						break;
					}

					StringBuilder sb3 = new StringBuilder();
					sb3.append(String.format("|%-25s|%-25s|%-25s|%-25s|\n", "Nome", "Sobrenome" ,"DataNasc", "Nacionalidae"));
					sb3.append("----------------------------------------------------------------\n");
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					sb3.append(String.format("|%-25s|%-25s|%-25s|%-25s|\n", jogadorOptional_.get().getNome(), jogadorOptional_.get().getSobrenome(), dateFormat.format(jogadorOptional_.get().getDataNasc()), jogadorOptional_.get().getNacionalidade()));
					System.out.println(sb3);
					break;
				case "4":
					System.out.println("Selecionado opção para listar a posição de um jogador em uma determinada partida: ");
					System.out.println("Digite o número identificador do Jogador a ser buscado");
					String strJogador = scanner.nextLine();
					Optional<Jogador> jogadorPosicao = jogadorRepository.findById(Integer.parseInt(strJogador));
					if (jogadorPosicao.isEmpty()){
						System.out.println("Jogador não encontrado");
						break;
					}
					System.out.print("Digite o número identificador da Partida a ser buscada: ");
					String  strPartida = scanner.nextLine();
					Optional<Partida> optionalPartida = partidaRepository.findById(Integer.parseInt(strPartida));
					if (optionalPartida.isEmpty()){
						System.out.println("Partida não Encontrada");
						break;
					}

					Optional<JogadoresDaPartida> optionalJogadoresDaPartida = jogadoresDaPartidaRepository.findByJogadorAndPartida(jogadorPosicao.get(), optionalPartida.get());
					if (optionalJogadoresDaPartida.isEmpty()){
						System.out.println("Jogador não esta nesta partida");
						break;
					}

					StringBuilder sb4 = new StringBuilder();
					sb4.append(String.format("|%-25s|%-25s|%-25s|\n", "Nome", "Sobrenome" ,"Posição"));
					sb4.append("----------------------------------------------------------------\n");
					sb4.append(String.format("|%-25s|%-25s|%-25s|\n", jogadorPosicao.get().getNome(), jogadorPosicao.get().getSobrenome(), optionalJogadoresDaPartida.get().getPosicao().getTitulo()));
					System.out.println(sb4);
					break;
				case "5":
					System.out.println("Selecionado opção para listar todos os atacantes de todos os times, da edição x");
					System.out.print("Digite o ano da Copa que deseja buscar: ");
					String edicaoStr = scanner.nextLine();
					Optional<Edicao> optionalEdicao = edicaoRepository.findByAno(Integer.parseInt(edicaoStr));
					if(optionalEdicao.isEmpty()){
						System.out.println("Copa não encontrada");
						break;
					}

					Optional<Iterable<PartidasDaEdicao>> optionalIterable = partidasDaEdicaoRepository.findByEdicao(optionalEdicao.get());
					if(optionalIterable.isEmpty()){
						System.out.println("Esta edição ainda não possui nenhuma partida arquivada");
						break;
					}

					StringBuilder sb5 = new StringBuilder();
					sb5.append(String.format("|%-25s|%-25s|%-25s|\n", "Nome", "Sobrenome", "Nacionalidade"));
					sb5.append("----------------------------------------------------------------\n");

					optionalIterable.get().forEach(partidasDaEdicao -> {
						Optional<Iterable<JogadoresDaPartida>> optionalJogadoresDaPartidaIterable = jogadoresDaPartidaRepository.findByPartida(partidasDaEdicao.getPartida());
						optionalJogadoresDaPartidaIterable.ifPresent(jogadoresDaPartidas -> jogadoresDaPartidas.forEach(jogadoresDaPartida1 -> {
								if(jogadoresDaPartida1.getPosicao().getTitulo().equals("Atacante")) {
									sb5.append(String.format("|%-25s|%-25s|%-25s|\n", jogadoresDaPartida1.getJogador().getNome(), jogadoresDaPartida1.getJogador().getSobrenome(), jogadoresDaPartida1.getJogador().getNacionalidade()));
								}
						}));
					});
					System.out.println(sb5);
					break;
				case "6":
					System.out.println("Selecionado, Quantas copas possui cada seleção: ");
					Iterable<Selecao> allSelecoes = selecaoRepository.findAll();
					HashMap<String, Integer> countSelecoes = new HashMap<>();

					allSelecoes.forEach(selecao -> {
						if(! countSelecoes.containsKey(selecao.getPais())) {
							countSelecoes.put(selecao.getPais(), 1);
						} else {
							countSelecoes.put(selecao.getPais(), countSelecoes.get(selecao.getPais()) + 1);
						}
					});

					StringBuilder sb6 = new StringBuilder();
					sb6.append(String.format("|%-25s|%-35s|\n", "Seleção", "Quantida de Edições"));
					sb6.append("----------------------------------------------------------------\n");

					for (String pais : countSelecoes.keySet())
					{
						sb6.append(String.format("|%-25s|%-35s|\n", pais, countSelecoes.get(pais)));
					}
					System.out.println(sb6);
					break;
				case "7":
					System.out.println("Selecionado, Qual seleção participou de mais copas: ");
					Iterable<Selecao> allSelecoes_ = selecaoRepository.findAll();
					HashMap<String, Integer> countSelecoes_ = new HashMap<>();

					allSelecoes_.forEach(selecao -> {
						if(! countSelecoes_.containsKey(selecao.getPais())) {
							countSelecoes_.put(selecao.getPais(), 1);
						} else {
							countSelecoes_.put(selecao.getPais(), countSelecoes_.get(selecao.getPais()) + 1);
						}
					});

					StringBuilder sb7 = new StringBuilder();
					int maxValueInMap = (Collections.max(countSelecoes_.values()));
					for (Map.Entry<String, Integer> entry :
							countSelecoes_.entrySet()) {

						if (entry.getValue() == maxValueInMap) {
							sb7.append(String.format("A seleção que mais participou é %-10s com %-4s vezes \n", entry.getKey(), entry.getValue()));
						}
					}
					System.out.println(sb7);
					break;
				default:
					System.out.println("Retornando ao Menu Principal");
					isRunning = false;
					break;
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
						   PartidasDaEdicaoRepository partidasDaEdicaoRepository,
						   ClassificaoDasSelecoesRepository classificaoDasSelecoesRepository)
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
