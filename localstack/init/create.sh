#!/bin/bash
sleep 15

aws sqs create-queue --queue-name pagamento-total --endpoint-url=http://localhost:4566 --region us-east-1
aws sqs create-queue --queue-name pagamento-parcial --endpoint-url=http://localhost:4566 --region us-east-1
aws sqs create-queue --queue-name pagamento-excedente --endpoint-url=http://localhost:4566 --region us-east-1