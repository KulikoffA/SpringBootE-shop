package com.exampleui.demoui.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepository implements CartFace {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTempleate;

    @Override
    public void setCartId(String cartId) {
        String SQL ="insert into cart(cart_id) values (:id)";
        Map<String, Object> params = new HashMap<>();
        params.put("id",cartId);
        jdbcTempleate.update(SQL,params);
    }
}
