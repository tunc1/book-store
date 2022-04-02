package app.mq;

import app.service.StockService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Listener
{
    private StockService stockService;
    public Listener(StockService stockService)
    {
        this.stockService=stockService;
    }
    @RabbitListener(queues="${mq.queue}")
    public void listen(@Payload Message message)
    {
        if(message.getEntity()==Message.BOOK)
            stockService.deleteByBookId(message.getId());
        else if(message.getEntity()==Message.INVENTORY)
            stockService.deleteByInventoryId(message.getId());
    }
}