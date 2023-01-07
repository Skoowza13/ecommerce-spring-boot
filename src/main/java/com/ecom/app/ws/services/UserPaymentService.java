package com.ecom.app.ws.services;

import com.ecom.app.ws.shared.dto.UserPaymentDto;

public interface UserPaymentService {
    UserPaymentDto createUserPayment(UserPaymentDto userPaymentDto, String email);
}
