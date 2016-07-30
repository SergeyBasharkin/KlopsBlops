package com.springapp.mvc.services;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.repositories.CategoryRepository;
import com.springapp.mvc.repositories.hibernate.CategoryRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 25.03.2016.
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepositoryHibernate;

    public List<CategoryInfo> getAllCat(){
        return categoryRepositoryHibernate.getAllCat();
    }

    public CategoryInfo getCategoryInfoById(Long id){
        return categoryRepositoryHibernate.getCategoryById(id);
    }
    public List<CategoryInfo> getParentCat(){
        return categoryRepositoryHibernate.getParentCat();
    }

    public List<CategoryInfo> getChildCat(Long parentId){
        return categoryRepositoryHibernate.getChildCat(parentId);
    }
}
