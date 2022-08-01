Olá, sou Renan Admiral (renanadmiral@gmail.com) e bem vindo ao meu projeto para o processo seletivo da BHUT!

A seguir está anexo a modelagem do sistema proposto, onde a arquitetura baseia-se em Microsserviços.

![image](https://user-images.githubusercontent.com/49658142/182177041-6e9cdbd9-3e5c-4e3b-859e-393e67371c63.png)

Legenda:

1- "External API" -> API externa fornecida pela companhia BHUT, onde o serviço permite registrar e consultar carros no banco de dados.

2- "Car Microservice" -> API própria, possui a função de terceirizar a lista de carros da API externa. Além disso, também envia um carro novo para uma fila Kafka para ser processado e enfim, registrado.

3- "Kafka Server" -> Servidor Apache Kafka para sistema de fila de mensagens. Apenas 1 tópico foi criado, com o fim de gerenciar uma fila de registro de carros novos.

4- "Car Registration Microservice" -> API própria, possui a função de receber mensagens da fila Kafka para processar e enviar um carro novo para a API externa. Além disso, também envia um registro Log para um banco de dados MongoDB.

4- "MongoDB New Cars Log" -> Banco de dados NoSQL MongoDB para armazenar logs de novos carros registrados.

5- "Webhook POST (Console log)" -> Webhook configurado entre as duas API's próprias para sinalizar casos de sucesso e falha durante o registro de um novo carro.

6- "Gateway" -> API de gateway apenas com o objetivo de centralizar os endpoints externos e proteger os endpoints internos.

-- INSTRUÇÕES DE EXECUÇÃO DO PROJETO --

-> Método 1 (Recomendado):

1- Requisito: Possua ou baixe o [Docker](https://docs.docker.com/desktop/install/windows-install/)

2- Faça o clone do projeto, ou baixe o arquivo ZIP do projeto e extraia em uma pasta desejada.

3- Abra o prompt de comando na pasta do projeto e execute o seguinte comando: "docker-compose up" sem as aspas. Faça assim como na imagem abaixo.

![image](https://user-images.githubusercontent.com/49658142/182187826-d3d6fe63-e21d-4f07-9cdc-c2c57d4f6280.png)

4- Após o término dowload das imagens, aguarde o docker inicializar todos os contêineres. (Até todas as mensagens do prompt pararem de ser exibidas)

5- Utilize o [Postman](https://www.postman.com/downloads/) ou outra ferramenta de envio de requisições HTTP para testar o projeto. (url da API: localhost:9000/api).

-> Método 2:

1- Faça o clone do projeto, ou baixe o arquivo ZIP do projeto e extraia em uma pasta desejada.

2- Instale o [Apache Kafka](https://kafka.apache.org/downloads), execute na porta 9092 e o [MongoDB](https://www.mongodb.com/try/download/community) na porta 27017.

3- abra todas as pastas do projeto com uma IDE de sua preferência e execute todas as API's

4- 5- Utilize o [Postman](https://www.postman.com/downloads/) ou outra ferramenta de envio de requisições HTTP para testar o projeto. (url da API: localhost:9000/api).

-- DOCUMENTAÇÃO DOS ENDPOINTS --

GET localhost:9000/api/listCars -> Lista todos os carros provenientes da API externa.

GET localhost:9000/api/logs -> Lista todos os logs de registro de carros provenientes da API de registro de carros.

POST localhost:9000/api/createCar -> Cria um novo registro de carro na API externa. O corpo da requisição deve ser enviado em JSON com os seguintes parâmetros de dados:

![image](https://user-images.githubusercontent.com/49658142/182190529-373a5aa3-7a89-472e-84f4-d9f899837cef.png)




