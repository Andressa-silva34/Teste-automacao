# language: pt
Funcionalidade: Cadastrar usuario
  
  Como usuário 
  Quero realizar meu cadastro no site Advantage Shopping
  Para realizar compras de produtos

  @Step_1
  Cenario: Cadastro campos obrigatorios
    Dado que acesso a tela de cadastro
    Quando submeto o meu cadastro com nome: "andressa", email: "andres@outlook.com", senha: "Pwd123" e senha de confirmacao: "Pwd123"
    Então devo ser redirecionado pagina incial

  @Step_2
  Cenario: Não informo o nome
    Dado que acesso a tela de cadastro
    Quando submeto o meu cadastro com email: "andressa@yahoo.com", senha: "Ags123" e senha de confirmacao: "Ags123"
    Então devo ver a mensagem "Username field is required"

  @Step_3
  Cenario: Não informo o email
    Dado que acesso a tela de cadastro
    Quando submeto o meu cadastro com nome: "andressa", senha: "Ags123" e senha de confirmacao: "Ags123"
    Então devo ver a mensagem "Email field is required"

  @Step_4
  Cenario: Não informo a senha
    Dado que acesso a tela de cadastro
    Quando submeto o meu cadastro com nome: "andressa" e email: "andressa@yahoo.com"
    Então devo ver a mensagem "Password field is required"

  @Step_5
  Cenario: Informe senhas divergentes
    Dado que acesso a tela de cadastro
    Quando submeto o meu cadastro com submeto o meu cadastro com nome: "andressa", email: "andressa@yahoo.com", senha: "Ags123" e senha de confirmacao: "Ags"
    Então devo ver a mensagem "Passwords do not match"
