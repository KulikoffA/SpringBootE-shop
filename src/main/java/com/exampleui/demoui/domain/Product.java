package com.exampleui.demoui.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

//import javax.xml.bind.annotation.XmlTransient;

public class Product implements Serializable{
    private static final long serialVersionUID = 3678107792576131001L;
    @JsonIgnore
    private MultipartFile productImage;

    private String productId;
    private String brand;
    private String name;
    private int price;
    private String description;
    private int inStock;
    private int inOrder;
    private String category;
    private int orderQuantity;

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Product() {
        super();
    }

    public Product(String productId, String brand, String name, int price) {
        this.productId = productId;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getInOrder() {
        return inOrder;
    }

    public void setInOrder(int inOrder) {
        this.inOrder = inOrder;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
//    @XmlTransient
    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile image) {
        this.productImage = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getPrice() != product.getPrice()) return false;
        if (getInStock() != product.getInStock()) return false;
        if (getInOrder() != product.getInOrder()) return false;
        if (!getProductId().equals(product.getProductId())) return false;
        if (!getBrand().equals(product.getBrand())) return false;
        if (!getName().equals(product.getName())) return false;
        if (!getDescription().equals(product.getDescription())) return false;
        return getCategory().equals(product.getCategory());
    }

    @Override
    public int hashCode() {
        int result = getProductId().hashCode();
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPrice();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getInStock();
        result = 31 * result + getInOrder();
        result = 31 * result + getCategory().hashCode();
        return result;
    }
}
