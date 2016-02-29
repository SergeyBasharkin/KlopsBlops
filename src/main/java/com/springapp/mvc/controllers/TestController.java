package com.springapp.mvc.controllers;

import com.springapp.mvc.common.GoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Контроллер для тестовых запросов
 *
 * Gataullin Kamil
 * 25.02.2016 22:25
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/freemarker", method = RequestMethod.GET)
    public String freemarkerTest() {
        request.setAttribute("param1", "value1");
        request.setAttribute("list", Arrays.asList("Пушкин", "Горький", "Толстой"));
        request.setAttribute("testMap", getTestMap());
        request.setAttribute("goodObject", new GoodInfo(12L, "Название товара", 15L, new BigDecimal(1000)));
        return "test/freemarker";
    }

    private Map<String, Long> getTestMap() {
        Map<String, Long> map = new HashMap<String, Long>();
        map.put("key1", 100L);
        map.put("key2", 200L);
        map.put("key3", 300L);
        map.put("key4", 400L);
        map.put("key5", 500L);
        return map;
    }
}
