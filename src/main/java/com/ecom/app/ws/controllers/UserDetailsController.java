package com.ecom.app.ws.controllers;


import com.ecom.app.ws.entities.UserPayment;
import com.ecom.app.ws.requests.UserDetailsRequest;
import com.ecom.app.ws.responses.UserDetailsResponse;
import com.ecom.app.ws.services.UserDetailService;
import com.ecom.app.ws.shared.dto.UserDetailDto;
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
@RequestMapping("/user-details")
public class UserDetailsController {


    @Autowired
    UserDetailService userDetailService;

    @PostMapping("create")
    public ResponseEntity<UserDetailsResponse> createUserDetails(@RequestBody UserDetailsRequest userDetailsRequest, Principal principal){

        ModelMapper modelMapper=new ModelMapper();

        UserDetailDto userDetailDto =modelMapper.map(userDetailsRequest, UserDetailDto.class);

        UserDetailDto newUser = userDetailService.createUserDetail(userDetailDto,principal.getName());

        UserDetailsResponse userDetailsResponse=modelMapper.map(newUser, UserDetailsResponse.class);

        return new ResponseEntity<UserDetailsResponse>(userDetailsResponse, HttpStatus.CREATED);
    }

}
