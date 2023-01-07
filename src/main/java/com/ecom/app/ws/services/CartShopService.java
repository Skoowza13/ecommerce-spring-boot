package com.ecom.app.ws.services;

import com.ecom.app.ws.shared.dto.CartShopDto;

public interface CartShopService {

    CartShopDto createShopCart(CartShopDto cartShopDto, String email);
}
