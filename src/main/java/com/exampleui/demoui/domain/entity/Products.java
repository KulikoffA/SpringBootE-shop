package com.exampleui.demoui.domain.entity;

import javax.persistence.*;

@Entity
public class Products {

    @Id
    @Column(name = "product_id", nullable = false, length = 20)
    private String productId;

    @Basic
    @Column(name = "brand", nullable = false, length = 20)
    private String brand;

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Basic
    @Column(name = "price", nullable = false)
    private int price;

    @Basic
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Basic
    @Column(name = "in_stock", nullable = false)
    private int inStock;

    @Basic
    @Column(name = "in_order", nullable = false)
    private int inOrder;

    @Basic
    @Column(name = "category", nullable = false, length = 20)
    private String category;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (price != products.price) return false;
        if (inStock != products.inStock) return false;
        if (inOrder != products.inOrder) return false;
        if (productId != null ? !productId.equals(products.productId) : products.productId != null) return false;
        if (brand != null ? !brand.equals(products.brand) : products.brand != null) return false;
        if (name != null ? !name.equals(products.name) : products.name != null) return false;
        if (description != null ? !description.equals(products.description) : products.description != null)
            return false;
        if (category != null ? !category.equals(products.category) : products.category != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + inStock;
        result = 31 * result + inOrder;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
