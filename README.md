Olá, sou Renan Admiral (renanadmiral@gmail.com) e bem vindo ao meu projeto para o processo seletivo da BHUT!

A seguir está anexo a modelagem do sistema proposto, onde a arquitetura baseia-se em Microsserviços.

![image](https://user-images.githubusercontent.com/49658142/182071175-dfaa6d71-5d9a-443f-9aef-0a6e1550ccf7.png)

Legenda:

1- "External API" -> API externa fornecida pela companhia BHUT, onde o serviço permite registrar e consultar carros no banco de dados.

2- "Car Microservice" -> API própria, possui a função de terceirizar a lista de carros da API externa. Além disso, também envia um carro novo para uma fila Kafka para ser processado e enfim, registrado.

3- "Kafka Server" -> Servidor Apache Kafka para sistema de fila de mensagens. Apenas 1 tópico foi criado, com o fim de gerenciar uma fila de registro de carros novos.

4- "Car Registration Microservice" -> API própria, possui a função de receber mensagens da fila Kafka para processar e enviar um carro novo para a API externa. Além disso, também envia um registro Log para um banco de dados MongoDB.

4- "MongoDB New Cars Log"
