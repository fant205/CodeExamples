package org.example;

import com.rabbitmq.client.*;

import java.util.Scanner;

public class Reciever {
    private final static String QUEUE_NAME = "hello";
    private final static String EXCHANGER_NAME = "hello_exchanger";


    public static void main(String[] args) throws Exception {

        String subject = null;
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("установите тему статьи командой set_topic: ");
                String article = sc.nextLine();
                if (!article.startsWith("set_topic")) {
                    continue;
                }
                if (article.equals("exit")) {
                    return;
                }
                subject = article.substring(article.indexOf(" ")).trim();
                break;
            }
        }

        final String routingKey = subject;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGER_NAME, BuiltinExchangeType.TOPIC);

        String queueName = channel.queueDeclare().getQueue();
        System.out.println("QUEUE NAME: " + queueName);

        channel.queueBind(queueName, EXCHANGER_NAME, routingKey);
        System.out.println(" [*] Waiting for messages with routing key (" + routingKey + "):");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");

        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });


    }
}