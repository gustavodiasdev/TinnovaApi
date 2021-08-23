# API Tinnova Test

### Sobre o projeto:
Projeto criado conforme especificado pela Tinnova para criação das APIs em Java/Spring.

### Como o projeto está configurado:
 O projeto está estruturado nos seguintes pacotes(packages):

Pacotes:
- config (classes de configurações)
- controllers (classes de controle para expor as APIs)
- services (classes de regras negociais)
- models (classes de modelo, entidades, enuns, dtos ...)
- repositories (classe de tratamento com o banco de dados)

O projeto está configurado para rodar com DB H2(local), assim que subir a aplicação será criado as tabelas do pacote 
model que estão anotadas com a @Entity, nas configurações está sendo usado o ddl-auto setado update onde
vai ser verificado se já existe tal tabela, caso positivo irá apenas atualizar se houver mudanças e caso negativo
irá criar a nova tabela na base de dados.

### Como subir o projeto:
Faça o clone do repositório em alguma pasta, após isso acesse a pasta e digite:

```
mvn clean install
```
![img.png](data/images/img.png)

Após o build execute o seguinte comando:

```
java -jar ./target/tinnova-0.0.1-SNAPSHOT.jar
```
![img.png](data/images/img2.png)


Se tudo ocorreu bem, o projeto subiu na porta 8081, que foi configurado no application.properties
![img.png](data/images/swagger.png)


Prontinho! Só testar agora e ver os erros acontecerem. rsrs

![img.png](data/images/vuala.png)
