package com.ecom.app.ws.services.impl;

import com.ecom.app.ws.entities.UserEntity;
import com.ecom.app.ws.entities.UserPayment;
import com.ecom.app.ws.repositories.UserPaymentRepository;
import com.ecom.app.ws.repositories.UserRepository;
import com.ecom.app.ws.services.UserPaymentService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.UserDto;
import com.ecom.app.ws.shared.dto.UserPaymentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    UserPaymentRepository userPaymentRepository;

    @Override
    public UserPaymentDto createUserPayment(UserPaymentDto userPaymentDto, String email) {

        UserEntity currentUser = userRepository.findByEmail(email);

        ModelMapper modelMapper=new ModelMapper();
        UserDto userDto=modelMapper.map(currentUser,UserDto.class);

        userPaymentDto.setUserPaymentId(utils.generateStringId(30));
        userPaymentDto.setUser(userDto);

        UserPayment userPayment =modelMapper.map(userPaymentDto,UserPayment.class);

        UserPayment newUserPayment = userPaymentRepository.save(userPayment);

        UserPaymentDto userPaymentDto1=modelMapper.map(newUserPayment, UserPaymentDto.class);

        return userPaymentDto1;
    }
}
