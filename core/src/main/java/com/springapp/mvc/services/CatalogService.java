package com.springapp.mvc.services;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repositories.CatalogRepository;
import com.springapp.mvc.repositories.CategoryRepository;
import com.springapp.mvc.repositories.hibernate.CategoryRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с категориями товаров
 *
 * Gataullin Kamil
 * 22.02.2016 23:23
 */
@Service
public class CatalogService {

    /**
     * Получение товаров по id категории
     *
     * @param categoryId id категории
     * @return список товаров
     */
    @Autowired
    CatalogRepository catalogRepository;

    public List<GoodInfo> getGoodsByCategoryId(Long categoryId) {
        List<GoodInfo> goods=catalogRepository.getGoodsByCatId(categoryId);

        return goods;
    }
    public List<GoodInfo> getAllGoods(){
        List<GoodInfo> goods=catalogRepository.getAllGoods();

        return goods;
    }

    public List<GoodInfo> getGoodsByParam(String color,String type,BigDecimal minPrice,BigDecimal maxPrice){
      List<GoodInfo> goods=catalogRepository.getGoodsByParams(color,type,minPrice,maxPrice);
    return goods;
    }

}
