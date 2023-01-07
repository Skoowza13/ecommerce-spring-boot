package com.ecom.app.ws.services.impl;

import com.ecom.app.ws.entities.OrderEntity;
import com.ecom.app.ws.entities.PaymentEntity;
import com.ecom.app.ws.entities.UserEntity;
import com.ecom.app.ws.repositories.OrderRepository;
import com.ecom.app.ws.repositories.PaymentRepository;
import com.ecom.app.ws.repositories.UserRepository;
import com.ecom.app.ws.services.OrderService;
import com.ecom.app.ws.shared.Utils;
import com.ecom.app.ws.shared.dto.OrderDto;
import com.ecom.app.ws.shared.dto.PaymentDto;
import com.ecom.app.ws.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    Utils utils;

    @Override
    public OrderDto createOrder(OrderDto order, String email, String paymentId) {

        UserEntity currentUser =userRepository.findByEmail(email);

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto=modelMapper.map(currentUser,UserDto.class);

        PaymentEntity payment = paymentRepository.findByPaymentId(paymentId);

        PaymentDto paymentDto=modelMapper.map(payment, PaymentDto.class);

        order.setOrderId(utils.generateStringId(30));
        order.setUser(userDto);
        order.setPayment(paymentDto);

        OrderEntity orderEntity = modelMapper.map(order,OrderEntity.class);

        OrderEntity newOrder = orderRepository.save(orderEntity);

        OrderDto orderDto = modelMapper.map(newOrder, OrderDto.class);

        return orderDto;
    }
}
