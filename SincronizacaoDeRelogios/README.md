# Sincronização de Relógios em Sistemas Distribuídos com Java RMI

## Visão Geral

Este projeto implementa uma solução simples para o problema da **sincronização de relógios entre diferentes computadores (nós) em um sistema distribuído**, utilizando Java RMI (Remote Method Invocation).

Em sistemas distribuídos, cada nó possui seu próprio relógio local, que pode variar ligeiramente em relação aos outros. Essas variações podem gerar inconsistências em logs, ordens de eventos, coordenação de tarefas, entre outros problemas.

Este código simula um protocolo de sincronização inspirado no NTP (Network Time Protocol), permitindo que clientes ajustem seus relógios com base no horário do servidor central.

---

## Por Que Sincronizar Relógios?

* Cada computador tem um relógio independente, sujeito a atrasos e variações.
* Sistemas distribuídos precisam de uma noção de tempo próxima entre os nós para garantir consistência e integridade.
* Sem sincronização, tarefas como ordenação de eventos, auditoria, controle de concorrência e replicação de dados ficam comprometidas.

---

## Como o Código Resolve o Problema?

### Estrutura do Sistema

* **Servidor NTP:**

   * Roda na porta 3240 usando RMI.
   * Responde a requisições enviando seu timestamp atual (data e hora).
   * Simula variações na latência com pausas aleatórias para representar atrasos reais de rede.

* **Cliente NTP:**

   * Consulta periodicamente o servidor para obter seu timestamp.
   * Registra o instante local do envio da requisição e o instante do recebimento da resposta.
   * Calcula o tempo total de viagem (round-trip time - RTT).
   * Ajusta seu relógio lógico somando ao timestamp do servidor metade do tempo total de viagem estimado, considerando ida e volta.
   * Exibe um relatório detalhado da sincronização, incluindo todos os timestamps e o relógio sincronizado.

### Principais Conceitos Aplicados

* **Comunicação Remota (RMI):** Permite o cliente invocar métodos do servidor de forma transparente, mesmo estando em máquinas distintas.
* **Estimativa de Latência:** O cliente mede o RTT para ajustar melhor seu relógio e compensar atrasos.
* **Relatórios Detalhados:** Auxiliam na análise da precisão e da qualidade da sincronização.

---

## Para Que Serve?

### Aplicações Práticas

* Sincronização de relógios em clusters, bancos de dados distribuídos, sistemas de arquivos distribuídos.
* Garantir a ordem cronológica correta em logs e auditorias.
* Ambientes financeiros e bancários onde a precisão temporal é crítica.
* Redes de sensores distribuídos para correlação de dados.
* Plataformas em nuvem e arquiteturas de microserviços, para coordenação e consistência.

### Exemplos de Uso

* Servidores replicados garantindo ordem correta de operações.
* Sistemas de monitoramento e análise de eventos distribuídos.
* Jogos online e aplicações em tempo real, sincronizando ações entre usuários.

---

## Como Executar o Projeto

### Pré-requisitos

* Java JDK 8 ou superior instalado.
* Configuração do `JAVA_HOME`.
* Rede configurada para permitir comunicação na porta 3240 (para execução em máquinas diferentes).
* Editor ou terminal para compilação e execução.

## Exemplo de Relatório Gerado pelo Cliente

```
=============================================================
Nome do Servidor: ServidorNTP
Porta do Servidor: 3240
Timestamp de envio da requisição: 2025-08-06 23:21:19.028
Timestamp do servidor: 2025-08-06 23:21:19.128
Timestamp de recebimento da resposta: 2025-08-06 23:21:21.026
Tempo de viagem total (RTP): 1998 ms
Relógio sincronizado: 2025-08-06 23:21:20.127
=============================================================
```

---

## Observações Finais

* A sincronização é uma estimativa simples, assumindo latência simétrica.
* O servidor simula atrasos aleatórios para tornar a sincronização mais realista.
* O código pode ser ampliado para suportar múltiplos clientes e ajustes mais avançados.
* Certifique-se que firewalls e configurações de rede permitam comunicação na porta 3240 para múltiplas máquinas.
* Para testes locais, basta abrir múltiplos terminais na mesma máquina.

