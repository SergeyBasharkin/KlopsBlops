package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategoryInfo;
import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.SessionCartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.security.MyUserDetail;
import com.springapp.mvc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Admin on 28.02.2016.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SessionCartService sessionCartService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CartService cartService;
    @Autowired
    private GoodService goodService;
    /**
     * Отображение содержимого коорзины
     */

    @IncludeCategoryInfo
    @RequestMapping
    public String renderCart(Model model) {
        Map<String,GoodInfo> goods=new TreeMap<String, GoodInfo>();
        SessionCartInfo sessionCartInfo = sessionCartService.getCart(request.getSession());
        for(String i: sessionCartInfo.getGoods().keySet()){
            goods.put(i,goodService.getGood(Long.valueOf(i)));
        }

        model.addAttribute("cartGoods", goods);
        request.setAttribute("fCart", sessionCartInfo.getGoods());
        return "cart/cartPage";
    }

    /**
     * Добавление товара в корзину
     *
     * @param goodId id товара
     */

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addInCart(Long goodId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name=auth.getName();

        if (name.equals("anonymousUser")) {
            sessionCartService.addInCart(request.getSession(), goodId, 1);
        }else {
            MyUserDetail myUserDetail= (MyUserDetail) auth.getPrincipal();
            UserInfo userInfo=myUserDetail.getUserInfo();
            cartService.addToCart(userInfo.getId(),goodId,1,request.getSession());
        }
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/change",method = RequestMethod.POST)
    public Integer changeGood(Long id, Integer count){
        sessionCartService.addInCart(request.getSession(), id, count);
        if (sessionCartService.getCart(request.getSession()).getGoods().get(String.valueOf(id))>=1) {
            count = sessionCartService.getCart(request.getSession()).getGoods().get(String.valueOf(id));
            return count;
        }else {
            sessionCartService.removeInCart(request.getSession(),id);
            return 0;
        }
    }
}
