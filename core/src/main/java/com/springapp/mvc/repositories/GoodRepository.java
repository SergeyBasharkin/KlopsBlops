package com.springapp.mvc.repositories;

import com.springapp.mvc.common.GoodInfo;

/**
 * Gataullin Kamil
 * 07.03.2016 0:17
 */
public interface GoodRepository {

    void addGood(GoodInfo goodInfo);

    void updateGood(GoodInfo goodInfo);

    void deleteGood(Long goodId);

    GoodInfo getGoodById(Long goodId);
}
