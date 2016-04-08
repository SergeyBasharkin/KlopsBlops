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

    public List<GoodInfo> getGoodsByCategoryIdOrderBy(String sort, Long id) {

        if (sort.equals("pricedesc")) {
            goods = catalogRepository.getGoodsByCatIdOrderByPriceDesc(id);
        }
        if (sort.equals("price")) {
            goods = catalogRepository.getGoodsByCatIdOrderByPrice(id);
        }
        if (sort.equals("name")) {
            goods = catalogRepository.getGoodsByCatIdOrderByName(id);
        }
        return goods;
    }
    public List<GoodInfo> getAllGoodsOrderBy(String sort) {
        if (sort.equals("pricedesc")) {
            goods = catalogRepository.getAllGoodsOrderByPriceDesc();
        }
        if (sort.equals("price")) {
            goods = catalogRepository.getAllGoodsOrderByPrice();
        }
        if (sort.equals("name")) {
            goods = catalogRepository.getAllGoodsOrderByName();
        }
        return goods;
    }

}
