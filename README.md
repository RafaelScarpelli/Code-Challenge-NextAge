# Code-Challenge-NextAge – To‑Do List Web App

## Descrição do Projeto

Este projeto consiste em uma aplicação web full‑stack de gerenciamento de tarefas — um **To‑Do List**, desenvolvido como parte de um processo seletivo para estágio em desenvolvimento web. A aplicação permite criar, visualizar, editar, concluir e excluir tarefas, com foco em usabilidade, organização de código e boas práticas de programação ([github.com](https://github.com/RafaelScarpelli/Code-Challenge-NextAge)).

## Funcionalidades

- [x] Criação de Tarefas (título e descrição)  
- [x] Visualização de Tarefas (concluídas e pendentes)  
- [x] Edição de Tarefas  
- [x] Marcação de Conclusão/Incompletude  
- [x] Exclusão de Tarefas  
- [x] Autenticação de Usuário (*se implementada*)  
- [x] Filtros e Ordenação (*se implementados*)

## Tecnologias Utilizadas

- **Frontend:**
  - React  
  - Tailwind CSS

- **Backend:**
  - Java com Spring Boot – API REST para gerenciamento de tarefas  
  - MySQL – banco de dados relacional

- **Outras:**
  - Git/GitHub – versionamento e controle colaborativo  
  - Postman – testes de API durante o desenvolvimento

## Como Configurar e Executar o Projeto

### 1. Pré-requisitos

- Node.js (versão recomendada: 14+ ou conforme `package.json`)  
- Java 17+ (ou a versão indicada no projeto)  
- MySQL (ou outro RDBMS, se configurado)  
- Git  

### 2. Clonar o repositório

```bash
git clone https://github.com/RafaelScarpelli/Code-Challenge-NextAge.git
cd Code-Challenge-NextAge
```

### 3. Configurar e executar o backend

```bash
cd backend
# (Configure o arquivo application.properties ou application.yml conforme necessário)

# Executar com Maven (wrapper)
./mvnw spring-boot:run
```

### 4. Configurar o banco de dados

- Crie o banco no MySQL, por exemplo `todo_db`.
- Atualize o arquivo de configuração (ex: `application.properties`) com suas credenciais MySQL, nome do banco e configurações de conexão.

### 5. Configurar e executar o frontend

```bash
cd ../frontend
npm install
npm start
```

- Acesse o frontend tipicamente em `http://localhost:3000`
- O backend provavelmente estará em `http://localhost:8080`; ajuste URLs no frontend conforme necessário.

## Decisões de Design e Arquitetura

- **Frontend:** React + Tailwind CSS foi escolhido por oferecer desenvolvimento ágil e UI responsiva com estilo limpo e moderno.
- **Backend:** Spring Boot proporciona uma base robusta para APIs REST. A utilização de MySQL permite persistência consistente de dados.
- **Estrutura do Projeto:**  
  - Backend segue uma arquitetura em camadas (Controller, Service, Repository, Model).  
  - Frontend organizado em componentes React reutilizáveis e modularidade por funcionalidades.
- **Persistência de Dados:** Utilização de JPA para facilitar operações com o banco de dados em camadas de repositório.
- **Desafios Enfrentados:**  
  - Configuração de CORS para comunicação entre React e Spring Boot.  
  - Validação de formulários e feedbacks no frontend.  
  - Manutenção de estado local e reatividade em React conforme tarefas são criadas ou atualizadas.