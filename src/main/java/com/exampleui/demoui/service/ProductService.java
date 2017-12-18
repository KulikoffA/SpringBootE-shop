package com.exampleui.demoui.service;

import com.exampleui.demoui.domain.CartCheckout;
import com.exampleui.demoui.domain.CartItems;
import com.exampleui.demoui.domain.Product;
import com.exampleui.demoui.domain.entity.Products;
import com.exampleui.demoui.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class ProductService implements ProductServiceFace {

    @Autowired
    private ProductFace products;

    @Autowired
    private CartFace carts;

    @Autowired
    private CartItemsFace cartItems;

    @Autowired
    private CartCheckoutFace cartCheckout;


    @Override
    public List<Product> getAllProducts() {
        return products.getAllProducts();
    }

    @Override
    public SortedSet<String> getBrands(List<Products> products) {
        SortedSet<String> brands = new TreeSet<>();
        for (Products product : products) {
            String brand = product.getBrand();
            brands.add(brand);
        }
        return brands;
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return products.getProductsByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return products.getProductsByCategory(category);
    }

    @Override
    public List<Product> getProductsByCategoryBrand(String category, String brand) {
        return products.getProductsByCategoryBrand(category, brand);
    }

    @Override
    public void addProduct(Product product) {
        products.addProduct(product);
    }

    @Override
    public void deleteProductById(String id) {
        products.deleteProductById(id);
    }

    @Override
    public Product getProductById(String id) {
        return products.getProductById(id);
    }

    @Override
    public void setCartId(String cartId) {
        carts.setCartId(cartId);
    }

    @Override
    public void addNewItem(String cartId, String productId, int quantity) {
        cartItems.addNewItem(cartId, productId, quantity);
    }

    @Override
    public List<CartItems> getCartItemsByCartId(String cartId) {
        return cartItems.getCartItemsByCartId(cartId);
    }

    @Override
    public List<CartCheckout> getCartItems(String cartId) {
        return cartCheckout.getCartItems(cartId);
    }

    @Override
    public void updateQuantity(String cartId, String productId, boolean increase) {
        cartItems.updateQuantity(cartId, productId, increase);
    }

    @Override
    public void deleteItem(String cartId, String productId) {
        cartItems.deleteItem(cartId, productId);
    }

    @Override
    public void deleteCart(String cartId) {
        cartItems.deleteCart(cartId);
    }


}
