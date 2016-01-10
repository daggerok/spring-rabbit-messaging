package daggerok.messaging.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessagingRabbitApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessagingRabbitApplication.class, args)
                .registerShutdownHook();
    }
}