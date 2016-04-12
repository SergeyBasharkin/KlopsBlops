package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.common.UserInfo;
import com.springapp.mvc.repositories.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Repository
public class UserRepositoryHibernate implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    @Override
    public void add(UserInfo userInfo) {
        curSession().save(userInfo);
    }

    @Override
    public UserInfo getUserByLogin(String login) {
        return (UserInfo) curSession().createCriteria(UserInfo.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }
}
