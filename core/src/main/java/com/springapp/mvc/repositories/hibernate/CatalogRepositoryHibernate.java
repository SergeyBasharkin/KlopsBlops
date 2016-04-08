package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repositories.CatalogRepository;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<GoodInfo> goods = (ArrayList<GoodInfo>) curSession().createCriteria(GoodInfo.class).addOrder(Order.asc("id")).list();
        return goods;
    }

    @Override
    public List<GoodInfo> getGoodsByParams(String color, String type, BigDecimal minPrice, BigDecimal maxPrice) {
        SQLQuery sqlQuery=curSession().createSQLQuery(
                "SELECT DISTINCT(h_goods.id),h_goods.price,h_goods.name,h_goods.description,h_goods.imageurl,h_goods.type,h_goods.category_id " +
                        "FROM h_goods, h_colors,colors_goods " +
                "WHERE ((h_colors.name in (:color)) AND (h_goods.type in (:types)) AND h_goods.price BETWEEN :minPrice AND :maxPrice )" +
                "AND h_colors.id=colors_goods.color_id AND h_goods.id=colors_goods.good_id").addEntity(GoodInfo.class);
        List<String> colors=Arrays.asList(color.split(","));
        Query query=sqlQuery.setParameterList("color", colors).setParameterList("types",Arrays.asList(type.split(","))).setBigDecimal("minPrice",minPrice).setBigDecimal("maxPrice",maxPrice);
        List<GoodInfo> goodsByCat=query.list() ;
        return goodsByCat;
    }

    @Override
    public List<GoodInfo> getGoodsByCatIdOrderByPriceDesc(Long id) {
        SQLQuery sqlQuery=curSession().createSQLQuery(
                "SELECT * FROM h_goods " +
                        "WHERE h_goods.category_id= :id ORDER BY h_goods.price DESC").addEntity(GoodInfo.class);
        Query query=sqlQuery.setParameter("id",id);
        List<GoodInfo> goods=query.list();
        return goods;
    }

    @Override
    public List<GoodInfo> getGoodsByCatIdOrderByPrice(Long id) {
        SQLQuery sqlQuery=curSession().createSQLQuery(
                "SELECT * FROM h_goods " +
                        "WHERE h_goods.category_id= :id ORDER BY h_goods.price ASC ").addEntity(GoodInfo.class);
        Query query=sqlQuery.setParameter("id",id);
        List<GoodInfo> goods=query.list();
        return goods;
    }

    @Override
    public List<GoodInfo> getGoodsByCatIdOrderByName(Long id) {
        SQLQuery sqlQuery=curSession().createSQLQuery(
                "SELECT * FROM h_goods " +
                        "WHERE h_goods.category_id= :id ORDER BY h_goods.name ASC ").addEntity(GoodInfo.class);
        Query query=sqlQuery.setParameter("id",id);
        List<GoodInfo> goods=query.list();
        return goods;
    }

    @Override
    public List<GoodInfo> getAllGoodsOrderByPriceDesc() {
        SQLQuery sqlQuery=curSession().createSQLQuery(
                "SELECT * FROM h_goods " +
                        "ORDER BY h_goods.price DESC ").addEntity(GoodInfo.class);
        List<GoodInfo> goods=sqlQuery.list();

        return goods;
    }

    @Override
    public List<GoodInfo> getAllGoodsOrderByPrice() {
        SQLQuery sqlQuery=curSession().createSQLQuery(
                "SELECT * FROM h_goods " +
                        " ORDER BY h_goods.price ASC ").addEntity(GoodInfo.class);
        List<GoodInfo> goods=sqlQuery.list();
        return goods;
    }

    @Override
    public List<GoodInfo> getAllGoodsOrderByName() {
        SQLQuery sqlQuery=curSession().createSQLQuery(
                "SELECT * FROM h_goods " +
                        "ORDER BY h_goods.name ASC ").addEntity(GoodInfo.class);
        List<GoodInfo> goods=sqlQuery.list();
        return goods;
    }
}
