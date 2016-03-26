package com.springapp.mvc.repositories.hibernate;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.repositories.CategoryRepository;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Gataullin Kamil
 * 16.03.2016 22:21
 */
@Repository
public class CategoryRepositoryHibernate implements CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCategory(CategoryInfo categoryInfo) {
        curSession().save(categoryInfo);
    }

    @Override
    public CategoryInfo getCategoryById(Long id) {
        return (CategoryInfo) curSession().get(CategoryInfo.class, id);
    }

    @Override
    public List<CategoryInfo> getAllCat() {
        ArrayList<CategoryInfo> categoryInfos = (ArrayList<CategoryInfo>) curSession().createCriteria(CategoryInfo.class).list();
        return categoryInfos;
    }

    @Override
    public List<CategoryInfo> getParentCat() {
        SQLQuery sqlQuery = curSession().createSQLQuery("SELECT * FROM h_categories WHERE id=h_categories.parent_id").addEntity(CategoryInfo.class);
        List<CategoryInfo> parentCat = sqlQuery.list();
        return parentCat;
    }

    @Override
    public List<CategoryInfo> getChildCat(Long parentId) {
        List<CategoryInfo> childCat = curSession().createCriteria(CategoryInfo.class)
                .add(Restrictions
                        .and(Restrictions.eq("parent", parentId), Restrictions.ne("id", parentId))).list();
        return childCat;
    }
}
