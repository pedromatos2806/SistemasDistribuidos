#!/bin/bash
# Compila os arquivos Java (opcional, remova se já estiver compilado)
javac -d ChatRMIDistribuido/bin ChatRMIDistribuido/src/interfaces/*.java ChatRMIDistribuido/src/servidor/*.java ChatRMIDistribuido/src/cliente/*.java

# Inicia o servidor RMI
java -cp ChatRMIDistribuido/bin servidor.ServidorChatApp
