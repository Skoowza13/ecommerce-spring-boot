package com.ecom.app.ws.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "payment")
public class PaymentEntity implements Serializable {

    private static final long serialVersionUID= 73850594906124220L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String paymentId;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String cardName;
    @Column(nullable = false)
    private String cardNumber;
    @Column(nullable = false)
    private int expiryMonth;
    @Column(nullable = false)
    private int expiryYear;
    @Column(nullable = false)
    private int cvc;
    @Column(nullable = false)
    private String holderName;

    @OneToOne(mappedBy = "payment",cascade=CascadeType.ALL)
    private OrderEntity order;

    @OneToOne(cascade = CascadeType.ALL)
    private UserDetailEntity userDetail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public UserDetailEntity getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailEntity userDetail) {
        this.userDetail = userDetail;
    }
}
