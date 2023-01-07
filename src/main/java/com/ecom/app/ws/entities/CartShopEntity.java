package com.ecom.app.ws.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "cart_shop")
public class CartShopEntity implements Serializable {

    private static final long serialVersionUID = -3547608385845306103L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String cartId;

    @Column(nullable = false )
    private BigDecimal GrandTotal;

    @OneToMany(mappedBy = "cartShop",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cartItems;

    @OneToOne
    private UserEntity user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cart_Id) {
        this.cartId = cart_Id;
    }

    public BigDecimal getGrandTotal() {
        return GrandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        GrandTotal = grandTotal;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
