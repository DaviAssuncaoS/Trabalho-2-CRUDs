# productsapp

<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>

Projeto para gerenciamento de produtos. Front: React/Next.js, Back: Java/SpringBoot.

# :hammer: Funcionalidades do projeto

- `Listagem de produtos`: Permite a listagem de todos os produtos previamente cadastrados.
- `Cadastro de novos produtos`: Permite o cadastro de um novo produto.

# ✔️ Técnicas e tecnologias utilizadas
## Backend
- ``Java 17``
- ``SpringBoot``
- ``PostgreSQL``
- ``Flyway``
- ``MapStruct``
- ``Lombok``
- ``Junit``

## Front
- ``React.js``
- ``Next.js``
- ``Tailwind css``

# Como rodar o projeto ?

## Backend

- `mvn clean install` Buildar projeto.
- `docker compose up` Para subir a base de dados.
- `mvn spring-boot:run` Rodar projeto.

## Frontend

- `npm install`
- `npm run dev`

# Deseja contribuir ?

Seguimos as orientações do GitFlow, portanto a criação das branches deve seguir o padrão abaixo:
Branches principais:

- `main/master`
- `staging`
- `develop`

A cada sprint de desenvolvimento, criamos novas branches de acordo com o padão abaixo:

- `feature\nome-da-feature`
- `bugfix\descricao`
- `hotfix\descricao`

Estas deverão ser mergeadas na **develop** e em após o desenvolvimento e entrega da release para a equipe de QA, faremos o merge para **staging**. Após a validação da equipe de QA, faremos a atualização da *master* e o sistema será atualizado em produção, seguindo a necessidade do negócio. 

## Padronização de código

### Backend
- Utilizar sempre a Response padrão. Conforme exemplo abaixo:
```
{
    "date": "2023-07-03T07:43:51.725391",
    "message": "Operação realizada produz violação de uma restrição na base de dados",
    "responseType": "ERROR",
    "codeStatus": 409,
    "reasonPhraseStatus": "Conflict",
    "data": {
        "code": "004-ERRO-RESTRICAO",
        "description": "Operação realizada produz violação de uma restrição na base de dados"
    }
}
```
- Garantir a cobertuda de testes unitários nas camadas de Serviço e Controle e em caso de integração com outros serviços criar pelo menos teste de contrato.
