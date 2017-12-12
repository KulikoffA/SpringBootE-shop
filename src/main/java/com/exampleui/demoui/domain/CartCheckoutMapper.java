package com.exampleui.demoui.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartCheckoutMapper implements RowMapper<CartCheckout> {
    @Override
    public CartCheckout mapRow(ResultSet resultSet, int i) throws SQLException {

        CartCheckout cartCheckout = new CartCheckout();

        cartCheckout.setProductId(resultSet.getString(1));
        cartCheckout.setQuantity(resultSet.getInt(2));
        cartCheckout.setBrand(resultSet.getString(3));
        cartCheckout.setName(resultSet.getString(4));
        cartCheckout.setPrice(resultSet.getInt(5));

        return cartCheckout;
    }
}
