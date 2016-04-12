package com.springapp.mvc.repositories;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.common.UserInfo;

import java.util.List;

/**
 * Created by Admin on 11.04.2016.
 */
public interface CartRepository {
    void addToCart(CartInfo cartInfo);
    List<CartInfo> getUserCarts(UserInfo user);
    CartInfo getUserCartsByGood(GoodInfo good,UserInfo user);
    void updateCart(CartInfo cartInfo);

    void deleteCart(CartInfo cart);
}
