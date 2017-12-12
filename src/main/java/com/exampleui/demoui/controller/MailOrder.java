package com.exampleui.demoui.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/email")
public class MailOrder {

    @Autowired
    MailSender mailSender;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void sendEmail(@RequestParam("cartID")String cartId,
                          @RequestParam("totalPrice")String sum,
                          @RequestParam("email")String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Заказ получен");
        message.setText("Ваш номер заказа " + cartId + ", на сумму " + sum + " рублей." );
        mailSender.send(message);
    }
}
