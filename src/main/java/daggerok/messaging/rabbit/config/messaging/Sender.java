package daggerok.messaging.rabbit.config.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class Sender {
    Logger logger = Logger.getLogger(Sender.class.getName());

    @Autowired RabbitTemplate rabbitTemplate;

    @Autowired String channel;

    public void send(String message) {
        logger.info("sending a message...");
        rabbitTemplate.convertAndSend(channel, String.format("content: %s", message));
    }
}