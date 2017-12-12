package com.exampleui.demoui.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {

        Product product = new Product();

        product.setProductId(rs.getString(1));
        product.setBrand(rs.getString(2));
        product.setName(rs.getString(3));
        product.setPrice(rs.getInt(4));
        product.setDescription(rs.getString(5));
        product.setInStock(rs.getInt(6));
        product.setInOrder(rs.getInt(7));
        product.setCategory(rs.getString(8));

        return product;
    }
}
