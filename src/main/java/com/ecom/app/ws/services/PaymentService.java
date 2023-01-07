package com.ecom.app.ws.services;

import com.ecom.app.ws.entities.UserPayment;
import com.ecom.app.ws.shared.dto.PaymentDto;
import com.ecom.app.ws.shared.dto.UserPaymentDto;

public interface PaymentService {


    PaymentDto addPayment(PaymentDto payment, String userDetailId);
}
