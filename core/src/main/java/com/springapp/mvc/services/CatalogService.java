package com.springapp.mvc.services;

import com.springapp.mvc.common.GoodInfo;
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
    public List<GoodInfo> getGoodsByCategoryId(Long categoryId) {
        List<GoodInfo> goods = new ArrayList<GoodInfo>();
        goods.add(new GoodInfo(1L, "Медведь", categoryId, new BigDecimal(100)));
        goods.add(new GoodInfo(2L, "Кукла 1", categoryId, new BigDecimal(200)));
        goods.add(new GoodInfo(3L, "Кукла 2", categoryId, new BigDecimal(200)));
        goods.add(new GoodInfo(4L, "Кукла 3", categoryId, new BigDecimal(200)));
        goods.add(new GoodInfo(5L, "Кукла 4", categoryId, new BigDecimal(200)));
        goods.add(new GoodInfo(6L, "Автомобиль Aud", categoryId, new BigDecimal(500)));

        return goods;
    }

}
