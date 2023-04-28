package org.example;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Sender {
    private final static String QUEUE_NAME = "hello";
    private final static String EXCHANGER_NAME = "hello_exchanger";

    public static void main(String[] args) throws Exception {

        try (Scanner sc = new Scanner(System.in)) {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");

            while (true) {
                System.out.println("Напишите статью: ");
                String article = sc.nextLine();
                if (article.equals("exit")) {
                    return;
                }
                String routingKey = article.substring(0, article.indexOf(" ")).trim();
                article = article.substring(article.indexOf(" ")).trim();

                try (Connection connection = factory.newConnection();
                     Channel channel = connection.createChannel()) {
                    channel.exchangeDeclare(EXCHANGER_NAME, BuiltinExchangeType.TOPIC);
//                    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//                    channel.queueBind(QUEUE_NAME, EXCHANGER_NAME, routingKey);

                    channel.basicPublish(EXCHANGER_NAME, routingKey, null, article.getBytes("UTF-8"));
                    System.out.println(" [x] Sent: routingKey: " + routingKey + "; '" + article + "'");
                }
            }
        }


    }
}