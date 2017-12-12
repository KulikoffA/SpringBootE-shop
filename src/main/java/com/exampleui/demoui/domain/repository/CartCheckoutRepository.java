package com.exampleui.demoui.domain.repository;

import com.exampleui.demoui.domain.CartCheckout;
import com.exampleui.demoui.domain.CartCheckoutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartCheckoutRepository implements CartCheckoutFace {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<CartCheckout> getCartItems(String cartId) {

        String SQL = "SELECT item.product_id, item.quantity, product.brand, product.name, product.price " +
                "FROM cart_items item " +
                "LEFT JOIN products product " +
                "ON item.product_id = product.product_id " +
                "WHERE item.cart_id = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", cartId);

        return jdbcTemplate.query(SQL, params, new CartCheckoutMapper());
    }
}
