# STAR WARS

## Problema
<p><h3>Buscador Star Wars<h3>
Um site especializado em Star Wars deseja construir uma aplicação para consulta de
informações relacionadas aos filmes da série. O desejo é que essa aplicação seja capaz de:
 - Realizar consultas por diferentes elementos (personagens, naves, planetas, filmes, etc)
 - Ao realizar uma consulta, baseado no que foi pesquisado a aplicação deve sugerir outros 3
itens relacionados. Por exemplo: ao pesquisar um personagem a aplicação deve, além de
retornar aquele personagem, apresentar outras 3 sugestões de personagens semelhantes
(da mesma espécie, ou do mesmo planeta, ou que viaja na mesma nave, etc)
 - Exibir relação com os termos mais buscados


## Tecnologias Utilizadas
- Java 14
- Spring Boot 2.4
- Spring MVC
- Spring Data JPA
- Hibernate
- WebClient 
- Maven 4.0.0
- Docker 19.03.12
- Swagger 2.9.2

## Tecnologia Necessária Para Rodar a Aplicação
- Docker instalado

## Como Executar
1. Primeiro baixe a imagem docker da aplicaçõa com o comando **docker pull josienevieira/apistarwars:latest** no seu terminal;
2. Nesta aplicação não será necessaŕio subir um container de banco pois está funcionando com banco em memória;
3. Para vizualizar a imagem que acabou de baixar basta executar o comando **docker images** e confirme o nome da imagem;
4. Execute a imagem baixada, a aplicação irá rodar na porta 8080, ou pode escolher outra, utilizando o comando: **docker run -it -p 8080:8080 josienevieira/apistarwars**

A aplicação comecará a subir e será posível ver o status pelo seu terminal.

Após subir a aplicação ela estará disponível em localhost/8080

## Como testar a Aplicação
A aplicação está com o swagger configurado, sendo possível acessar pelo endereço ***http://localhost:8080/swagger-ui.html*** no navegador.
É possível também utilizar os recursos disponíveis na API utilizando o swagger, basta clicar no ***Try It*** após clicar no endpoint desejado.
É possível também consumir a API atrvés de ferramentas como PostMan, basta acessa com a base url http://localhost:8080/api/, os demais paths podem ser vistos no swagger.

## Dificulades
- Pesquisar e aprender a uitlizar uma ferramenta para consumir uma API externa dentro do código;

## Melhorias
- Melhorar a cobertura de testes, foram desenvolvidos testes unitários para a maior parte das classes, mas não para todos os métodos;
  - Desenvolver outros níveis de testes além dos unitários;
- Utilizar do Docker-Compose para orquestrar a utilização dos Containers ao invés de fazer de forma manual;
- Implemnetar a busca pelos demais temas, pois foi implementada apenas a de people;
- Descobri por que o Webclient não estava recebendo um retorno correto quando a uri estava sem o "s" do "HTTPS";


## Aprendizados
- Aprendi mais sobre testes unitários com JUnit e Mockito;
- Aprendi a utilizar a Classe WebClient que faz part do Spring WebFlux para consumo de API;
 
