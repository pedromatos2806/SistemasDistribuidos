#!/bin/bash
# Script para compilar e executar o projeto SincronizacaoDeRelogios

SRC_DIR="src"
BIN_DIR="bin"
MAIN_CLASS="Main"

# Cria o diretório bin se não existir
mkdir -p "$BIN_DIR"

# Compila todos os arquivos .java
find "$SRC_DIR" -name "*.java" | xargs javac -d "$BIN_DIR"

# Executa a classe principal
java -cp "$BIN_DIR" "$MAIN_CLASS"
