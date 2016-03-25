package com.springapp.mvc.services;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repositories.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by Admin on 28.02.2016.
 */
@Service
public class GoodService {
    @Autowired
    private GoodRepository goodRepository;

    public GoodInfo getGood(Long goodId) {
        return goodRepository.getGoodById(goodId);
    }

    @Transactional  // оборачивает данный метод в Транзакцию
    public void add(GoodInfo goodInfo) {
        goodRepository.addGood(goodInfo);
    }

    @Transactional  // оборачивает данный метод в Транзакцию
    public void update(GoodInfo goodInfo) {
        goodRepository.updateGood(goodInfo);
    }

    @Transactional  // оборачивает данный метод в Транзакцию
    public void delete(Long goodId) {
        goodRepository.deleteGood(goodId);
    }

}
