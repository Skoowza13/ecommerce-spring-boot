package com.ecom.app.ws.controllers;

import com.ecom.app.ws.requests.UserPayment;
import com.ecom.app.ws.responses.UserPaymentResponse;
import com.ecom.app.ws.services.UserPaymentService;
import com.ecom.app.ws.shared.dto.UserPaymentDto;
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
@RequestMapping("payment-user")
public class UserPaymentController {


    @Autowired
    UserPaymentService userPaymentService;

    @PostMapping("create")
    public ResponseEntity<UserPaymentResponse> createUserPayment(@RequestBody UserPayment userPayment, Principal principal){

        ModelMapper modelMapper=new ModelMapper();

        UserPaymentDto userPaymentDto=modelMapper.map(userPayment, UserPaymentDto.class);

        UserPaymentDto createUserPayment=userPaymentService.createUserPayment(userPaymentDto,principal.getName());

        UserPaymentResponse userPaymentResponse=modelMapper.map(createUserPayment, UserPaymentResponse.class);

        return new ResponseEntity<UserPaymentResponse>(userPaymentResponse, HttpStatus.CREATED);
    }

}
