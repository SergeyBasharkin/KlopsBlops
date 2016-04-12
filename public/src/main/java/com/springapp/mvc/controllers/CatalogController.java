package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Контроллер отвечающий за каталог
 * <p>
 * Gataullin Kamil
 * 22.02.2016 22:46
 */
@Controller
@RequestMapping(value = "/catalog", method = {RequestMethod.POST, RequestMethod.GET})
public class CatalogController {

    private static final Integer TEST_LIMIT = 6;
    @Autowired
    private CatalogService catalogService;

    @Autowired
    private HttpServletRequest request;

    /**
     * Отображение каталога
     *
     * @param id    id категории
     * @param page  номер страницы
     * @param limit кол-во товаров отображаемых на странице
     * @return отображение каталога
     */

    @IncludeCategoryInfo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderCatalog(@PathVariable("id") Long id,
                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                Long limit,
                                Model model) {
        List<GoodInfo> goods = catalogService.getGoodsByCategoryId(id);
        model.addAttribute("goods", goods);


        model.addAttribute("catalogId", id);
        model.addAttribute("page", page);
        model.addAttribute("limit", limit == null ? TEST_LIMIT : limit);
        model.addAttribute("goodsCount", goods.size());
        return "catalog/catalog";
    }

    @RequestMapping(value = "/showMore", method = RequestMethod.POST)
    public String showMoreGoods(Long id, Integer page, Integer limit, Model model) {
        List<GoodInfo> goods = (List<GoodInfo>) request.getSession().getAttribute("goodsForShowMore");
        if (goods != null) {
            if (goods.size() > page * limit) {
                goods = goods.subList((page - 1) * limit, (page - 1) * limit + limit);
            } else {
                goods = goods.subList((page - 1) * limit, goods.size());
            }
            model.addAttribute("goodsCount", goods.size());
            model.addAttribute("goods", goods);
        } else {
            if (id == 0) {
                goods = catalogService.getAllGoods();
            } else {
                goods = catalogService.getGoodsByCategoryId(id);
            }
            model.addAttribute("goodsCount", goods.size());

            if (goods.size() > page * limit) {
                goods = goods.subList((page - 1) * limit, (page - 1) * limit + limit);
            } else {
                goods = goods.subList((page - 1) * limit, goods.size());
            }
            model.addAttribute("goods", goods);
        }
        return "catalog/ajaxGoodsAdd";
    }

    /**
     * Отображение главной страницы каталога
     */

    @IncludeCategoryInfo
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String mainCatalog(Model model,
                              @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              Long limit) {
        List<GoodInfo> goods = catalogService.getAllGoods();
        model.addAttribute("goods", goods);

        model.addAttribute("page", page);
        model.addAttribute("limit", limit == null ? TEST_LIMIT : limit);
        model.addAttribute("goodsCount", goods.size());
        return "catalog/catalog";
    }

    @IncludeCategoryInfo
    @RequestMapping(value = "/filters", method = {RequestMethod.GET, RequestMethod.POST})
    public String filters(Model model, @RequestParam(value = "color", defaultValue = "") String color, @RequestParam(defaultValue = "") String type, BigDecimal minPrice, BigDecimal maxPrice, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                          Long limit, @RequestParam(value = "sort") String sort) {
        List<GoodInfo> goods = catalogService.getGoodsByParam(color, type, minPrice, maxPrice);
        request.getSession().setAttribute("goodsForShowMore", goods);

        goods = catalogService.sortBy(sort, goods);
        model.addAttribute("goods", goods);
        model.addAttribute("page", page);
        model.addAttribute("sort", sort);
        model.addAttribute("limit", limit == null ? TEST_LIMIT : limit);
        model.addAttribute("goodsCount", goods.size());
        if (request.getMethod().equals("POST")) {
            return "catalog/ajaxGoods";
        } else return "catalog/catalog";
    }

}
