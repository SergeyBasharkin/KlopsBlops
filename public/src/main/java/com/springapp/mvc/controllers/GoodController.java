package com.springapp.mvc.controllers;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 07.03.2016.
 */
@Controller
@RequestMapping(value = "/good", method = RequestMethod.GET)
public class GoodController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String goodInfo(@PathVariable("id") Long id){
        GoodInfo good=goodService.getGood(id);
        request.setAttribute("good",good);
        return "good/goodPage";
    }

    @ResponseBody
    @RequestMapping(value = "/details/{id}",method = RequestMethod.POST)
    public GoodInfo getInfo(@PathVariable("id") Long id){
        return goodService.getGood(id);
    }
}
