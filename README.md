<img src="https://storage.googleapis.com/golden-wind/experts-club/capa-github.svg" />

# Spring Security :  autenticação via JWT  com  refresh token



Nesta aula você irá aprender a implementar autenticação de usuários via token JWT e como implementar a geração e validação de refresh token em uma aplicação Spring.


[slides](https://github.com/rocketseat-experts-club/spring-security-autenticacao-via-jwt-com-refresh-token-2022-04-23/blob/main/Spring%20Security%20_%20%20autenticac%CC%A7a%CC%83o%20via%20JWT%20%20com%20%20refresh%20token%20%20(1).pdf)

Tecnologias utilizadas:


- Java 11
- Spring Web
- Spring Data
- h2 Database
- Spring Security
- bCrypt
- JWT

## Expert

| [<img src="https://avatars.githubusercontent.com/u/32311268?s=460&u=88788249fc35ea2f59f583dae36d674d34896839&v=4" width="75px;"/>](https://github.com/Kamilahsantos) |
| :-: |
|[Kamila Santos](https://github.com/Kamilahsantos)|

## Requisições feitas em aula:

- Criação de usuário:

`````
curl --location --request POST 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "userec",
    "password": "senhakamilaec"

}'

``````
- Login

`````
curl --location --request POST 'http://localhost:8080/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "userec",
    "password": "senhakamilaec"

}'
`````

- Criação de estudante

``````
curl --location --request POST 'http://localhost:8080/student' \
--header 'Authorization: Bearer SEUTOKENJWTAQUI' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "estudante que esta vendo a aula ",
    "stack": "java e javascript",
    "yearsExperience":10 
}'

``````

- Geração de refresh token

``````
curl --location --request POST 'http://localhost:8080/refreshtoken' \
--header 'Content-Type: application/json' \
--data-raw '{
   "refreshToken": "REFRESHTOKENAQUI"
}'


