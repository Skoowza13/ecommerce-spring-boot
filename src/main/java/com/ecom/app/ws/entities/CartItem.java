package com.ecom.app.ws.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "cartItem")
public class CartItem implements Serializable {

    private static final long serialVersionUID= -3535981471986896257L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String cartItemId;

    @Column(nullable = false)
    private int quantity;

    @OneToOne
    private ProductEntity product;

    @OneToMany(mappedBy = "cartItem")
    @JsonIgnore
    private List<ProductToCartItem> productToCartItems;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private CartShopEntity cartShop;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;


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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public List<ProductToCartItem> getProductToCartItems() {
        return productToCartItems;
    }

    public void setProductToCartItems(List<ProductToCartItem> productToCartItems) {
        this.productToCartItems = productToCartItems;
    }

    public CartShopEntity getCartShop() {
        return cartShop;
    }

    public void setCartShop(CartShopEntity cartShop) {
        this.cartShop = cartShop;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
