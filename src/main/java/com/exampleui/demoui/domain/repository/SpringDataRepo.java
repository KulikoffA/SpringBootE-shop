package com.exampleui.demoui.domain.repository;

import com.exampleui.demoui.domain.entity.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpringDataRepo extends CrudRepository<Products,String>{
    List<Products> findAllByBrand(String brand);
    List<Products> findAllByCategory(String category);
    List<Products> findAllByCategoryAndBrand(String category, String brand);
    void deleteAllByProductId(String id);
}
