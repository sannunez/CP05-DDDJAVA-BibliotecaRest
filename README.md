# Check Point 05 - Domain Driven Design |  JAVA - Projeto Biblioteca Online

**Professor Responsável:** Gustavo Molina  
**Faculdade:** FIAP - Faculdade de Informática e Admnistração Paulista

---

## 🎯 Objetivo do Projeto

Este projeto tem como objetivo a **aplicação prática de conceitos de Spring Boot, MVC, JPA e Thymeleaf** no desenvolvimento de uma aplicação web para gerenciar uma biblioteca comunitária.  

O foco é permitir o estudo e a prática de:

- Estrutura de camadas em Spring Boot (model, repository, controller)  
- Manipulação de entidades JPA e relacionamentos  
- Validações usando **Jakarta Validation**  
- Criação de formulários e listagens com **Thymeleaf**  
- Integração com banco de dados MySQL  

---

## 📌 Funcionalidades

### Cadastro de Livros
- Inserir, editar e excluir livros  
- Cada livro possui: título, autor, ano e status (disponível ou emprestado)  
- Ao cadastrar, o status é **disponível**  

### Cadastro de Usuários
- Inserir e listar usuários  
- Cada usuário possui: nome e e-mail válido  

### Registro de Empréstimos
- Vincula um livro e um usuário  
- Registra data de retirada e data prevista para devolução  
- Ao devolver, o livro volta a **status disponível**  

### Listagens
- Todos os livros cadastrados  
- Livros disponíveis  
- Empréstimos ativos (quem pegou, qual livro e até quando)  

---

## 💻 Tecnologias e Dependências

- **Spring Boot**  
- **Spring Web**  
- **Spring Data JPA**  
- **Thymeleaf**  
- **Jakarta Validation & Persistence**  
- **MySQL**  

Dependências incluídas no `pom.xml`:

- `spring-boot-starter-web`  
- `spring-boot-starter-data-jpa`  
- `spring-boot-starter-thymeleaf`  
- `mysql-connector-java`  
- `jakarta.validation-api`  

---

## ⚙️ Configuração e Execução

1. Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
cd <NOME_DO_PROJETO>
```

2. Acesse o arquivo application.properties e insira suas informações nas seguintes linhas:
```bash
spring.datasource.username=<INSIRA_NOME_DE_USUARIO>
spring.datasource.password=<INSIRA_SENHA>
```

3. Em sua IDE execute a classe BibliotecaApplication.

4. Em seu Browser(Navegador) acesse:
```bash
http://localhost:8080
```
