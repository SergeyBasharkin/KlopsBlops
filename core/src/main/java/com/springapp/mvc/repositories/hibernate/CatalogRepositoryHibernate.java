package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repositories.CatalogRepository;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 26.03.2016.
 */
@Repository
public class CatalogRepositoryHibernate implements CatalogRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<GoodInfo> getGoodsByCatId(Long catId) {
        SQLQuery sqlQuery = curSession().createSQLQuery("SELECT * FROM h_goods WHERE category_id= :cat_id ").addEntity(GoodInfo.class);
        Query query = sqlQuery.setLong("cat_id", catId);
        List<GoodInfo> goodsByCat = query.list();
        return goodsByCat;
    }

    @Override
    public List<GoodInfo> getAllGoods() {
        ArrayList<GoodInfo> goods = (ArrayList<GoodInfo>) curSession().createCriteria(GoodInfo.class).list();
        return goods;
    }
}
