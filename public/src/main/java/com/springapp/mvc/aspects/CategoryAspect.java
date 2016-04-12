package com.springapp.mvc.aspects;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.services.CategoryService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Admin on 25.03.2016.
 */
@Aspect
@Component
public class CategoryAspect {

    private static final String CATEGORY_LIST="catList";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CategoryService categoryService;

    @Pointcut("@annotation(com.springapp.mvc.aspects.annotation.IncludeCategoryInfo)")
    public void includeCategoryInfoMethod() {
    }

    @Before("includeCategoryInfoMethod()")
    public void includeCategoryInfo(){
        List<CategoryInfo> categoryInfos=categoryService.getAllCat();
        List<CategoryInfo> parentCat=categoryService.getParentCat();
        request.setAttribute(CATEGORY_LIST,categoryInfos);
        request.setAttribute("parentCat",parentCat);
        request.setAttribute("childCat",categoryService);
    }
}
