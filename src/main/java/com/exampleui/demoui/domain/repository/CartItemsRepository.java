package com.exampleui.demoui.domain.repository;

import com.exampleui.demoui.domain.CartItems;
import com.exampleui.demoui.domain.CartItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartItemsRepository implements CartItemsFace {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<CartItems> getCartItemsByCartId(String cartId) {
        String SQL = "SELECT * FROM cart_items WHERE cart_id= :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", cartId);
        return jdbcTemplate.query(SQL, params, new CartItemsMapper());
    }

    @Override
    public void addNewItem(String cartId, String productId, int quantity) {
        try {
            String SQL = "INSERT INTO cart_items VALUES (:cartId, :productId, :quantity)";
            Map<String, Object> params = new HashMap<>();
            params.put("cartId", cartId);
            params.put("productId", productId);
            params.put("quantity", quantity);
            jdbcTemplate.update(SQL, params);
        } catch (DataAccessException e) {
            updateQuantity(cartId, productId, true);
        }
    }

    @Override
    public CartItems getCartItemByCartIdAndProductId(String cartId, String productId) {
        String SQL = "SELECT * FROM cart_items WHERE cart_id = :cartId AND product_id= :productId";
        Map<String, Object> params = new HashMap<>();
        params.put("cartId", cartId);
        params.put("productId", productId);
        return jdbcTemplate.queryForObject(SQL, params, new CartItemsMapper());
    }

    @Override
    public void updateQuantity(String cartId, String productId, boolean increase) {
        String SQL = "UPDATE cart_items SET quantity = :quantity WHERE cart_id = :cartId AND product_id = :productId";
        CartItems item = getCartItemByCartIdAndProductId(cartId, productId);
        Map<String, Object> params = new HashMap<>();
        params.put("cartId", cartId);
        params.put("productId", productId);

        if (increase) {
            params.put("quantity", item.getQuantity() + 1);
        } else {
            params.put("quantity", item.getQuantity() - 1);
        }

        jdbcTemplate.update(SQL, params);
    }

    @Override
    public void deleteItem(String cartId, String productId) {
        String SQL = "DELETE FROM cart_items WHERE cart_id = :cartId AND product_id = :productId";
        Map<String, Object> params = new HashMap<>();
        params.put("cartId", cartId);
        params.put("productId", productId);
        jdbcTemplate.update(SQL, params);
    }

    @Override
    public void deleteCart(String cartId) {
        String SQL = "DELETE FROM cart_items WHERE cart_id = :cartId";
        Map<String, Object> params = new HashMap<>();
        params.put("cartId", cartId);
        jdbcTemplate.update(SQL, params);
    }
}
