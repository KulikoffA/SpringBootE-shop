package com.exampleui.demoui.controller;

import com.exampleui.demoui.domain.Product;
import com.exampleui.demoui.service.ProductServiceFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/manager")
public class Management {

    @Autowired
    ProductServiceFace service;

    @RequestMapping
    public String adminPanel(Model model) {
        return "manageProducts";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getNewProduct(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processFormAddProduct(@ModelAttribute("product") Product newProduct) {
        MultipartFile productImage = newProduct.getProductImage();
        if (productImage != null && !productImage.isEmpty()) {
            try {
                String rootDir = new File(".")
                        .getAbsoluteFile()
                        .getParentFile()
                        .getAbsolutePath()
                        .replace("/","\\");
                productImage.transferTo(new File(rootDir + "\\src\\main\\webapp\\WEB-INF\\resources\\img\\" +
                        newProduct.getCategory() + "\\" + newProduct.getName() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }
        service.addProduct(newProduct);
        return "redirect:/manager/add";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String deleteProduct() {
        return "deleteProduct";
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String processDeleteProduct(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        service.deleteProductById(productId);

        return "redirect:/manager";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String infoProduct() {
        return "getProductInfo";
    }
}
