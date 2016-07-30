package com.springapp.mvc.controllers;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.common.OrderInfo;
import com.springapp.mvc.form.GoodFormBean;
import com.springapp.mvc.form.OrderFormBean;
import com.springapp.mvc.security.MyUserDetail;
import com.springapp.mvc.services.CategoryService;
import com.springapp.mvc.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;

/**
 * Created by sergey on 27.07.16.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GoodService goodService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping
    public String adminPanel(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        MyUserDetail admin= (MyUserDetail) authentication.getPrincipal();
        model.addAttribute("name",admin.getUserInfo().getFio());
        return "admin/welcome";
    }
    @RequestMapping(value = "/create_good", method = RequestMethod.GET)
    public String createGoodForm(){
        request.setAttribute("goodForm", new GoodFormBean());
        return "admin/createGood";
    }
    @RequestMapping(value = "/create_good", method = RequestMethod.POST)
    public String createGood(@Valid @ModelAttribute("goodForm")GoodFormBean goodFormBean,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "admin/createGood";
        }else{
            GoodInfo goodInfo=new GoodInfo(goodFormBean.getName(),goodFormBean.getDescription(),goodFormBean.getType(),categoryService.getCategoryInfoById(Long.valueOf(goodFormBean.getCategory())),goodFormBean.getImage(),new BigDecimal(goodFormBean.getPrice()));
            goodService.add(goodInfo);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/update_good", method = RequestMethod.POST)
    public String updateGood(@Valid @ModelAttribute("goodForm")GoodFormBean goodFormBean,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "admin/updateGood";
        }else{
            GoodInfo goodInfo=new GoodInfo(goodFormBean.getGoodId(), goodFormBean.getName(),goodFormBean.getDescription(),goodFormBean.getType(),categoryService.getCategoryInfoById(Long.valueOf(goodFormBean.getCategory())),goodFormBean.getImage(),new BigDecimal(goodFormBean.getPrice()));
            goodService.update(goodInfo);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/update/e")
    public String test(){
        return "sd";
    }
    @RequestMapping(value = "/update_good",method = RequestMethod.GET)
    public String createGoodForm(Long goodId){
        GoodInfo goodInfo=goodService.getGood(goodId);
        GoodFormBean goodFormBean=new GoodFormBean();
        goodFormBean.setCategory(String.valueOf(goodInfo.getCategory()));
        goodFormBean.setDescription(goodInfo.getDescription());
        goodFormBean.setImage(goodInfo.getImageUrl());
        goodFormBean.setName(goodInfo.getName());
        goodFormBean.setPrice(String.valueOf(goodInfo.getPrice()));
        goodFormBean.setType(goodInfo.getType());
        goodFormBean.setGoodId(goodId);
        request.setAttribute("goodForm", goodFormBean);
        request.setAttribute("id",goodId);
        return "admin/updateGood";
    }
}
