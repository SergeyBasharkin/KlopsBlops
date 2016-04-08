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
 * Gataullin Kamil
 * 12.03.2016 22:53
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
//            RegistrationFormBean registrationFormBean, // TODO хотя работает и без этой аннотации, обычно её используют для переименования аргумента
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/registrationPage";
        }
        // здесь должна происходить регистрация пользователя
        String hashPassword= DigestUtils.md5Hex(registrationFormBean.getConfirmPassword());
        UserInfo userInfo=new UserInfo(registrationFormBean.getLastName(),registrationFormBean.getEmail(),hashPassword,"ROLE_USER","1234",true);
        userService.add(userInfo);
        System.out.println(registrationFormBean);
        return "registration/result";
    }
}
