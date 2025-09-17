  # language: pt

Funcionalidade: Preencher formulário de prática

Cenário: Submeter formulário com dados aleatórios
Dado que estou na página Practice Form
Quando preencho todos os campos com dados válidos
E faço upload de um arquivo .txt
E submeto o formulário
Então o popup de confirmação deve ser exibido
E fecho o popup