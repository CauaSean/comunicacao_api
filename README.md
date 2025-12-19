# comunicacao_api

## Endpoints da Aplicação

### 👤 Usuários
- GET /api/usuarios  
  Retorna a lista de usuários cadastrados.

- POST /api/usuarios  
  Cadastra um novo usuário.  
  DTO esperado:
    ````json
  {
    "nome": "string",
    "senha": "string"
  }
