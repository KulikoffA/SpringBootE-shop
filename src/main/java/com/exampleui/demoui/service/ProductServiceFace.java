package com.exampleui.demoui.service;

import com.exampleui.demoui.domain.CartCheckout;
import com.exampleui.demoui.domain.CartItems;
import com.exampleui.demoui.domain.Product;

import java.util.List;
import java.util.SortedSet;

public interface ProductServiceFace {
    List<Product> getAllProducts();
    SortedSet<String> getBrands(List<Product> products);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByCategoryBrand(String category, String brand);
    void addProduct(Product product);
    void deleteProductById(String id);
    Product getProductById(String id);
    void setCartId(String cartId);
    void addNewItem(String cartId, String productId, int quantity);
    List<CartItems> getCartItemsByCartId(String cartId);
    List<CartCheckout> getCartItems(String cartId);
    void updateQuantity(String cartId, String productId, boolean increase);
    void deleteItem(String cartId, String productId);
    void deleteCart(String cartId);
}
