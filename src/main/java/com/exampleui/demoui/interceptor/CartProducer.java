package com.exampleui.demoui.interceptor;

import com.exampleui.demoui.service.ProductServiceFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartProducer extends HandlerInterceptorAdapter {

    @Autowired
    ProductServiceFace service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if(session.isNew()) {
            session.setMaxInactiveInterval(3600);
            String sessionId = session.getId();
            session.setAttribute("cartId",sessionId);
            session.setAttribute("itemsCount",0);
            session.setAttribute("price",0);
            service.setCartId(sessionId);
        }
        return true;
    }
}
