# Produtor-Consumidor com Buffer Limitado em Java

## Visão Geral

Este projeto implementa o clássico **problema do Produtor-Consumidor** usando Java e recursos modernos de concorrência (`BlockingQueue`). O problema do Produtor-Consumidor é um dos exemplos mais conhecidos de sincronização entre threads em programação concorrente.

## O Problema

No problema do Produtor-Consumidor, múltiplas threads produtoras geram dados e os colocam em um buffer compartilhado, enquanto múltiplas threads consumidoras retiram dados desse buffer para processá-los. O desafio é garantir que:

- Produtores não insiram itens em um buffer cheio.
- Consumidores não retirem itens de um buffer vazio.
- O acesso ao buffer seja seguro, evitando condições de corrida (race conditions).

## O Que Este Código Faz

- **Produtores** geram números sequenciais e tentam inserir no buffer.
- **Consumidores** retiram itens do buffer e os "consomem".
- O buffer tem tamanho limitado (10 itens). Se estiver cheio, produtores aguardam. Se estiver vazio, consumidores aguardam.
- O acesso ao buffer é seguro e sincronizado automaticamente pelo uso de `BlockingQueue`.

## Como Funciona

- O programa principal (`Program`) cria dois produtores e cinco consumidores.
- Cada produtor e consumidor roda em sua própria thread.
- Os produtores usam `buffer.put(item)` para inserir itens, bloqueando se o buffer estiver cheio.
- Os consumidores usam `buffer.take()` para retirar itens, bloqueando se o buffer estiver vazio.
- Mensagens no console mostram a produção e o consumo, além do tamanho atual do buffer.

## Benefícios Desta Solução

- **Simplicidade:** O uso de `BlockingQueue` elimina a necessidade de implementar semáforos e gerenciamento manual de sincronização.
- **Segurança:** Não há risco de condições de corrida no acesso ao buffer.
- **Escalabilidade:** Fácil aumentar ou diminuir o número de produtores e consumidores.

## Como Executar

1. Compile todos os arquivos Java do pacote `impl`.
2. Execute a classe `Program`.
3. Observe a produção e o consumo de itens no console.

## Exemplo de Saída

[Producer 1] Producing => Item 1. Buffer size: 1  
[Consumer 2] Consuming => Item 1. Buffer size: 0  
[Producer 2] Producing => Item 1. Buffer size: 1  
[Consumer 1] Consuming => Item 1. Buffer size: 0  
...  


## Aplicações Reais

- Sistemas de processamento paralelo.
- Filtros de dados em pipelines.
- Qualquer situação onde múltiplos produtores e consumidores compartilham recursos limitados.

---

**Resumo:**  
Este código resolve, de forma eficiente e segura, o problema do Produtor-Consumidor com buffer limitado, usando práticas de concorrência do Java.

