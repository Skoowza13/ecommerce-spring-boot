package com.ecom.app.ws.entities;

import javax.persistence.*;

@Entity(name = "product_to_cart_item")
public class ProductToCartItem {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String prodToItemId;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name="cart_item_id")
    private CartItem cartItem;

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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }
}
