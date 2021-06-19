# nexti-api

- [Configuração](#configuração)
- [Execução](#execução)
- [Cliente](#cliente)
- [Produto](#produto)
- [Pedido](#pedido)


## Configuração

Na pasta /package estão contidos o arquivo executável .jar e o arquivo de configurações "application.properties", no qual deve-se inserir as configurações do banco de dados PostgreSQL.
Por exemplo:

```
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.datasource.url= jdbc:postgresql://localhost:5050/nome_db
spring.datasource.username=user
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

O banco de dados já deve estar criado antes da execução da aplicação.

No projeto foi utilizado o "Repository Pattern", onde todas as queries ao banco estão nas classes que utilizam a JpaRepository, presentes no pacote "repositories". As regras de negócio estão implementadas nas classes "Service". 

## Execução

O arquivo desafio-0.0.1-SNAPSHOT.jar deve ser executado, o container irá iniciar em localhost:8080/. Pode-se iniciar com o seguinte comando no terminal:
```
$ java -jar desafio-0.0.1-SNAPSHOT.jar
```
A API pode ser testada em plataformas de desenvolvimento como o Postman. O corpo das requisições deve estar no formato JSON.


## Cliente

### Incluir
Para inserir um cliente no banco deve-se passar os parâmetros nome, cpf e data de nascimento na requisição POST em /cliente/incluir.
```json
{
    "nome": "Gabriela",
    "cpf": "788.986.999-21",
    "dataNascimento": "14/04/1990"
}
```

### Excluir
Para excluir o registro de cliente utiliza-se a requisição DELETE em /cliente/excluir passando o parâmetro ID.
```json
{
    "id": 1
}
```

### Atualizar
Para realizar uma atualização nos dados do cliente utiliza-se a requisição PUT em /cliente/atualizar passando o ID e os dados a serem modificados.
```json
{
    "id": 2,
    "cpf": "788.986.959-21"
}
```

### Listar
Para listar basta realizar a requisição GET em /cliente/listar


## Produto

### Incluir
Para incluir um produto no banco utiliza-se a requisição POST em /produto/incluir passando os parâmetros nome, descrição, preço e quantidade.
```json
{
    "nome": "Celular Samsung",
    "descricao": "64 GB",
    "preco": 1650.00,
    "qtd": 15
}
```

### Excluir
Para excluir um produto utiliza-se a requisição DELETE em /produto/excluir passando o ID.
```json
{
    "id": 4
}
```

### Atualizar
Para atualizar os dados de um produto utiliza-se a requisição PUT em /produto/atualizar passando o ID e os dados modificados.
```json
{
    "id": 2,
    "preco": 460.00
}
```

### Listar
Para listar os produtos utiliza-se a requisição GET em /produto/listar.


## Pedido

### Incluir
Para registrar um pedido utiliza-se a requisição POST em /pedido/incluir passando os parâmetros ID do cliente, data da compra e a lista de IDs dos produtos.
```json
{
    "cliente": {"id": 2},
    "dataCompra": "18/06/2021",
    "produtos": [{"id": 3}, {"id": 7}]
}
```

### Excluir
Para excluir um pedido utiliza-se a requisição DELETE em /pedido/excluir passando o ID do pedido.
```json
{
    "id": 2
}
```

### Atualizar
Para atualizar um dado do pedido que não esteja relacionado a seus produtos utiliza-se a requisição PUT em /pedido/atualizar passando o ID do pedido e os dados atualizados.
```json
{
    "id": 1,
    "cliente": {"id": 3}
}
```

### Listar
Para listar os pedidos utiliza-se a requisição GET em pedido/listar.

### Adicionar produtos
Para adicionar produtos a um pedido utiliza-se a requisição PUT em /pedido/add-produtos passando o ID do pedido e a lista de produtos a serem adicionados.
```json
{
    "id": 8,
    "produtos": [{"id": 1}, {"id": 4}]
}
```

### Remover produtos
Para excluir produtos de um pedido utiliza-se a requisição DELETE em /pedido/remover-produtos passando o ID do pedido e a lista de produtos a serem removidos.
```json
{
    "id": 5,
    "produtos": [{"id": 9}, {"id": 11}]
}
```

