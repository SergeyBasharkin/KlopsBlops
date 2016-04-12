package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repositories.CartRepository;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 11.04.2016.
 */
@Repository
public class CartRepositoryHibernate implements CartRepository {
    @Autowired
    SessionFactory sessionFactory;

    private Session curSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addToCart(CartInfo cartInfo) {
        String count="count";
        SQLQuery sqlQuery=curSession().createSQLQuery("INSERT INTO h_cart(user_id, good_id,"+count+", total)" +
                " VALUES(:user_id,:good_id,:mycount,:total)").addEntity(CartInfo.class);
        Query query=sqlQuery.setLong("user_id",cartInfo.getUser().getId())
                .setLong("good_id",cartInfo.getGoods().getId())
                .setInteger("mycount",cartInfo.getCount())
                .setBigDecimal("total",cartInfo.getTotal());
        query.executeUpdate();
    }

    @Override
    public List<GoodInfo> getGoods(Long userId) {
        SQLQuery sqlQuery=curSession().createSQLQuery("SELECT h_goods.id,h_goods.type,h_goods.name,h_goods.category_id,h_goods.description,h_goods.imageurl,h_goods.price" +
                " FROM h_cart,h_goods WHERE user_id=:userId AND h_goods.id=h_cart.good_id").addEntity(GoodInfo.class);
        sqlQuery.setLong("userId",userId);
        List<GoodInfo> goods=sqlQuery.list();
        return goods;
    }

    @Override
    public Integer getCount(Long userId) {
        return null;
    }

    @Override
    public CartInfo getCart(Long id) {
       return (CartInfo) curSession().get(CartInfo.class,id);
    }
}
