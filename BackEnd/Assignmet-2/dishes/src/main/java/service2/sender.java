package service2;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class sender {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] argv) throws Exception {
        //Connect to queue
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); // hostname
        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}

