package pl.great.waw.shop.orderms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.great.waw.shop.orderms.controller.views.OrderView;

@Component
public class OrderNotificator {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @RabbitListener(queues = "ORDER_IN")
//    //TODO INTEGRATE with SHOP
//    public void readOrder() {
//
//    }

    public void sendOrder(OrderView orderView) throws JsonProcessingException {
        rabbitTemplate.convertAndSend("ORDER_OUT", objectMapper.writeValueAsString(orderView));
    }
}
