  # language: pt

Funcionalidade: Consultar livros disponíveis na API

Cenário: listar todos os livros disponíveis
Dado que eu acesso a API de livros
Quando eu realizo a consulta
Então a resposta deve conter a lista de livros


  Cenário: adicionar um livro com sucesso
    Dado que eu tenho um usuário autorizado
    Quando eu adiciono o livro com ISBN
    Então o status da resposta deve ser 201
