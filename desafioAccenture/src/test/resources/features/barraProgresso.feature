 # language: pt

 Funcionalidade: Validar funcionamento da barra de progresso

   Cenário: Iniciar, pausar antes dos 25%, retomar e resetar
     Dado que estou na página Progress Bar
     Quando eu clico no botão Start
     E eu paro a barra de progresso antes de atingir 25%
     Então o valor da barra deve ser menor ou igual a 25%
     Quando eu clico no botão Start novamente
     E aguardo até que a barra atinja 100%
     Então a barra deve ser resetada para 0%