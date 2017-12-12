package com.exampleui.demoui.domain;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<Cart> {
    @Override
    public Cart mapRow(ResultSet resultSet, int i) throws SQLException {
        Cart cart = new Cart();

        cart.setCartId(resultSet.getString(1));

        return cart;
    }
}
