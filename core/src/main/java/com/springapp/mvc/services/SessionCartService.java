package com.springapp.mvc.services;

import com.springapp.mvc.common.SessionCartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 28.02.2016.
 */
@Service
public class SessionCartService {
    public static final String CART="sessionCart";

    @Autowired
    GoodService goodService;


    public void addInCart(HttpSession session, Long goodId, Integer count) {
        SessionCartInfo cart = (SessionCartInfo) session.getAttribute(Constants.SESSION_CART);
        GoodInfo goodInfo=goodService.getGood(goodId);
        if (cart == null) {
            cart = new SessionCartInfo();
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
        SessionCartInfo cart = (SessionCartInfo) session.getAttribute(Constants.SESSION_CART);
        if (cart != null) {
            cart.getGoods().remove(String.valueOf(goodId));
        }
    }

    public Long setCountGoods(SessionCartInfo cart){
        HashMap<String,Integer> goods= (HashMap<String,Integer>) cart.getGoods();
        Long count=0L;
        for(String i:goods.keySet()){
            count+=goods.get(i);
        }
        return count;

    }

    private void updateCountAndTotal(GoodInfo goodInfo,Long count,SessionCartInfo cart){
        cart.setCount(cart.getCount()+count);
        cart.setTotal(cart.getTotal().add(goodInfo.getPrice().multiply(BigDecimal.valueOf(count))));
    }

    public SessionCartInfo getCart(HttpSession session){return (SessionCartInfo) session.getAttribute(Constants.SESSION_CART);}
}
