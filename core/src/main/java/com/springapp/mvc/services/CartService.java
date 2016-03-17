package com.springapp.mvc.services;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.util.Constants;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 28.02.2016.
 */
@Service
public class CartService {
    public static final String CART="sessionCart";


    public void addInCart(HttpSession session, Long goodId, Integer count) {
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        if (cart == null) {
            cart = new CartInfo();
        }
        if (cart.getGoods() == null) {
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            map.put(goodId, count);
            cart.setGoods(map);
        } else {
            if (cart.getGoods().containsKey(goodId)) {
                cart.getGoods().put(goodId, cart.getGoods().get(goodId) + count);
            } else {
                cart.getGoods().put(goodId, count);
            }
        }
        session.setAttribute(Constants.SESSION_CART, cart);
    }
    public void removeInCart(HttpSession session,Long goodId){
        CartInfo cart = (CartInfo) session.getAttribute(Constants.SESSION_CART);
        if (cart != null) {
            cart.getGoods().remove(goodId);
        }
    }

    public CartInfo getCart(HttpSession session){return (CartInfo) session.getAttribute(Constants.SESSION_CART);}
}
