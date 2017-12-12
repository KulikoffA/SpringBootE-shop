package com.exampleui.demoui.domain;

import java.io.Serializable;

public class CartItems implements Serializable{
    private String cartId = null;
    private String productId = null;
    private int quantity = 0;


    public CartItems(String cartId, String productId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartItems() {
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItems)) return false;

        CartItems items = (CartItems) o;

        if (getQuantity() != items.getQuantity()) return false;
        if (!getCartId().equals(items.getCartId())) return false;
        return getProductId().equals(items.getProductId());
    }

    @Override
    public int hashCode() {
        return getCartId().hashCode();
    }
}
