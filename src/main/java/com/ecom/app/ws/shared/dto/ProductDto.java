package com.ecom.app.ws.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDto implements Serializable {

    private static final long serialVersionUID = 555973978755445617L;

    private long id;
    private String product_Id;
    private String productName;
    private BigDecimal price;
    private String description;
    private int availability;
    private UserDto user;
    private CategoryDto category;

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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
