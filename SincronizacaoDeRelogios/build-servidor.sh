#!/bin/bash
# Compila e executa o servidor NTP

SRC_DIR="src"
BIN_DIR="bin-servidor"
MAIN_CLASS="servidor.ServidorNTP"

mkdir -p "$BIN_DIR"
find "$SRC_DIR" -name "*.java" | xargs javac -d "$BIN_DIR"
java -cp "$BIN_DIR" "$MAIN_CLASS"