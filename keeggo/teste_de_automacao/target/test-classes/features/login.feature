# language: pt
Funcionalidade: Fazer Login de conta cadastrada
  
  Como usuário do site Advantage Shopping
  Quero realizar o login da minha conta
  Para realizar compras de produtos

@Step_6
  Cenario: Login com Sucesso
    Dado que acesso a tela de login do usuario
    Quando submeto o meu login com nome e senha
    Então devo ser redirecionado home page

@Step_7
  Cenario: Não informar email
    Dado que acesso a tela de login do usuario
    Quando submeto o meu login senha
    Então devo ver a mensagem de alerta "Username field is required"

@Step_8
  Cenario: Não informar senha
    Dado que acesso a tela de login do usuario
    Quando submeto o meu login nome
    Então devo ver a mensagem de alerta "Password field is required"
