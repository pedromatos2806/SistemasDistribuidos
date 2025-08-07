#!/bin/bash
# Compila e executa o servidor NTP

SRC_DIR="src"
BIN_DIR="bin-servidor"
MAIN_CLASS="servidor.ServidorNTP"

mkdir -p "$BIN_DIR"
find "$SRC_DIR" -name "*.java" | xargs javac -d "$BIN_DIR"
java -cp "$BIN_DIR" "$MAIN_CLASS"ncronizacaoDeRelogios  ➜ (  main)   2ms   5:50 PM   
 ⚡pedromatos ❯❯ ./build-cliente.sh 
src/cliente/ClienteNTP.java:10: error: package interfaces does not exist
import interfaces.IServidorNTP;
                 ^
src/cliente/ClienteNTP.java:22: error: cannot find symbol
    private IServidorNTP servidorNTP;
            ^
  symbol:   class IServidorNTP
  location: class ClienteNTP
src/cliente/ClienteNTP.java:25: error: cannot find symbol
        this.servidorNTP = (IServidorNTP) LocateRegistry.getRegistry("localhost", PORTA_SERVIDOR)
                            ^
  symbol:   class IServidorNTP
  location: class ClienteNTP
3 errors
Erro: Não foi possível localizar nem carregar a classe principal cliente.ClienteNTP
Causada por: java.lang.ClassNotFoundException: cliente.ClienteNTP