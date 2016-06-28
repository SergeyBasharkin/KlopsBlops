package com.springapp.mvc.repositories;

import com.springapp.mvc.common.OrderInfo;

/**
 * Created by sergey on 13.04.16.
 */
public interface OrderRepository {
    void save(OrderInfo orderInfo);
}
