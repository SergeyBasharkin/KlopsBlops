package com.springapp.mvc.common;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Admin on 11.04.2016.
 */
@Entity
@Table(name = "h_cart")
public class CartInfo {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "good_id")
    private GoodInfo goods;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo user;

    private Integer count;

    private BigDecimal total;

    public CartInfo(UserInfo user,GoodInfo goods,Long id, Integer count, BigDecimal total) {
        this.id=id;
        this.goods = goods;
        this.user = user;
        this.count = count;
        this.total=total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GoodInfo getGoods() {
        return goods;
    }

    public void setGoods(GoodInfo goods) {
        this.goods = goods;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public CartInfo() {

    }


}
