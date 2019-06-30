# To Do List Project
Projeto com CRUD desenvolvido com JavaServer Faces(Jsf), Spring Boot, Spring Data JPA,MySql, JPA, PrimeFaces, 
Bootstrap e publicado no Heroku com o PostgreSql.

--Link da Aplicação no Heroku: https://hudson-to-do-list.herokuapp.com

Para a execução local do projeto, basta clonar na sua máquina, use uma IDE de desenvolvimento configurado para projetos Spring, 
então navegue até src/main/resources/application.properties, então basta comentar a configuração do banco de dados no HEROKU por 
um banco local, neste mesmo arquivo voce pode encontrar as configurações locais para MySQL, utilizando o MySql do XAMPP, substitua 
as credenciais e crie um banco chamado "esig".

-- Link do XAMPP: https://www.apachefriends.org/pt_br/index.html
-- Link Eclipse Spring Tools 4: https://spring.io/tools

Após iniciada a aplicaçã, basta acessar localhost:3005/.
O projeto oferece uma ApiRest para acesso aos recursos: basta acessar os recursos GET e POST acrescentando "/item", e para DELETE "/item/{id}".
