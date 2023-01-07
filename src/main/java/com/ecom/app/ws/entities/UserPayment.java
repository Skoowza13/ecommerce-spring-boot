package com.ecom.app.ws.entities;

import javax.persistence.*;

@Entity(name = "user_payment")
public class UserPayment {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String userPaymentId;
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
    @Column(nullable = false)
    private boolean defaultPayment=false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne(mappedBy = "userPayment",cascade = CascadeType.ALL)
    private UserDetailEntity userDetail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserPaymentId() {
        return userPaymentId;
    }

    public void setUserPaymentId(String userPaymentId) {
        this.userPaymentId = userPaymentId;
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

    public boolean isDefaultPayment() {
        return defaultPayment;
    }

    public void setDefaultPayment(boolean defaultPayment) {
        this.defaultPayment = defaultPayment;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserDetailEntity getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailEntity userDetail) {
        this.userDetail = userDetail;
    }
}
