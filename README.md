# ProjectCadastro
API para cadastro de usuarios e campanhas

### [Pre-requisitos](#pre-requisitos)  
### [Estrutura do Projeto](#estrutura-do-projeto)  
### [Tecnologias e referências](#tecnologias-e-referencias)  
### [Passo-a-passo](#passo-a-passo-para-compilação-e-execução-da-aplicação)  
### [Como Testar](#como-testar)
### [(TODO) O que falta](#o-que-falta-fazer-todo)  

## Pre-requisitos
* JDK 1.8+
* MySQL 5.6+
* Gradle 2.3+
* Maven 3.0+  

## Estrutura do Projeto
O Projeto está estruturado para prover uma API para o controle de cadastro (CRUD) de usuarios e campanhas.

Os endpoints disponiveis no projeto hoje são:
- rest-user: metodos para o controle do cadastro de usuarios
- rest-campanhas: metodos para controle do cadastro de campanhas
- rest-time: metodos para o controle do cadastro de times
- rest-campanhas-usuarios: metodos para o controle do cadastro das campanhas e usuarios vinculados

Para tal, seguiu-se a especificação para os métodos HTTP como segue:

**POST** - para criação de novos cadastros
Disponivel nos endpoints: rest-user, rest-campanhas, rest-campanhas-usuarios, rest-time

**PUT** - para atualização de cadastros
Disponivel nos endpoints: rest-user, rest-campanhas

**GET** - para consulta de cadastros
Disponivel nos endpoints: rest-user, rest-campanhas, rest-campanhas-usuarios, rest-time

**DELETE** - para exclusão de cadastros
Disponivel nos endpoints: rest-user, rest-campanhas, rest-campanhas-usuarios  

## Tecnologias e Referencias
Este projeto foi desenvolvido com o framework Spring Boot e Spring Data, os quais podem ser encontrados nos links a seguir:

<https://spring.io/guides/gs/accessing-data-mysql/>  
<https://spring.io/guides/gs/rest-service/>  
<https://spring.io/guides/gs/accessing-data-rest/>  

## Passo-a-passo para compilação e execução da aplicação
1) Instalar e/ou atualizar os frameworks e sistemas informados no itens Pre-requisitos

2) Baixar o codigo fonte disponibilizado no Github

3) Rodar o script mysql.sql na pasta src/main/resources para criar a base de dados e as tabelas.  
WARNING: atualizar o arquivo application.properties da pasta src/main/resouser antes de rodar o script!

4) Executar o comando para realizar o build da aplicação: gradle build

5) Executar o comando para executar a aplicação: java -jar build/libs/rest-cad-usuarios-campanhas-1.0.0.jar

## Como Testar
Para realizar o teste, pode ser usado o _curl_ do linux ou outra ferramenta para o envio de JSON via métodos HTTP.

Abaixo exemplos para criar um novo usuário com o método POST e consultar com o método GET

curl -i -X POST -H "Content-Type:application/json" -d "{  \"nomeCompleto\" : \"Bilbo Baggins\",  \"email\" : \"bilbobaggins@gmail.com\", \"idTimeCoracao\" : \"1\", \"dataNascimento\" : \"1985-07-23\"   }" http://localhost:8080/rest-user/createNewUser  

curl -i -X GET http://localhost:8080/rest-user/getUserById/1  

## O que falta fazer (TODO)
- Criar uma melhor maneira para a consulta dos cadastros
- Implementar casos de teste
- Implementar tratamento de exceções e logs
- Logica para criação de campanhas unicas
