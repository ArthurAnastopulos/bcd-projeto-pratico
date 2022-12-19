# Comentários

## Modelagem inicial

- Um mesmo jogador pode participar de diferentes seleções (edições) de um mesmo país. Por exemplo, o jogador Neymar fez parte da seleção do Brasil de 2014, 2018 e 2022.
- Um mesmo técnico pode atuar em diferentes seleções (diferentes edições e diferentes países). Por exemplo, o técnico Felipão foi técnico do Brasil em 2002 e depois foi técnico da seleção Portuguesa em 2006
- Como eu sei quais jogadores participaram de uma partida?
- Como eu sei qual seleção foi campeã de uma edição?
- Como eu sei qual jogador conquistou mais copas?
- Como eu sei quais seleções se enfrentaram nas diferentes fase (fase de grupos, oitavas, quartas, semi e final)
- Qual a necessidade dos relacionamentos identificadores entre Partida, Seleção e Estádio? Do jeito que está não parece necessário
- Qual a necessidade da tabela Evento? Não bastaria um N-pra-N entre Jogador e Partida? 

## Código Java

- Apesar de prover implementação para diversas operações de consulta e inserção, não apresentou as consultas solicitadas
  -  Listar o nome e país de todos os atacantes, de todos os times, da edição X
  -  Listar o total de gols de todos os atacantes de todos as seleções do Brasil (todas edições)
  -  Qual jogador é o maior goleador de todas as copas
- Nota: 7

