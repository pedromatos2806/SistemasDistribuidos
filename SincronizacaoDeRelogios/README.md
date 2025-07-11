# Sincronização de Relógios em Sistemas Distribuídos com Java RMI

## Qual Problema Esse Código Resolve?

O código apresentado resolve o problema da **sincronização de relógios entre diferentes computadores (nós) em um sistema distribuído**. Em ambientes distribuídos, cada máquina possui seu próprio relógio local, que pode apresentar pequenas diferenças em relação aos outros. Essas diferenças podem causar inconsistências em logs, ordens de eventos, coordenação de tarefas e até falhas em sistemas críticos.

### Por Que Esse Problema Existe?

- Cada computador possui um relógio independente, sujeito a atrasos e adiantamentos.
- Em sistemas distribuídos, é fundamental que todos os nós tenham uma noção de tempo próxima para garantir integridade, consistência e coordenação.
- Sem sincronização, tarefas como ordenação de eventos, auditoria, controle de concorrência e replicação de dados ficam comprometidas.

---

## Como o Código Resolve Esse Problema?

O código implementa um **protocolo de sincronização de relógio inspirado no NTP (Network Time Protocol)**, usando Java RMI para comunicação remota entre cliente e servidor.

### Funcionamento Geral

1. **Servidor NTP**  
   - Fica disponível aguardando requisições dos clientes.
   - Fornece o horário atual (timestamp) quando solicitado, simulando latência de rede.

2. **Cliente NTP**  
   - Solicita periodicamente o horário ao servidor.
   - Registra o instante de envio e de recebimento da resposta.
   - Calcula o tempo de viagem da mensagem (round-trip).
   - Ajusta seu relógio lógico baseado no horário do servidor e na latência estimada.
   - Exibe um relatório detalhado de cada sincronização.

### Soluções Aplicadas

- **Uso de RMI:** Permite comunicação transparente entre máquinas distintas na rede.
- **Cálculo do tempo de viagem:** O cliente estima a latência da rede para ajustar o relógio de forma mais precisa.
- **Relatórios:** O cliente gera logs detalhados, úteis para auditoria e análise.

---

## Para Que Serve e Onde É Usado?

### Aplicações Práticas

- **Sistemas distribuídos:** Qualquer sistema onde múltiplos computadores precisam trabalhar de forma coordenada (clusters, bancos de dados distribuídos, sistemas de arquivos distribuídos).
- **Logs e auditoria:** Garantir que registros de eventos estejam em ordem cronológica correta.
- **Sistemas financeiros:** Onde a precisão temporal é crítica para transações e auditorias.
- **Redes de sensores:** Para correlacionar dados coletados em diferentes pontos.
- **Ambientes de computação em nuvem e microserviços:** Sincronização de tarefas e consistência de dados.

### Exemplos de Uso

- **Servidores de banco de dados replicados:** Para garantir que as operações de escrita e leitura sigam a ordem correta.
- **Sistemas de monitoramento:** Para comparar eventos capturados em diferentes máquinas.
- **Jogos online e aplicações em tempo real:** Para manter a experiência sincronizada entre todos os jogadores/usuários.

---

## Como Utilizar o Código (Passo a Passo)

1. **Compile todas as classes Java**  
   No terminal, navegue até a pasta onde estão os arquivos `.java` e execute:
   
   javac*.java
  

2. **Inicie o servidor NTP**  
   Em um terminal, execute:
   ```
   java ServidorNTP
   ```
   O servidor será iniciado e ficará aguardando conexões dos clientes.

3. **Inicie um ou mais clientes NTP**  
   Em outros terminais (ou em outras máquinas na mesma rede), execute:
   ```
   java ClienteNTP
   ```
   Cada cliente irá solicitar periodicamente o horário ao servidor, sincronizar seu relógio lógico e exibir um relatório detalhado no console.

4. **Observe os relatórios de sincronização**  
   Cada cliente exibirá informações como:
   - Timestamp de envio da requisição
   - Timestamp do servidor
   - Timestamp de recebimento da resposta
   - Tempo de viagem total (RTP)
   - Relógio sincronizado

---

**Observações importantes:**
- O código pode ser adaptado para outras aplicações distribuídas que exijam comunicação em grupo e sincronização de tempo.
- O uso do Java RMI facilita a chamada remota de métodos entre diferentes computadores, tornando a comunicação transparente para o desenvolvedor.
- Certifique-se de que todas as máquinas estejam na mesma rede ou que as portas estejam liberadas para comunicação via RMI.
- Para testes locais, basta abrir múltiplos terminais na mesma máquina.