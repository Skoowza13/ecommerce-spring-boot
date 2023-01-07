package com.ecom.app.ws.services.impl;

import com.ecom.app.ws.entities.PaymentEntity;
import com.ecom.app.ws.entities.UserDetailEntity;
import com.ecom.app.ws.entities.UserPayment;
import com.ecom.app.ws.repositories.PaymentRepository;
import com.ecom.app.ws.repositories.UserDetailsRepository;
import com.ecom.app.ws.services.PaymentService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.PaymentDto;
import com.ecom.app.ws.shared.dto.UserDetailDto;
import com.ecom.app.ws.shared.dto.UserPaymentDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    Utils utils;

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public PaymentDto addPayment(PaymentDto payment, String userDetailId) {

        UserDetailEntity userDetail =userDetailsRepository.findByUserDetailId(userDetailId);



        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT);
        UserDetailDto userDetailDto =modelMapper.map(userDetail, UserDetailDto.class);

        payment.setPaymentId(utils.generateStringId(30));
        payment.setUser(userDetailDto);


        PaymentEntity paymentEntity=modelMapper.map(payment, PaymentEntity.class);

        PaymentEntity newPayment =paymentRepository.save(paymentEntity);

        PaymentDto paymentDto = modelMapper.map(newPayment, PaymentDto.class);

        return paymentDto;
    }
}
