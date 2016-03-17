package com.springapp.mvc.controllers;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.CartService;
import com.springapp.mvc.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 28.02.2016.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CartService cartService;
    @Autowired
    private CatalogService catalogService;

    /**
     * Отображение содержимого коорзины
     */
    @RequestMapping
    public String renderCart(Model model) {
        List<GoodInfo> goods = catalogService.getGoodsByCategoryId((long) 1);
        model.addAttribute("goods", goods);
        CartInfo cartInfo=cartService.getCart(request.getSession());
        Map<String,Integer> cartFreemarker=new HashMap<String, Integer>();
        for (Long aLong: cartInfo.getGoods().keySet()){
            cartFreemarker.put(String.valueOf(aLong),cartInfo.getGoods().get(aLong));

        }
        request.setAttribute("fCart",cartFreemarker);
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
        cartService.addInCart(request.getSession(), goodId, 1);

        return "ok";
    }
    @ResponseBody
    @RequestMapping(value = "/change",method = RequestMethod.POST)
    public Integer changeGood(Long id, Integer count){
        cartService.addInCart(request.getSession(), id, count);
        if (cartService.getCart(request.getSession()).getGoods().get(id)>=1) {
            count = cartService.getCart(request.getSession()).getGoods().get(id);
            return count;
        }else {
            cartService.removeInCart(request.getSession(),id);
            return 0;
        }
    }
}
