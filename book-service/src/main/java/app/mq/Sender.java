package app.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender
{
    private RabbitTemplate rabbitTemplate;
    @Value("${mq.queue}")
    private String queueName;
    public Sender(RabbitTemplate rabbitTemplate)
    {
        this.rabbitTemplate=rabbitTemplate;
    }
    public void send(Message message)
    {
        rabbitTemplate.convertAndSend(queueName,message);
    }
}