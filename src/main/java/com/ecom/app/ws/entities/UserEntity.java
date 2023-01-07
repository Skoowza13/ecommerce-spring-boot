package com.ecom.app.ws.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "users")
public class UserEntity implements Serializable {


    private static final long serialVersionUID = -5611305570670319226L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String userId;

    @Column(nullable=false,length=50)
    private String firstName;

    @Column(nullable=false,length=50)
    private String lastName;

    @Column(nullable=false, length=120 , unique=true)
    private String email;

    @Column(nullable=false,length=20, unique=true)
    private String phone;

    @Column(nullable = false)
    private String encryptedPassword;

    @Column(nullable=true)
    private String emailVerificationToken;

    @Column(nullable = true)
    private Boolean admin=false;

    @Column(nullable=false)
    private Boolean emailVerificationStatus=false;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<ProductEntity> products;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    private CartShopEntity cartShopEntity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<UserShipping> userShippingList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<UserPayment> userPayments;

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public CartShopEntity getCartShopEntity() {
        return cartShopEntity;
    }

    public void setCartShopEntity(CartShopEntity cartShopEntity) {
        this.cartShopEntity = cartShopEntity;
    }
}
