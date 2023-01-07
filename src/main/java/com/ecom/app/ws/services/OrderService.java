package com.ecom.app.ws.services;

import com.ecom.app.ws.shared.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto, String email, String paymentId);
}
