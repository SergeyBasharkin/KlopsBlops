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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Сервис для работы с категориями товаров
 * <p>
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
    private List<GoodInfo> goods;

    public List<GoodInfo> getGoodsByCategoryId(Long categoryId) {
        goods = catalogRepository.getGoodsByCatId(categoryId);

        return goods;
    }

    public List<GoodInfo> getAllGoods() {
        goods = catalogRepository.getAllGoods();

        return goods;
    }

    public List<GoodInfo> getGoodsByParam(String color, String type, BigDecimal minPrice, BigDecimal maxPrice) {
        goods = catalogRepository.getGoodsByParams(color, type, minPrice, maxPrice);
        return goods;
    }


    public List<GoodInfo> sortBy(String sort,List<GoodInfo> goods){
        if (sort.equals("price")){
            Collections.sort(goods, new Comparator<GoodInfo>() {
                @Override
                public int compare(GoodInfo o1, GoodInfo o2) {
                    return o1.getPrice().compareTo(o2.getPrice());
                }
            });
            return goods;
        }
        if (sort.equals("name")){
            Collections.sort(goods, new Comparator<GoodInfo>() {
                @Override
                public int compare(GoodInfo o1, GoodInfo o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }
        if (sort.equals("pricedesc")){
            Collections.sort(goods, new Comparator<GoodInfo>() {
                @Override
                public int compare(GoodInfo o1, GoodInfo o2) {
                    return o2.getPrice().compareTo(o1.getPrice());
                }
            });
        }
        return goods;
    }
}
