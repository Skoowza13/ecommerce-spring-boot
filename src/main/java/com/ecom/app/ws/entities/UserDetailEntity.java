package com.ecom.app.ws.entities;

import javax.persistence.*;

@Entity
public class UserDetailEntity {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String userDetailId;
    @Column(nullable = false)
    private String userDetailName;
    @Column(nullable = false)
    private String userDetailStreet1;
    @Column(nullable = false)
    private String userDetailStreet2;
    @Column(nullable = false)
    private String userDetailCity;
    @Column(nullable = false)
    private String userDetailState;
    @Column(nullable = false)
    private String userDetailCountry;
    @Column(nullable = false)
    private String userDetailZipcode;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_payment_id")
    private UserPayment userPayment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(String userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getUserDetailName() {
        return userDetailName;
    }

    public void setUserDetailName(String userDetailName) {
        this.userDetailName = userDetailName;
    }

    public String getUserDetailStreet1() {
        return userDetailStreet1;
    }

    public void setUserDetailStreet1(String userDetailStreet1) {
        this.userDetailStreet1 = userDetailStreet1;
    }

    public String getUserDetailStreet2() {
        return userDetailStreet2;
    }

    public void setUserDetailStreet2(String userDetailStreet2) {
        this.userDetailStreet2 = userDetailStreet2;
    }

    public String getUserDetailCity() {
        return userDetailCity;
    }

    public void setUserDetailCity(String userDetailCity) {
        this.userDetailCity = userDetailCity;
    }

    public String getUserDetailState() {
        return userDetailState;
    }

    public void setUserDetailState(String userDetailState) {
        this.userDetailState = userDetailState;
    }

    public String getUserDetailCountry() {
        return userDetailCountry;
    }

    public void setUserDetailCountry(String userDetailCountry) {
        this.userDetailCountry = userDetailCountry;
    }

    public String getUserDetailZipcode() {
        return userDetailZipcode;
    }

    public void setUserDetailZipcode(String userDetailZipcode) {
        this.userDetailZipcode = userDetailZipcode;
    }

    public UserPayment getUserPayment() {
        return userPayment;
    }

    public void setUserPayment(UserPayment userPayment) {
        this.userPayment = userPayment;
    }
}
