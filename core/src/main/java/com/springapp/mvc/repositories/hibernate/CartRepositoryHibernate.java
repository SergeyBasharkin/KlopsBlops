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
    public void addToCart(Long userId,Long good_id,Integer count) {
        SQLQuery sqlQuery= curSession().createSQLQuery("INSERT INTO h_cart(user_id, good_id, count) VALUES(:userId,:goodId,:mycount) ");
        Query query=sqlQuery.setLong("userId",userId).setLong("goodId",good_id).setLong("mycount",count);
        query.executeUpdate();
    }

    @Override
    public List<GoodInfo> getGoods(Long userId) {
        SQLQuery sqlQuery=curSession().createSQLQuery("SELECT h_goods.id,h_goods.type,h_goods.name,h_goods.category_id,h_goods.description,h_goods.imageurl,h_goods.price" +
                " FROM h_cart,h_goods WHERE user_id=:userId AND h_goods.id=h_cart.good_id");
        sqlQuery.setLong("userId",userId);
        return sqlQuery.list();
    }

    @Override
    public Integer getCount(Long userId) {
        return null;
    }

    @Override
    public CartInfo getCart(Long userId, Long goodId) {
        SQLQuery sqlQuery=curSession().createSQLQuery("SELECT * FROM h_cart WHERE user_id=:userId AND good_id=:goodId");
        Query query=sqlQuery.setLong("userId",userId).setLong("goodId",goodId);
//        CartInfo cartInfo=new CartInfo(result.get(0).)
        return  null;
    }
}
