package com.springapp.mvc.common;

import java.math.BigDecimal;
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
    private Map<String, Integer> goods;

    private Long count;

    private BigDecimal total;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Map<String, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<String, Integer> goods) {
        this.goods = goods;
    }

    public boolean containsGoodId(Long goodId){
        if (goods == null || goodId == null)
            return false;
        return goods.containsKey(String.valueOf(goodId));
    }
}
