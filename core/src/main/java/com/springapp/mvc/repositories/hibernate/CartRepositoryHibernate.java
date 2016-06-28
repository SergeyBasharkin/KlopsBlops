package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.repositories.CartRepository;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 11.04.2016.
 */
@Repository
public class CartRepositoryHibernate implements CartRepository {
    @Autowired
    SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     *
     * @param cartInfo карзина которую мы добавляем
     */
    @Transactional
    @Override
    public void addToCart(CartInfo cartInfo) {
        String count="count";
        SQLQuery query=curSession().createSQLQuery("INSERT INTO h_cart(user_id, good_id,"+count+", total) " +
                "VALUES (:user_id,:good_id,:countc,:total)");
        Query query1=query.setLong("user_id",cartInfo.getUser().getId()).setLong("good_id",cartInfo.getGoods().getId())
                .setInteger("countc",cartInfo.getCount()).setBigDecimal("total",cartInfo.getTotal());
        query.executeUpdate();
    }

    /**
     * Получаем все товары пользователя
     * @param user пользователь
     * @return возвращаем товары
     */
    @Override
    public List<CartInfo> getUserCarts(UserInfo user) {
        return curSession().createCriteria(CartInfo.class).add(Restrictions.eq("user", user)).list();
    }

    /**
     * Берем товар пользователя в единственном экземпляре
     * @param good
     * @param user
     * @return
     */
    @Override
    public CartInfo getUserCartsByGood(GoodInfo good,UserInfo user) {
        if (curSession().createCriteria(CartInfo.class).add(Restrictions.and(Restrictions.eq("goods",good),Restrictions.eq("user",user))).list().size()==0){
            return null;
        }else return (CartInfo) curSession().createCriteria(CartInfo.class).add(Restrictions.and(Restrictions.eq("goods",good),Restrictions.eq("user",user))).list().get(0);
    }

    /**
     * Обновляем корзину
     * @param cartInfo
     */
    @Transactional
    @Override
    public void updateCart(CartInfo cartInfo) {
        curSession().update(cartInfo);
    }

    /**
     * Удаляем товар из корзины
     * @param cart
     */
    @Transactional
    @Override
    public void deleteCart(CartInfo cart) {
        curSession().delete(cart);
    }
}
