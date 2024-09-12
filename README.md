# Desafio San Giorgio

O desafio proposto consistia em desenvolver uma funcionalidade que recebe um objeto contendo o código do vendedor e uma lista de pagamentos realizados. Cada pagamento é identificado pelo código da cobrança a que ele se refere. O sistema deve validar se o vendedor e o código da cobrança existem na base de dados. Além disso, ele deve verificar se o pagamento é parcial, total ou excedente em comparação com o valor original cobrado. Para cada situação de pagamento, o sistema deve enviar o objeto para uma fila SQS (Simple Queue Service) distinta e retornar o mesmo objeto recebido com a informação do status de pagamento preenchida.

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

## 📦 Execuando

Para executar o projeto você precisará ter o Docker em sua máquina e pode ser útil ter o aws-cli.
 - Faça o clone do projeto em uma pasta de sua preferência
 - Por linha de comando entre na pasta raiz do projeto e execute <b>docker-compose up --build</b>
 - Após isso o serviço de orquestração será executado no <b>localhost:8080</b>, foi disponibilizado também um pgAdmin no <b>localhost:8083</b>, email admin@mail.com e senha admin, todas as tabelas e filas também serão criadas
 - Na pasta collection está um arquivo que pode ser importado no <b>Postman</b> ou <b>Insomnia</b>
 - Caso possua o aws-cli após executar a collection de sucesso, conseguirá olhar o conteúdo das filas com os comandos abaixo

 aws sqs receive-message --queue-url http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/pagamento-total --endpoint-url=http://localhost:4566
 
 aws sqs receive-message --queue-url http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/pagamento-parcial --endpoint-url=http://localhost:4566
 
 aws sqs receive-message --queue-url http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/pagamento-excedente --endpoint-url=http://localhost:4566


## 🛠️ Construção

Para construir esse projeto utilizei:

* [Spring Boot](https://docs.spring.io/spring-boot/index.html)
* [Maven](https://maven.apache.org/)
* [LocalStack](https://docs.localstack.cloud/overview/)
* [Postgres](https://www.postgresql.org/docs/)
* [Docker](https://docs.docker.com/)

Optei por uma arquitetura de microsserviços, dividindo em serviço de Pagamento, Vendedor e um Orquestrador responsável por toda orquestração das chamdas. Imaginando um cenário onde existissem cadastro de vendedor/pagamento, consultas e outras funcionalidades para cada um, preferi resolver o desafio com essa arquitetura.
Para o código, optei por priorizar Clean Architecture nos serviços de Vendedor e Pagamento.

<i>Obs. Gostaria de ter implementado Autenticação com JWT, mas acabou que não deu tempo</i>


---
por [Arthur Azevedo](https://www.linkedin.com/in/arthur-azev%C3%AAdo/) ⌨️