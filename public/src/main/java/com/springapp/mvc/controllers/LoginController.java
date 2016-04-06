package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Gataullin Kamil
 * 27.03.2016 22:24
 */
@Controller
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @IncludeCategoryInfo
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLoginPage(Boolean error) {
        request.setAttribute("error", error);
        return "login/login";
    }
}
