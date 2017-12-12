package com.exampleui.demoui.domain;

import java.io.Serializable;

public class Cart implements Serializable{

    private String cartId;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}
