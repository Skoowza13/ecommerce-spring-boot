package com.ecom.app.ws.shared.dto;

import com.ecom.app.ws.entities.CartItem;
import com.ecom.app.ws.entities.ProductEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProdToCartDto {

    private long id;

    private String prodToItemId;

    private ProductDto product;

    private CartItemDto cart;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProdToItemId() {
        return prodToItemId;
    }

    public void setProdToItemId(String prodToItemId) {
        this.prodToItemId = prodToItemId;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public CartItemDto getCart() {
        return cart;
    }

    public void setCart(CartItemDto cart) {
        this.cart = cart;
    }
}
