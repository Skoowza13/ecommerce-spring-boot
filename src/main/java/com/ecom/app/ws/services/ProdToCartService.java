package com.ecom.app.ws.services;

import com.ecom.app.ws.shared.dto.ProdToCartDto;

public interface ProdToCartService {
    ProdToCartDto addProdToCartItem(ProdToCartDto prodToCartDto, String product_id, String cartItemId);
}
