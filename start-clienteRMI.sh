#!/bin/bash
if [ $# -lt 1 ]; then
  echo "Uso: $0 <SeuNome>"
  exit 1
fi

# Compila os arquivos Java (opcional, remova se já estiver compilado)
javac -d ChatRMIDistribuido/bin ChatRMIDistribuido/src/interfaces/*.java ChatRMIDistribuido/src/servidor/*.java ChatRMIDistribuido/src/cliente/*.java

# Inicia o cliente RMI com o nome informado
java -cp ChatRMIDistribuido/bin cliente.ClienteChatApp "$1"
