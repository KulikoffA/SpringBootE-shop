package com.exampleui.demoui.controller;

import com.exampleui.demoui.domain.CartItems;
import com.exampleui.demoui.domain.Product;
import com.exampleui.demoui.service.ProductServiceFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rest/")
public class Rest {

    @Autowired
    private ProductServiceFace service;

    @RequestMapping(value = "product/get/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("productId") String id) {
        return service.getProductById(id);
    }

    @RequestMapping(value = "product/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<String> addProductToCart(@RequestBody CartItems item, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int itemsCount = (int) session.getAttribute("itemsCount") + 1;
        session.setAttribute("itemsCount", itemsCount);

        String cartId = item.getCartId();
        String productId = item.getProductId();
        int quantity = item.getQuantity();
        int productPrice = service.getProductById(productId).getPrice();

        int totalPrice = (int) session.getAttribute("price") + productPrice;
        session.setAttribute("price", totalPrice);

        ArrayList<String> data = new ArrayList<>();
        data.add("" + itemsCount);
        data.add("" + totalPrice);

        service.addNewItem(cartId, productId, quantity);

        return data;
    }

    @RequestMapping(value = "cart/update/increase", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<String> increaseQuantity(@RequestBody CartItems item, HttpServletRequest request) {

        HttpSession session = request.getSession();
        int itemsCount = (int) session.getAttribute("itemsCount") + 1;
        session.setAttribute("itemsCount", itemsCount);

        String cartId = String.valueOf(session.getAttribute("cartId"));
        String productId = item.getProductId();
        int productPrice = service.getProductById(productId).getPrice();

        int totalPrice = (int) session.getAttribute("price") + productPrice;
        session.setAttribute("price", totalPrice);

        ArrayList<String> data = new ArrayList<>();
        data.add("" + itemsCount);
        data.add("" + totalPrice);

        service.updateQuantity(cartId, productId, true);
        return data;
    }

    @RequestMapping(value = "cart/update/decrease", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<String> decreaseQuantity(@RequestBody CartItems item, HttpServletRequest request) {

        HttpSession session = request.getSession();
        int itemsCount = (int) session.getAttribute("itemsCount") - 1;
        session.setAttribute("itemsCount", itemsCount);

        String cartId = String.valueOf(session.getAttribute("cartId"));
        String productId = item.getProductId();
        int productPrice = service.getProductById(productId).getPrice();

        int totalPrice = (int) session.getAttribute("price") - productPrice;
        session.setAttribute("price", totalPrice);

        ArrayList<String> data = new ArrayList<>();
        data.add("" + itemsCount);
        data.add("" + totalPrice);

        service.updateQuantity(cartId, productId, false);
        return data;
    }

    @RequestMapping(value = "cart/update/delete", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public List<String> deleteItemQuantity(@RequestBody CartItems item, HttpServletRequest request) {

        HttpSession session = request.getSession();

        int itemQuantity = item.getQuantity();
        int itemsCount = (int) session.getAttribute("itemsCount") - itemQuantity;
        session.setAttribute("itemsCount", itemsCount);

        String cartId = String.valueOf(session.getAttribute("cartId"));
        String productId = item.getProductId();
        int productPrice = service.getProductById(productId).getPrice();

        int totalPrice = (int) session.getAttribute("price") - (productPrice * itemQuantity);
        session.setAttribute("price", totalPrice);

        ArrayList<String> data = new ArrayList<>();
        data.add("" + itemsCount);
        data.add("" + totalPrice);

        service.deleteItem(cartId, productId);
        return data;
    }
    @RequestMapping(value = "cart/update/deletecart", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCart(@RequestParam("cartId")String cartId, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.setAttribute("itemsCount", 0);
        session.setAttribute("price", 0);

        service.deleteCart(cartId);
    }

}
