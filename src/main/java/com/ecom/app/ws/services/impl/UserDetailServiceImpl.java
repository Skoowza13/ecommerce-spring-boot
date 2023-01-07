package com.ecom.app.ws.services.impl;


import com.ecom.app.ws.entities.UserDetailEntity;
import com.ecom.app.ws.entities.UserEntity;
import com.ecom.app.ws.entities.UserPayment;
import com.ecom.app.ws.repositories.UserDetailsRepository;
import com.ecom.app.ws.repositories.UserPaymentRepository;
import com.ecom.app.ws.repositories.UserRepository;
import com.ecom.app.ws.services.UserDetailService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.UserDetailDto;
import com.ecom.app.ws.shared.dto.UserPaymentDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    UserPaymentRepository userPaymentRepository;

    @Autowired
    Utils util;

    @Autowired
    UserDetailsRepository userDetailsRepository;



    @Override
    public UserDetailDto createUserDetail(UserDetailDto userDetailDto, String userPaymentId) {

        UserPayment userPayment= userPaymentRepository.findAllByUserPaymentId(userPaymentId);

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        UserPaymentDto userPaymentDto=modelMapper.map(userPayment, UserPaymentDto.class);

        userDetailDto.setUserDetailId(util.generateStringId(30));
        userDetailDto.setUser(userPaymentDto);

        UserDetailEntity userDetail = modelMapper.map(userDetailDto,UserDetailEntity.class);

        UserDetailEntity newUser = userDetailsRepository.save(userDetail);

        UserDetailDto userDetailDto1=modelMapper.map(newUser,UserDetailDto.class);

        return userDetailDto1;
    }
}
