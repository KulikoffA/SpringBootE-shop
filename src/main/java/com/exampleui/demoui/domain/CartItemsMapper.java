package com.exampleui.demoui.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItemsMapper implements RowMapper<CartItems> {
    @Override
    public CartItems mapRow(ResultSet resultSet, int i) throws SQLException {

        CartItems items = new CartItems();

        items.setCartId(resultSet.getString(1));
        items.setProductId(resultSet.getString(2));
        items.setQuantity(resultSet.getInt(3));

        return items;
    }
}
