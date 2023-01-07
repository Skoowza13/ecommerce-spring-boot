package com.ecom.app.ws.shared.dto;

import java.io.Serializable;
import java.util.List;

public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 7184630067147378293L;

    private long id;
    private String category_Id;
    private String name;
    private String description;
    private List<ProductDto> product;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(String category_Id) {
        this.category_Id = category_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductDto> getProduct() {
        return product;
    }

    public void setProduct(List<ProductDto> product) {
        this.product = product;
    }
}
