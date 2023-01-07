package com.ecom.app.ws.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "categories")
public class CategoryEntity implements Serializable {

    private static final long serialVersionUID = -5910395098653319202L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String category_Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "category",cascade=CascadeType.ALL)
    private List<ProductEntity> product;

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

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }
}
