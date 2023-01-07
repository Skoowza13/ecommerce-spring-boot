package com.ecom.app.ws.services;

import com.ecom.app.ws.shared.dto.CartItemDto;

public interface CartItemService {


    CartItemDto createCartItem(CartItemDto cartItemDto, String product_id, String orderId, String cartId);
}
