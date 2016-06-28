package com.springapp.mvc.services;

import com.springapp.mvc.common.OrderInfo;
import com.springapp.mvc.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sergey on 13.04.16.
 */
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public void save(OrderInfo orderInfo){
        orderRepository.save(orderInfo);
    }
}
