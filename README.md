# Estoque API

API REST para controle de estoque com alerta de quantidade mínima, desenvolvida com Spring Boot.

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- Maven

## Endpoints

| Método | Rota                     | Descrição                          |
|--------|---------------------------|-------------------------------------|
| POST   | /itens                   | Cria um novo item                   |
| GET    | /itens                   | Lista todos os itens                |
| GET    | /itens/{id}               | Busca item por id                   |
| PUT    | /itens/{id}               | Atualiza um item                    |
| DELETE | /itens/{id}               | Remove um item                      |
| GET    | /itens/alerta-estoque     | Lista itens com quantidade abaixo do mínimo |

## Como rodar

\`\`\`bash
./mvnw spring-boot:run
\`\`\`

A API sobe em `http://localhost:8080`.