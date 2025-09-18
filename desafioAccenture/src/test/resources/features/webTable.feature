 # language: pt


 Funcionalidade: Gerenciar registros na Web Table

   Cenário: Adicionar, editar e deletar registro
     Dado que estou na página Web Tables
     Quando eu clico no botão Add
     E preencho o formulário com os dados:
       | First Name | Last Name | Email              | Age | Salary | Department |
       | Patricia   | Silva     | paty@example.com   | 30  | 5000   | QA         |
     E clico em Submit
     Então o registro "Patricia" deve aparecer na tabela
     Quando eu edito o registro "Patricia" para o departamento "Automação"
     Então o registro "Patricia" deve conter o departamento "Automação"
     Quando eu deleto o registro "Patricia"
     Então o registro "Patricia" não deve mais estar na tabela