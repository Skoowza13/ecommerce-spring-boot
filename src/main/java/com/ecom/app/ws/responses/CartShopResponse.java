package com.ecom.app.ws.responses;

import java.math.BigDecimal;

public class CartShopResponse {

    private String cartId;

    private BigDecimal GrandTotal;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public BigDecimal getGrandTotal() {
        return GrandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        GrandTotal = grandTotal;
    }
}
