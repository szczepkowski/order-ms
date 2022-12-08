package pl.great.waw.shop.orderms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.great.waw.shop.orderms.controller.views.OrderView;
import pl.great.waw.shop.orderms.service.OrderService;

@RestController
@RequestMapping("/orders")
@Profile("test")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderView post(@RequestBody OrderView orderView) throws JsonProcessingException {
        return orderService.add(orderView);
    }
}
