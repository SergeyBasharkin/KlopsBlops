package com.springapp.mvc.repositories;

import com.springapp.mvc.common.CategoryInfo;

import java.util.List;

/**
 *
 */
public interface CategoryRepository {

    void addCategory(CategoryInfo categoryInfo);

    CategoryInfo getCategoryById(Long id);

    List<CategoryInfo> getAllCat();

    List<CategoryInfo> getParentCat();

    List<CategoryInfo> getChildCat(Long parentId);
}
