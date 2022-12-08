package pl.great.waw.shop.orderms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.waw.shop.orderms.controller.OrderNotificator;
import pl.great.waw.shop.orderms.controller.views.OrderView;
import pl.great.waw.shop.orderms.domain.Order;
import pl.great.waw.shop.orderms.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderNotificator orderNotificator;

    public OrderView add(OrderView orderView) throws JsonProcessingException {
        Order saved = orderRepository.save(Order.builder().
                id(UUID.randomUUID().toString())
                .user(orderView.getUser())
                .created(LocalDateTime.now())
                .build());

        OrderView build = OrderView.builder()
                .user(saved.getUser())
                .created(saved.getCreated())
                .build();

        orderNotificator.sendOrder(build);
        return build;
    }
}
