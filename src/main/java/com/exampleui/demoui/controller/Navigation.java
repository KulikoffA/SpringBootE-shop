package com.exampleui.demoui.controller;

import com.exampleui.demoui.domain.CartCheckout;
import com.exampleui.demoui.domain.entity.Products;
import com.exampleui.demoui.domain.repository.SpringDataRepo;
import com.exampleui.demoui.service.ProductServiceFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.SortedSet;

@Controller
@RequestMapping("/eshop")
public class Navigation {

    @Autowired
    ProductServiceFace productService;

    @Autowired
    SpringDataRepo springDataRepo;

    @GetMapping
    public String showWelcomePage() {
        return "welcome";
    }

    @GetMapping("/cart/checkout")
    public String cartCheckout(Model model, HttpServletRequest request) {

        List<CartCheckout> items = productService.getCartItems(String.valueOf(request.getSession().getAttribute("cartId")));
        model.addAttribute("items", items);
        return "checkout";
    }

    @GetMapping("/{category}")
    public String getProducts(@PathVariable("category") String category, Model model, HttpServletRequest request) {
        List<Products> products = springDataRepo.findAllByCategory(category);
        SortedSet<String> brands = productService.getBrands(products);
        model.addAttribute("products", products);
        model.addAttribute("brands", brands);
        request.setAttribute("category", category);

        return category;
    }

    @GetMapping("/{category}/{brand}")
    public String showProductsByBrand(@PathVariable("category") String category, @PathVariable("brand") String brand,
                                      Model model, HttpServletRequest request) {
        List<Products> productsByCategoryBrand = springDataRepo.findAllByCategoryAndBrand(category,brand);
        SortedSet<String> brands = productService.getBrands(springDataRepo.findAllByCategory(category));
        model.addAttribute("products", productsByCategoryBrand);
        model.addAttribute("brands", brands);
        request.setAttribute("category", category);

        return category;
    }


}
