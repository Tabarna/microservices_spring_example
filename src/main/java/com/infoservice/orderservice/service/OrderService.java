package com.infoservice.orderservice.service;

import com.infoservice.orderservice.common.Payment;
import com.infoservice.orderservice.common.TransactionRequest;
import com.infoservice.orderservice.common.TransactionResponse;
import com.infoservice.orderservice.entity.Order;
import com.infoservice.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request){
        String response="";
        Order order=request.getOrder();
        Payment payment=request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

      Payment paymentResponse= restTemplate.postForObject("localhost:8081/payment/doPayment",payment,Payment.class);
        response = paymentResponse.getPaymentStatus().equals("success")?"payment success":"there is failure in payment api, order added to card";
         orderRepository.save(order);
         return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}