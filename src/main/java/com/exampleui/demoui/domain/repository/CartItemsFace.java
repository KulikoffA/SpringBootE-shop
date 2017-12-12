package com.exampleui.demoui.domain.repository;

import com.exampleui.demoui.domain.CartItems;

import java.util.List;

public interface CartItemsFace {
    List<CartItems> getCartItemsByCartId(String cartId);
    void addNewItem(String cartId, String productId, int quantity);
    CartItems getCartItemByCartIdAndProductId(String cartId, String productId);
    void updateQuantity(String cartId, String productId, boolean increase);
    void deleteItem(String cartId, String productId);
    void deleteCart(String cartId);
}
