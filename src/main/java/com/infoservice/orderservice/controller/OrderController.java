package com.infoservice.orderservice.controller;

import com.infoservice.orderservice.common.Payment;
import com.infoservice.orderservice.common.TransactionRequest;
import com.infoservice.orderservice.common.TransactionResponse;
import com.infoservice.orderservice.entity.Order;
import com.infoservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){
//        Order order=request.getOrder();
//        Payment payment=request.getPayment();
//        payment.setOrderId(order.getId());
//        payment.setAmount(order.getPrice());
     //  return orderService.saveOrder(order);
        return orderService.saveOrder(request);
    }
}
