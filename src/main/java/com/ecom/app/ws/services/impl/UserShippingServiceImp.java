package com.ecom.app.ws.services.impl;

import com.ecom.app.ws.entities.UserEntity;
import com.ecom.app.ws.entities.UserShipping;
import com.ecom.app.ws.repositories.UserRepository;
import com.ecom.app.ws.repositories.UserShippingRepository;
import com.ecom.app.ws.services.UserShippingService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.ShippingDto;
import com.ecom.app.ws.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserShippingServiceImp implements UserShippingService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    UserShippingRepository userShippingRepository;


    @Override
    public ShippingDto createShipping(ShippingDto userShipping, String email) {

        UserEntity currentUser = userRepository.findByEmail(email);

        ModelMapper modelMapper=new ModelMapper();
        UserDto userDto=modelMapper.map(currentUser,UserDto.class);

        userShipping.setUserShippingId(utils.generateStringId(30));
        userShipping.setUser(userDto);

        UserShipping userShippingEntity=modelMapper.map(userShipping,UserShipping.class);

        UserShipping newUserShipping=userShippingRepository.save(userShippingEntity);

        ShippingDto shippingDto=modelMapper.map(newUserShipping, ShippingDto.class);

        return shippingDto;
    }
}
