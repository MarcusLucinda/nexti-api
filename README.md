# nexti-api

- [Configuração](#configuração)
- [Execução](#execução)
- [Cliente](#cliente)
- [Produto](#produto)
- [Pedido](#pedido)


## Configuração

Na pasta /package estão contidos o arquivo executável .jar e o arquivo de configurações "application.properties", no qual deve-se inserir as configurações do banco de dados PostgreSQL
Por exemplo:

```
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.datasource.url= jdbc:postgresql://localhost:5050/nome_db
spring.datasource.username=user
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

O banco de dados já deve estar criado antes da execução da aplicação.

## Execução

O arquivo desafio-0.0.1-SNAPSHOT.jar deve ser executado, o container irá iniciar em localhost:8080/. Pode-se iniciar com o seguinte comando no terminal:
```
$ java -jar desafio-0.0.1-SNAPSHOT.jar
```
A API pode ser testada em plataformas de desenvolvimento como o Postman. O corpo das requisições deve estam no formato JSON


