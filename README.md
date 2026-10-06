# 🏗️ Castro Materiais

API REST em Spring Boot para gestão de uma loja de materiais de construção: clientes, materiais (estoque), pedidos, itens de pedido, pagamentos e usuários com login.

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.16-brightgreen?logo=springboot)
![Maven](https://img.shields.io/badge/Build-Maven-blue?logo=apachemaven)

## 📋 Índice
- [Tecnologias](#-tecnologias)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Como rodar](#️-como-rodar)
- [Endpoints da API](#-endpoints-da-api)
- [Avisos conhecidos](#️-avisos-conhecidos)

## 🚀 Tecnologias
- Java 21
- Spring Boot 3.5.16
- Spring Data JPA / Hibernate
- H2 (banco em memória, perfil padrão/dev)
- MySQL (perfil `prod`)
- Maven (via `mvnw`)

## 📁 Estrutura do projeto

```
src/main/java/com/castromateriais/castro_materiais/
├── controller/    # Endpoints REST
├── service/       # Regras de negócio
├── model/         # Entidades JPA
├── Repository/    # Interfaces JpaRepository
└── config/        # Configuração (CORS, etc.)
```

## ▶️ Como rodar

### Ambiente de desenvolvimento (H2 em memória)

```bash
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080` usando um banco H2 em memória (dados são perdidos a cada reinício). O console do H2 fica disponível em `/h2-console`.

Na primeira subida, um usuário admin padrão é criado automaticamente:
- **email:** `admin@castro.com`
- **senha:** `admin123`

### Ambiente de produção (MySQL)

Defina as variáveis de ambiente e rode com o perfil `prod`:

```bash
export MYSQLHOST=...
export MYSQLPORT=...
export MYSQLDATABASE=...
export MYSQLUSER=...
export MYSQLPASSWORD=...

./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

### Testes

```bash
./mvnw test
```

## 📡 Endpoints da API

### Clientes — `/api/clientes`

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/api/clientes` | Lista todos os clientes |
| GET | `/api/clientes/{id}` | Busca cliente por id |
| POST | `/api/clientes` | Cria cliente |
| PUT | `/api/clientes/{id}` | Atualiza cliente |
| DELETE | `/api/clientes/{id}` | Remove cliente |

### Materiais — `/api/materiais`

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/api/materiais` | Lista todos os materiais |
| GET | `/api/materiais/{id}` | Busca material por id |
| POST | `/api/materiais` | Cria material |
| PUT | `/api/materiais/{id}` | Atualiza material |
| DELETE | `/api/materiais/{id}` | Remove material |

### Pedidos — `/api/pedidos`

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/api/pedidos` | Lista todos os pedidos |
| GET | `/api/pedidos/{id}` | Busca pedido por id |
| POST | `/api/pedidos` | Cria pedido |
| PUT | `/api/pedidos/{id}` | Atualiza pedido |
| DELETE | `/api/pedidos/{id}` | Remove pedido |

### Itens de pedido — `/api/itens-pedido`

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/api/itens-pedido` | Lista todos os itens |
| GET | `/api/itens-pedido/{id}` | Busca item por id |
| POST | `/api/itens-pedido` | Cria item de pedido |
| PUT | `/api/itens-pedido/{id}` | Atualiza item de pedido |
| DELETE | `/api/itens-pedido/{id}` | Remove item de pedido |

### Pagamentos — `/api/pagamentos`

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/api/pagamentos` | Lista todos os pagamentos |
| GET | `/api/pagamentos/{id}` | Busca pagamento por id |
| POST | `/api/pagamentos` | Cria pagamento |
| PUT | `/api/pagamentos/{id}` | Atualiza pagamento |
| DELETE | `/api/pagamentos/{id}` | Remove pagamento |

### Usuários — `/api/usuarios`

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/api/usuarios` | Lista todos os usuários |
| GET | `/api/usuarios/{id}` | Busca usuário por id |
| POST | `/api/usuarios` | Cria usuário |
| PUT | `/api/usuarios/{id}` | Atualiza usuário |
| DELETE | `/api/usuarios/{id}` | Remove usuário |
| POST | `/api/usuarios/login` | Autentica (email + senha), retorna 401 se inválido |

## ⚠️ Avisos conhecidos

- Autenticação é simples (sem hash de senha, sem tokens/sessão) — não recomendado para produção sem revisão de segurança.
- CORS liberado para qualquer origem (`allowedOriginPatterns("*")`) em todas as rotas `/api/**`.
- Sem controle automático de estoque ao registrar itens de pedido.

---

Feito com Spring Boot ☕
