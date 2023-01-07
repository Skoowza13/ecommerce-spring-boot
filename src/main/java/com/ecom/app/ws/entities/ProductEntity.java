package com.ecom.app.ws.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "products")
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 6537987818486756196L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String product_Id;

    @Column(nullable=false,length=50)
    private String productName;

    @Column(nullable=false)
    private BigDecimal price;

    @Column(nullable=false,length=50)
    private String description;

    @Column(nullable=false)
    private int availability;

    @ManyToOne
    @JoinColumn(name="users_Id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="categories_Id")
    private CategoryEntity category;






    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(String product_Id) {
        this.product_Id = product_Id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }


}
