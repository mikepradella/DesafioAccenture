  # language: pt

Funcionalidade: Testar abertura de nova janela

Cenário: Validar nova janela com mensagem
Dado que estou na página Browser Windows
Quando eu clico no botão "New Window"
Então uma nova janela deve ser aberta com a mensagem "This is a sample page"
E eu fecho a nova janela