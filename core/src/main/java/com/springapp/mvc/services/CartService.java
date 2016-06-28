package com.springapp.mvc.services;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.repositories.CartRepository;
import com.springapp.mvc.util.Constants;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 11.04.2016.
 */
@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;


    public void addToCart( UserInfo userInfo,GoodInfo goodInfo, Integer count, BigDecimal total,HttpSession session){
        cartRepository.addToCart(new CartInfo(userInfo,goodInfo,count,total));
        updateCountAndPrice(userInfo,session);
    }
    public List<CartInfo> getUserCarts(UserInfo userInfo){
        return cartRepository.getUserCarts(userInfo);
    }

    public CartInfo getUserCartsByGood(GoodInfo goodInfo,UserInfo user){
        return cartRepository.getUserCartsByGood(goodInfo,user);
    }

    public void updateGood(GoodInfo goodInfo,Integer count,UserInfo user,HttpSession session){
        CartInfo cartInfo=cartRepository.getUserCartsByGood(goodInfo,user);
        cartInfo.setCount(cartInfo.getCount()+count);
        BigDecimal total=cartInfo.getTotal().add(goodInfo.getPrice().multiply(BigDecimal.valueOf(count)));
        cartInfo.setTotal(total);
        cartRepository.updateCart(cartInfo);

        updateCountAndPrice(user,session);


    }


    public void removeInCart(CartInfo cart,HttpSession session) {
        cartRepository.deleteCart(cart);
        updateCountAndPrice(cart.getUser(),session);
    }


    private void updateCountAndPrice(UserInfo userInfo,HttpSession session){
        List<CartInfo> userCarts=cartRepository.getUserCarts(userInfo);
        int totalCount=0;
        BigDecimal totalPrice=new BigDecimal(0);
        for (CartInfo cart:userCarts){
            totalCount+=cart.getCount();
            totalPrice=totalPrice.add(cart.getTotal());
        }
        session.setAttribute("totalCount",totalCount);
        session.setAttribute("totalPrice",totalPrice);
    }
}
