# Chat Distribuído com Java RMI

Este projeto implementa um sistema de chat simples distribuído utilizando Java RMI (Remote Method Invocation), com toda a estrutura, mensagens e comentários em português.

## Funcionamento Geral

O sistema é composto por dois programas principais:

A comunicação entre cliente e servidor é feita via RMI, permitindo que métodos sejam chamados remotamente entre diferentes máquinas ou processos.

## Estrutura dos Arquivos

## Como Executar

1. **Compile todos os arquivos Java:**

   ```
   javac -d ChatRMIDistribuido/bin ChatRMIDistribuido/src/interfaces/*.java ChatRMIDistribuido/src/servidor/*.java ChatRMIDistribuido/src/cliente/*.java
   ```

2. **Inicie o servidor em um terminal:**

   ```
   java -cp ChatRMIDistribuido/bin servidor.ServidorChatApp
   ```

   O servidor irá criar o registro RMI na porta 1099 e ficará aguardando conexões de clientes.

3. **Inicie o cliente em outro terminal:**

   ```
   java -cp ChatRMIDistribuido/bin cliente.ClienteChatApp SeuNome
   ```

   Substitua `SeuNome` pelo nome de usuário desejado. O cliente irá conectar ao servidor, entrar no chat e permitir o envio de mensagens.

4. **Envie mensagens:**
   - Digite mensagens e pressione Enter para enviar.
   - Para sair do chat, digite `/sair`.

## Fluxo de Comunicação

O funcionamento do ChatRMIDistribuido ocorre em etapas bem definidas:

### 1. Inicialização do Servidor

- O servidor é iniciado com a classe `ServidorChatApp`, que cria o registro RMI na porta 1099 e registra o objeto remoto `ServidorChat`.
- O servidor fica aguardando conexões de clientes.

### 2. Inicialização do Cliente

- O cliente é iniciado com a classe `ClienteChatApp`, recebendo o nome do usuário como argumento.
- O cliente conecta ao registro RMI do servidor e registra seu objeto remoto para receber mensagens.
- O cliente solicita ao servidor para ser adicionado à lista de usuários conectados.

### 3. Envio e Recebimento de Mensagens

- O usuário digita uma mensagem no terminal do cliente.
- O cliente envia a mensagem para o servidor usando o método remoto.
- O servidor distribui a mensagem para todos os clientes conectados, chamando o método remoto de cada cliente para exibir a mensagem.

### 4. Saída do Usuário

- Se o usuário digitar `/sair`, o cliente solicita ao servidor sua remoção da lista de usuários.
- O servidor notifica todos os clientes sobre a saída do usuário.

### 5. Comunicação RMI

- Toda a comunicação entre cliente e servidor é feita por métodos remotos definidos nas interfaces RMI.
- O servidor gerencia a lista de usuários e garante que todas as mensagens sejam entregues em tempo real.

---

## Passo a Passo do Algoritmo

Abaixo está o passo a passo detalhado do funcionamento do algoritmo do chat distribuído:

1. **Servidor inicia:**

   - Cria o registro RMI na porta 1099.
   - Instancia o objeto `ServidorChat` e o registra no RMI.
   - Fica aguardando conexões de clientes.

2. **Cliente inicia:**

   - Recebe o nome do usuário como argumento.
   - Conecta ao registro RMI do servidor.
   - Instancia o objeto `ClienteChat` e registra sua referência remota.
   - Solicita ao servidor para ser adicionado à lista de usuários.

3. **Usuário envia mensagem:**

   - O cliente lê a mensagem digitada pelo usuário.
   - Chama o método remoto `enviarMensagem` do servidor, passando a mensagem e o nome do usuário.
   - O servidor recebe a mensagem e repassa para todos os clientes conectados, chamando o método remoto `receberMensagem` de cada cliente.

4. **Usuário sai do chat:**

   - Se o usuário digitar `/sair`, o cliente chama o método remoto `removerUsuario` do servidor.
   - O servidor remove o usuário da lista e notifica todos os clientes sobre a saída.

5. **Sincronização e concorrência:**

   - O servidor utiliza uma estrutura de dados thread-safe (`ConcurrentHashMap`) para gerenciar os usuários conectados.
   - Os métodos de adicionar, remover e enviar mensagens são sincronizados para evitar problemas de concorrência.

6. **Entrega de mensagens:**
   - Cada mensagem enviada por um usuário é recebida pelo servidor e distribuída para todos os clientes conectados, garantindo comunicação em tempo real.

---
