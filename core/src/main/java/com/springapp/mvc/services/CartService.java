package com.springapp.mvc.services;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.repositories.CartRepository;
import com.springapp.mvc.util.Constants;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Admin on 11.04.2016.
 */
@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    public void addToCart(Long userId, Long good_id, Integer count, HttpSession session){
        cartRepository.addToCart(userId,good_id,count);
        CartInfo cartInfo= cartRepository.getCart(userId,good_id);
        String a="";
    }
}
