package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategoryInfo;
import com.springapp.mvc.common.OrderInfo;
import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.form.OrderFormBean;
import com.springapp.mvc.form.RegistrationFormBean;
import com.springapp.mvc.services.OrderService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by sergey on 13.04.16.
 */
@Controller
@RequestMapping("/ord")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private HttpServletRequest request;
    @IncludeCategoryInfo
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute("ordForm")OrderFormBean orderFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "order/order";
        }else{
            OrderInfo orderInfo=new OrderInfo(orderFormBean.getFirstName(),orderFormBean.getLastName(),orderFormBean.getEmail(),orderFormBean.getPhone());
            orderService.save(orderInfo);
        }
        return "redirect:/";
    }

    @IncludeCategoryInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute("ordForm", new RegistrationFormBean());
        return "order/order";
    }
}
