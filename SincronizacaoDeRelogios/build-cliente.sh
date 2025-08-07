#!/bin/bash
# Compila e executa o cliente NTP
SRC_DIR="src"
BIN_DIR="bin-cliente"
MAIN_CLASS="cliente.ClienteNTP"

mkdir -p "$BIN_DIR"
find "$SRC_DIR" -name "*.java" | xargs javac -d "$BIN_DIR"
java -cp "$BIN_DIR" "$MAIN_CLASS"
