package com.springapp.mvc.repositories;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.GoodInfo;

import java.util.List;

/**
 * Created by Admin on 11.04.2016.
 */
public interface CartRepository {
    void addToCart(Long userId,Long good_id,Integer count);
    List<GoodInfo> getGoods(Long userId);
    Integer getCount(Long userId);
    CartInfo getCart(Long userId, Long goodId);
}
