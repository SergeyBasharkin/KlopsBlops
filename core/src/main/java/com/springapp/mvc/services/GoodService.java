package com.springapp.mvc.services;

import com.springapp.mvc.common.GoodInfo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Admin on 28.02.2016.
 */
@Service
public class GoodService {
    public GoodInfo getGoodById(Long id){
        return new GoodInfo(id,"Новая игрушка",2L,new BigDecimal(3));
    }
}
