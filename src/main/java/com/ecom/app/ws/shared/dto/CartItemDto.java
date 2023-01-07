package com.ecom.app.ws.shared.dto;

import javax.persistence.Column;

public class CartItemDto {

    private long id;

    private String cartItemId;

    private int quantity;

    private ProductDto product;

    private OrderDto order;

    private CartShopDto cartShop;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public CartShopDto getCartShop() {
        return cartShop;
    }

    public void setCartShop(CartShopDto cartShop) {
        this.cartShop = cartShop;
    }
}
