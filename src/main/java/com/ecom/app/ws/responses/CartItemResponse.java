package com.ecom.app.ws.responses;

import javax.persistence.Column;

public class CartItemResponse {

    private String cartItemId;

    private int quantity;

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
