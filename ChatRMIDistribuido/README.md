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

## Observações

## Requisitos
