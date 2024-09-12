docker-compose up --build
aws sqs list-queues --endpoint-url=http://localhost:4566 --region us-east-1
aws sqs receive-message --queue-url http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/pagamento-total --endpoint-url=http://localhost:4566
aws sqs receive-message --queue-url http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/pagamento-parcial --endpoint-url=http://localhost:4566
aws sqs receive-message --queue-url http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/pagamento-excedente --endpoint-url=http://localhost:4566