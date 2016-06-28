package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.common.OrderInfo;
import com.springapp.mvc.repositories.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sergey on 13.04.16.
 */
@Repository
public class OrderRepositoryHibernate implements OrderRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    @Override
    public void save(OrderInfo orderInfo) {
        curSession().save(orderInfo);
    }
}
