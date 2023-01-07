package com.ecom.app.ws.shared.dto;

public class UserDetailDto {

    private long id;

    private String userDetailId;

    private String userDetailName;

    private String userDetailStreet1;

    private String userDetailStreet2;

    private String userDetailCity;

    private String userDetailState;

    private String userDetailCountry;

    private String userDetailZipcode;

    private UserPaymentDto user;

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

    public UserPaymentDto getUser() {
        return user;
    }

    public void setUser(UserPaymentDto user) {
        this.user = user;
    }
}
