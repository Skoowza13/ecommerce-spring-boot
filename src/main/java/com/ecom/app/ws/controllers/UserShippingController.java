package com.ecom.app.ws.controllers;

import com.ecom.app.ws.requests.ShippingRequest;
import com.ecom.app.ws.responses.UserShippingResponse;
import com.ecom.app.ws.services.UserShippingService;
import com.ecom.app.ws.shared.dto.ShippingDto;
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
@RequestMapping("shipping")
public class UserShippingController {

    @Autowired
    UserShippingService userShippingService;

    @PostMapping("create")
    public ResponseEntity<UserShippingResponse> createShipping(@RequestBody ShippingRequest shippingRequest, Principal principal){

        ModelMapper modelMapper=new ModelMapper();

        ShippingDto shippingDto=modelMapper.map(shippingRequest,ShippingDto.class);

        ShippingDto createShipping=userShippingService.createShipping(shippingDto,principal.getName());

        UserShippingResponse userShippingResponse = modelMapper.map(createShipping,UserShippingResponse.class);

        return new ResponseEntity<UserShippingResponse>(userShippingResponse, HttpStatus.CREATED);
    }
}
