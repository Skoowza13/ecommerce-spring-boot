package com.ecom.app.ws.controllers;

import com.ecom.app.ws.entities.PaymentEntity;
import com.ecom.app.ws.requests.OrderRequest;
import com.ecom.app.ws.responses.OrderResponse;
import com.ecom.app.ws.services.OrderService;
import com.ecom.app.ws.shared.dto.OrderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    OrderService orderService;

      @PostMapping("/create")
      public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest, Principal principal, @ModelAttribute("paymentId") PaymentEntity payment){

          ModelMapper modelMapper=new ModelMapper();

          OrderDto orderDto = modelMapper.map(orderRequest,OrderDto.class);

          OrderDto newOrder =orderService.createOrder(orderDto,principal.getName(),payment.getPaymentId());

          OrderResponse orderResponse=modelMapper.map(newOrder,OrderResponse.class);

          return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.CREATED);
      }
}
