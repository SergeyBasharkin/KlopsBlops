package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repositories.GoodRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
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
    }

    @Override
    public void deleteGood(Long goodId) {
        curSession().delete(new GoodInfo(goodId));
    }

    @Override
    public GoodInfo getGoodById(Long goodId) {

        return (GoodInfo) curSession().get(GoodInfo.class, goodId);
    }
}
