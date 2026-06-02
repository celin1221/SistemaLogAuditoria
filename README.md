# 📦 Módulo de Log Genérico (Java)

## 📌 Descrição

Este projeto implementa um **módulo de log reutilizável** em Java, desenvolvido como uma biblioteca independente, seguindo os princípios de **baixo acoplamento** e **responsabilidade única (SRP)**.

O sistema permite registrar logs em diferentes formatos:

* JSON Lines (JSONL)
* CSV
* XML

A arquitetura foi projetada para possibilitar a **troca dinâmica do formato de log**, sem impactar o sistema cliente.

---

## 🧠 Arquitetura

O projeto segue uma abordagem orientada a objetos baseada em interfaces:

* `ILogger` → Interface principal do sistema de log
* `JsonLogger`, `CSVLogger`, `XmlLogger` → Implementações concretas
* `LogEntry` → Classe genérica para representar os dados do log

### 🔹 Princípios aplicados

* SRP (Single Responsibility Principle)
* Baixo acoplamento
* Reutilização de código
* Injeção de dependência

---

## 🧩 Estrutura do Log

Cada registro de log contém:

* Usuário
* Data
* Hora
* Nome da operação
* Dados adicionais (estrutura dinâmica via `Map<String, String>`)

Essa abordagem permite que o módulo seja reutilizado em **qualquer tipo de sistema**, sem depender de um domínio específico (como pedidos, clientes, etc.).

---

## 🚀 Como usar

### 1. Criar um logger

```java
ILogger logger = new JsonLogger("log.jsonl");
```

Ou:

```java
ILogger logger = new CSVLogger("log.csv");
ILogger logger = new XmlLogger("log.xml");
```

---

### 2. Criar os dados do log

```java
Map<String, String> dados = new HashMap<>();
dados.put("acao", "teste_log");
dados.put("status", "sucesso");
```

---

### 3. Criar o LogEntry

```java
LogEntry log = new LogEntry(
    "usuario_teste",
    LocalDate.now(),
    LocalTime.now(),
    "Teste do sistema",
    dados
);
```

---

### 4. Registrar o log

```java
try {
    logger.registrar(log);
} catch (IOException e) {
    System.err.println("Erro ao registrar log: " + e.getMessage());
}
```

---

## 📄 Exemplos de saída

### JSONL

```json
{"usuario":"usuario_teste","data":"2026-06-02","hora":"14:30:10","operacao":"Teste do sistema","dados":{"acao":"teste_log","status":"sucesso"}}
```

---

### CSV

```csv
usuario=usuario_teste;data=2026-06-02;hora=14:30:10;operacao=Teste do sistema;acao=teste_log;status=sucesso
```

---

### XML

```xml
<log>
  <usuario>usuario_teste</usuario>
  <data>2026-06-02</data>
  <hora>14:30:10</hora>
  <operacao>Teste do sistema</operacao>
  <dados>
    <acao>teste_log</acao>
    <status>sucesso</status>
  </dados>
</log>
```

---

## ⚠️ Tratamento de Exceções

O módulo utiliza propagação de exceções (`throws IOException`), permitindo que o sistema cliente decida como tratar falhas, garantindo maior flexibilidade e desacoplamento.

---

## 🔄 Reutilização

O módulo foi projetado para ser utilizado em diferentes aplicações, como:

* Sistemas de delivery
* Sistemas financeiros
* Sistemas de autenticação
* APIs REST

Isso é possível devido ao uso de uma estrutura genérica (`Map<String, String>`) para os dados do log.

---

## 🛠 Tecnologias

* Java 21
* Maven

---

## 📦 Publicação

O projeto pode ser publicado via **JitPack** para reutilização como dependência em outros sistemas.

---

## 👥 Equipe

* Marcelo Vieira Gomes
* Henrique Queiroz Teixeira

---

## 🔗 Clone do repositório

```bash
git clone <link-do-repositorio>
```

---
