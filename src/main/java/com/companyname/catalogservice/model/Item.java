package com.companyname.catalogservice.model;

import java.math.BigDecimal;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.companyname.catalogservice.enums.Category;

public class Item {

    private Integer id;
    @Size(max=100, message="Name should have max 100 characters")
    private String name;
    @Size(max=2000, message="Description should have max 2000 characters")
    private String description;
    @DecimalMin(value = "0.00", inclusive = true, message = "Price should be greater than or equal to 0.00")
    private BigDecimal price;
    private List<Category> categories;
    private List<URI> images;
    
    public Item() {
        categories = new LinkedList<>();
        images = new LinkedList<>();
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
 
    public BigDecimal getPrice() {
        return price;
    }
   
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
   
    public List<Category> getCategories() {
        return categories;
    }
 
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
   
    public List<URI> getImages() {
        return images;
    }

    public void setImages(List<URI> images) {
        this.images = images;
    }
}


