  # language: pt

  Funcionalidade: conta usuário  token e autorizacao via API

    Cenário: Buscar adicionar usuario
      Dado que eu acesso a API de usuários
      Quando eu consulto o username
      Então o status deve ser 201


    Cenário: gerar token de acesso usuario
      Dado que eu acesso a API de gerar token
      Quando eu consulto o token gerado
      Então o status devera ser 200


