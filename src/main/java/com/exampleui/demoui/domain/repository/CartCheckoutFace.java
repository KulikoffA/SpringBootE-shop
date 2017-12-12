package com.exampleui.demoui.domain.repository;

import com.exampleui.demoui.domain.CartCheckout;

import java.util.List;

public interface CartCheckoutFace {
    List<CartCheckout> getCartItems(String cartId);
}
