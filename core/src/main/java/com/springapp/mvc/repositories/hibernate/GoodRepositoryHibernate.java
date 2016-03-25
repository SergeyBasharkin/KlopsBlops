package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repositories.GoodRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Gataullin Kamil
 * 16.03.2016 22:01
 */
@Repository
public class GoodRepositoryHibernate implements GoodRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addGood(GoodInfo goodInfo) {
        curSession().save(goodInfo);
    }

    @Override
    public void updateGood(GoodInfo goodInfo) {
        curSession().update(goodInfo);
        // а если его еще нет, то лучше сохранить его
//        curSession().saveOrUpdate(goodInfo);
    }

    @Override
    public void deleteGood(Long goodId) {
        // удаление происходит только по сравнению id, поэтому весь объект нам и не нужен
        curSession().delete(new GoodInfo(goodId));
    }

    @Override
    public GoodInfo getGoodById(Long goodId) {
        // 1. It will always return a “proxy” (Hibernate term) without hitting the database.
        //    In Hibernate, proxy is an object with the given identifier value,
        //    its properties are not initialized yet, it just look like a temporary fake object.
        // 2. If no row found , it will throws an ObjectNotFoundException.
//        return (GoodInfo) curSession().load(GoodInfo.class, goodId);

        // 1. It always hit the database and return the real object,
        //    an object that represent the database row, not proxy.
        // 2. If no row found , it return null.
        return (GoodInfo) curSession().get(GoodInfo.class, goodId);

        // Запрос через Критерий. Можно и так. Но зачем?
//        return (GoodInfo) curSession().createCriteria(GoodInfo.class).add(Restrictions.idEq(goodId));
    }
}
