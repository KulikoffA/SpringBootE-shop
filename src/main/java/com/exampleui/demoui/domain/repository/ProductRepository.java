package com.exampleui.demoui.domain.repository;

import com.exampleui.demoui.domain.Product;
import com.exampleui.demoui.domain.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements ProductFace {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        String SQL = "SELECT * FROM products";
        Map<String, Object> params = new HashMap<>();
        return jdbcTemplate.query(SQL, params, new ProductMapper());
    }


    @Override
    public List<Product> getProductsByBrand(String brand) {
        String SQL = "SELECT * FROM products WHERE brand = :brand";
        Map<String, Object> params = new HashMap<>();
        params.put("brand", brand);
        return jdbcTemplate.query(SQL, params, new ProductMapper());
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        String SQL = "SELECT * FROM products WHERE category = :category";
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        return jdbcTemplate.query(SQL, params, new ProductMapper());
    }

    @Override
    public List<Product> getProductsByCategoryBrand(String category, String brand) {
        String SQL = "SELECT * FROM products WHERE category = :category AND brand = :brand";
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("brand", brand);
        return jdbcTemplate.query(SQL, params, new ProductMapper());
    }

    @Override
    public void addProduct(Product product) {
        String SQL = "INSERT INTO products VALUES " +
                "(:id,:brand,:name,:price,:description,:inStock,:inOrder,:category)";

        Map<String, Object> params = new HashMap<>();
        params.put("id", product.getProductId());
        params.put("brand", product.getBrand());
        params.put("name", product.getName());
        params.put("price", product.getPrice());
        params.put("description", product.getDescription());
        params.put("inStock", product.getInStock());
        params.put("inOrder", product.getInOrder());
        params.put("category", product.getCategory());

        jdbcTemplate.update(SQL, params);
    }

    @Override
    public void deleteProductById(String id) {
        System.out.println("Performing delete operation for " + id);
        String SQL = "DELETE FROM products WHERE product_id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(SQL, params);
    }

    @Override
    public Product getProductById(String id) {
        String SQL = "SELECT * FROM products WHERE product_id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(SQL, params, new ProductMapper());
    }
}
