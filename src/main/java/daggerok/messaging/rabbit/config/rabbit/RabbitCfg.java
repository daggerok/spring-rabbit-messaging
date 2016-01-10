package daggerok.messaging.rabbit.config.rabbit;

import daggerok.messaging.rabbit.config.messaging.Receiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitCfg {
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(Queue queue
            , ConnectionFactory rabbitCnnectionFactory, MessageListener messageListener) {

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

        container.setQueueNames(queue.getName());
        container.setMessageListener(messageListener);
        container.setConnectionFactory(rabbitCnnectionFactory);
        return container;
    }

    @Bean
    Queue queue(String channel) {
        return new Queue(channel, false);
    }

    @Bean
    TopicExchange topicExchange(Queue queue) {
        return new TopicExchange(queue.getName());
    }

    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(queue.getName());
    }

    @Bean
    public MessageListener messageListener(Receiver receiver) {
        return new MessageListenerAdapter(receiver, receiver.defaultListenerMethod());
    }
}