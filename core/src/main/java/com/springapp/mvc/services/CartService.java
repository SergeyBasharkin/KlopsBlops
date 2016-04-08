package com.springapp.mvc.services;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 28.02.2016.
 */
@Service
public class CartService {
    public static final String CART="sessionCart";

    @Autowired
    GoodService goodService;


    public void addInCart(HttpSession session, Long goodId, Integer count) {
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        GoodInfo goodInfo=goodService.getGood(goodId);
        if (cart == null) {
            cart = new CartInfo();
        }
        if (cart.getGoods() == null) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put(String.valueOf(goodId), count);
            cart.setGoods(map);
            cart.setCount((long)count);
            cart.setTotal(goodInfo.getPrice());
        } else {
            if (cart.getGoods().containsKey(String.valueOf(goodId))) {
                cart.getGoods().put(String.valueOf(goodId), cart.getGoods().get(String.valueOf(goodId)) + count);
            } else {
                cart.getGoods().put(String.valueOf(goodId), count);
            }
            updateCountAndTotal(goodInfo, Long.valueOf(count),cart);
        }
        session.setAttribute(Constants.SESSION_CART, cart);
    }
    public void removeInCart(HttpSession session,Long goodId){
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        if (cart != null) {
            cart.getGoods().remove(String.valueOf(goodId));
        }
    }

    public Long setCountGoods(CartInfo cart){
        HashMap<String,Integer> goods= (HashMap<String,Integer>) cart.getGoods();
        Long count=0L;
        for(String i:goods.keySet()){
            count+=goods.get(i);
        }
        return count;

    }

    private void updateCountAndTotal(GoodInfo goodInfo,Long count,CartInfo cart){
        cart.setCount(cart.getCount()+count);
        cart.setTotal(cart.getTotal().add(goodInfo.getPrice().multiply(BigDecimal.valueOf(count))));
    }

    public CartInfo getCart(HttpSession session){return (CartInfo) session.getAttribute(Constants.SESSION_CART);}
}
