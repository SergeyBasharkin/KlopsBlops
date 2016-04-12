package com.springapp.mvc.common;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Admin on 11.04.2016.
 */

public class CartInfo {

    private List<GoodInfo> goods;

    private List<UserInfo> user;

    private Integer count;

    private BigDecimal total;

    public List<GoodInfo> getGoods() {
        return goods;
    }


    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setGoods(List<GoodInfo> goods) {
        this.goods = goods;
    }

    public List<UserInfo> getUser() {
        return user;
    }

    public void setUser(List<UserInfo> user) {
        this.user = user;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CartInfo() {

    }


}
