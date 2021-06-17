# language: pt
# encoding : utf-8

Funcionalidade: Preencher formulario Tricentis

	
Cenário: Acessar formulário e preencher as abas
	Dado que estou no site "http://sampleapp.tricentis.com/101/app.php"
	Quando preencho todos os campos
	E clico em Send
	Então deve ser exibida a mensagem "Sending e-mail success!"
	