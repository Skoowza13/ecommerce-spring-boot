package com.ecom.app.ws.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "orders")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID= -6838904057525484540L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String orderId;

    @Column(nullable = false)
    private String orderDate;

    @Column(nullable = false)
    private String shippingDate;
    @Column(nullable = false)
    private String shippingMethod;
    @Column(nullable = false)
    private String orderStatus;
    @Column(nullable = false)
    private BigDecimal orderTotal;


    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<CartItem> cartItemList;

    @ManyToOne
    private UserEntity user;

    @OneToOne
    private PaymentEntity payment;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }
}
