package com.ecom.app.ws.controllers;


import com.ecom.app.ws.entities.UserDetailEntity;
import com.ecom.app.ws.entities.UserPayment;
import com.ecom.app.ws.requests.PaymentRequest;
import com.ecom.app.ws.responses.PaymentResponse;
import com.ecom.app.ws.services.PaymentService;
import com.ecom.app.ws.shared.dto.PaymentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest paymentRequest, Principal principal){

        ModelMapper modelMapper=new ModelMapper();

        PaymentDto paymentDto=modelMapper.map(paymentRequest, PaymentDto.class);

        PaymentDto createPayment =paymentService.addPayment(paymentDto,principal.getName());

        PaymentResponse paymentResponse=modelMapper.map(createPayment, PaymentResponse.class);

        return new ResponseEntity<PaymentResponse>(paymentResponse, HttpStatus.CREATED);
    }
}
