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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Map<String, GoodInfo> goods = new TreeMap<String, GoodInfo>();
        if (name.equals("anonymousUser")) {

            SessionCartInfo sessionCartInfo = sessionCartService.getCart(request.getSession());
            for (String i : sessionCartInfo.getGoods().keySet()) {
                goods.put(i, goodService.getGood(Long.valueOf(i)));
            }

            model.addAttribute("cartGoods", goods);
            request.setAttribute("fCart", sessionCartInfo.getGoods());
        } else {
            MyUserDetail myUserDetail = (MyUserDetail) auth.getPrincipal();
            UserInfo userInfo = myUserDetail.getUserInfo();
            List<CartInfo> cart = cartService.getUserCarts(userInfo);
            goods = new TreeMap<String, GoodInfo>();
            Map<String, Integer> fCart = new HashMap<String, Integer>();
            for (CartInfo cartInfo : cart) {
                fCart.put(String.valueOf(cartInfo.getGoods().getId()), cartInfo.getCount());
                goods.put(String.valueOf(cartInfo.getGoods().getId()), cartInfo.getGoods());
            }
            model.addAttribute("cartGoods", goods);
            request.setAttribute("fCart", fCart);
        }
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
        String name = auth.getName();

        if (name.equals("anonymousUser")) {
            sessionCartService.addInCart(request.getSession(), goodId, 1);
        } else {
            MyUserDetail myUserDetail = (MyUserDetail) auth.getPrincipal();
            UserInfo userInfo = myUserDetail.getUserInfo();
            if (cartService.getUserCartsByGood(goodService.getGood(goodId),userInfo) == null) {
                cartService.addToCart(userInfo, goodService.getGood(goodId), 1, goodService.getGood(goodId).getPrice(),request.getSession());
            } else {
                cartService.updateGood(goodService.getGood(goodId),1,userInfo,request.getSession());
            }
        }
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public Integer changeGood(Long id, Integer count) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        if (name.equals("anonymousUser")) {

            sessionCartService.addInCart(request.getSession(), id, count);
            if (sessionCartService.getCart(request.getSession()).getGoods().get(String.valueOf(id)) >= 1) {
                count = sessionCartService.getCart(request.getSession()).getGoods().get(String.valueOf(id));
                return count;
            } else {
                sessionCartService.removeInCart(request.getSession(), id);
                return 0;
            }
        } else {
            MyUserDetail myUserDetail = (MyUserDetail) auth.getPrincipal();
            UserInfo userInfo = myUserDetail.getUserInfo();
            cartService.updateGood(goodService.getGood(id),count,userInfo,request.getSession());
            if (cartService.getUserCartsByGood(goodService.getGood(id),userInfo).getCount()>=1){
                count =cartService.getUserCartsByGood(goodService.getGood(id),userInfo).getCount();
                return count;
            }else {

                cartService.removeInCart(cartService.getUserCartsByGood(goodService.getGood(id),userInfo),request.getSession());
                return 0;
            }

        }
    }
}
