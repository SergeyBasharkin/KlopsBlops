package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategoryInfo;
import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.form.RegistrationFormBean;
import com.springapp.mvc.services.UserService;
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
 * Контроллер для регистрации новых пользователей
 *
 *
 */
@Controller
@RequestMapping("/reg")
public class RegistrationController {

    public static final String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;
    /**
     * Отображение страницы регистрации
     */
    @IncludeCategoryInfo
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationFormBean());
        return "registration/registrationPage";
    }

    /**
     * Обработка формы Регистрации
     */
    @IncludeCategoryInfo
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationFormBean registrationFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/registrationPage";
        }
        String hashPassword= DigestUtils.md5Hex(registrationFormBean.getConfirmPassword());
        UserInfo userInfo=new UserInfo(registrationFormBean.getLastName(),registrationFormBean.getEmail(),hashPassword,"ROLE_USER",registrationFormBean.getPhone(),true);
        userService.add(userInfo);
        return "redirect:/";
    }
}
