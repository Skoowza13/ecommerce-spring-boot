package com.ecom.app.ws.services;

import com.ecom.app.ws.shared.dto.ShippingDto;

public interface UserShippingService {
    ShippingDto createShipping(ShippingDto shippingDto, String email);
}
