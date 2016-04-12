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
import java.util.List;

/**
 * Created by Admin on 11.04.2016.
 */
@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    public void addToCart( UserInfo userInfo,GoodInfo goodInfo, Integer count, BigDecimal total){
        cartRepository.addToCart(new CartInfo(userInfo,goodInfo,1L,count,total));
    }
}
