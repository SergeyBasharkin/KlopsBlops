package com.springapp.mvc.common;

import java.util.Map;

/**
 * Содержимое корзины
 *
 * Gataullin Kamil
 * 02.03.2016 0:23
 */
public class CartInfo {

    /**
     * key - id товара, value - кол-во товара
     */
    private Map<Long, Integer> goods;

    public Map<Long, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Long, Integer> goods) {
        this.goods = goods;
    }
}
