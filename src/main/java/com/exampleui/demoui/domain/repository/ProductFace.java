package com.exampleui.demoui.domain.repository;

import com.exampleui.demoui.domain.Product;

import java.util.List;

public interface ProductFace {
    List<Product> getAllProducts();
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByCategoryBrand(String category, String brand);
    void addProduct(Product product);
    void deleteProductById(String id);
    Product getProductById(String id);
}
