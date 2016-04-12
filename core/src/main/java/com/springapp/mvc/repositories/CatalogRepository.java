package com.springapp.mvc.repositories;

import com.springapp.mvc.common.GoodInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Admin on 26.03.2016.
 */
public interface CatalogRepository {
    List<GoodInfo> getGoodsByCatId(Long catId);
    List<GoodInfo> getAllGoods();
    List<GoodInfo> getGoodsByParams(String color,String type,BigDecimal minPrice, BigDecimal maxPrice);
}
