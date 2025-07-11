# Chat Distribuído com Java RMI

## Visão Geral

Este projeto implementa um **chat em grupo distribuído** usando Java RMI (Remote Method Invocation). Ele permite que múltiplos usuários, cada um em seu próprio computador, se comuniquem em tempo real em uma mesma sala de bate-papo.

---

## Problema Resolvido

Em sistemas distribuídos, é comum a necessidade de comunicação em grupo — como em chats, sistemas de mensagens ou suporte remoto. O desafio está em:

- Permitir que vários usuários, em diferentes máquinas, troquem mensagens em tempo real.
- Garantir que todos recebam as mensagens, mesmo com entradas e saídas dinâmicas de usuários.
- Manter a comunicação confiável e sincronizada.

Este código resolve exatamente esse problema, criando uma infraestrutura de chat em grupo onde todos os participantes recebem as mensagens enviadas por qualquer usuário conectado.

---

## Para que serve esse código?

- **Chat em grupo distribuído:** Permite que qualquer número de clientes se conecte a um servidor de chat, envie mensagens e receba mensagens de todos os outros usuários conectados.
- **Base para sistemas de mensagens:** Pode ser adaptado para aplicações como salas de bate-papo, suporte remoto, jogos multiplayer, etc.
- **Demonstração de Java RMI:** Mostra como implementar comunicação remota entre objetos Java em diferentes máquinas.

---

## Como o código funciona?

### 1. Arquitetura Cliente-Servidor

- **Servidor de Chat:**  
  Mantém uma lista dos usuários conectados. Quando recebe uma mensagem de um usuário, repassa para todos os outros.

- **Cliente de Chat:**  
  Se conecta ao servidor, envia mensagens e recebe mensagens dos outros usuários automaticamente.

### 2. Uso de Java RMI

- O Java RMI permite que métodos sejam chamados remotamente entre diferentes computadores, como se fossem locais.
- O servidor expõe métodos para:
  - Registrar um novo usuário.
  - Transmitir mensagens para todos.
  - Remover usuários que saem do chat.
- O cliente expõe um método para:
  - Receber mensagens do servidor (quando outro usuário envia algo ou quando alguém entra/sai do chat).

### 3. Funcionamento Básico

1. O servidor é iniciado e fica aguardando conexões.
2. Um cliente se conecta ao servidor, se registra e começa a receber mensagens.
3. Quando um usuário envia uma mensagem, o servidor repassa para todos os outros.
4. Quando um usuário sai, o servidor avisa os demais.

---

## Resumo

- **Problema resolvido:** Comunicação em grupo entre pessoas em diferentes computadores, em tempo real.
- **Para que serve:** Criar chats, sistemas de mensagens, ou qualquer aplicação que precise de comunicação distribuída.
- **Como faz:** Usando Java RMI para conectar clientes e servidor, transmitindo mensagens automaticamente para todos os participantes.

---

## Exemplo de Fluxo

1. Inicie o servidor de chat.
2. Inicie um ou mais clientes de chat (cada um pode estar em um computador diferente).
3. Cada cliente pode digitar mensagens; todas as mensagens aparecem para todos os participantes conectados.
4. Qualquer cliente pode sair a qualquer momento, e os demais são notificados.

---

## Requisitos

- Java 8 ou superior
- Conhecimento básico de terminal para compilar e rodar as classes

---


## Como Executar

1. **Compile todas as classes Java:**  
   No terminal, acesse a pasta onde estão os arquivos `.java` e execute:
   ``javac *.java``

2. **Inicie o servidor de chat:**  
   Abra um terminal e execute:
   ```
   java ServidorChatApp
   ```
   O servidor será iniciado e ficará aguardando conexões dos clientes.

3. **Inicie cada cliente em terminais separados:**  
   Para cada usuário que deseja participar do chat, abra um novo terminal e execute:
   ``java ClienteChatApp`` NomeDoUsuario PortaDoUsuario  
   Substitua **NomeDoUsuario** pelo nome desejado e **PortaDoUsuario** por uma porta livre (exemplo: 9032, 9033, etc.).

   Exemplo:  
   ``java ClienteChatApp`` Ana 9032  
   ``java ClienteChatApp`` Bruno 9033  

4. **Participe da conversa:**  
   Digite mensagens normalmente para enviar ao grupo.  
   Para sair do chat, digite:
   ``/sair``

---

**Observações importantes:**
- O código pode ser adaptado para outras aplicações distribuídas que exijam comunicação em grupo.
- O uso do Java RMI facilita a chamada remota de métodos entre diferentes computadores.
- Certifique-se de que todas as máquinas estejam na mesma rede ou que as portas estejam liberadas para comunicação via RMI.
- Para testes locais, basta abrir múltiplos terminais na mesma máquina, alterando apenas o nome e a porta do cliente.
   