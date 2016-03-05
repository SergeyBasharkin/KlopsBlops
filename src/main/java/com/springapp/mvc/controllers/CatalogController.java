package com.springapp.mvc.controllers;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер отвечающий за каталог
 *
 * Gataullin Kamil
 * 22.02.2016 22:46
 */
@Controller
@RequestMapping("/catalog")
public class CatalogController {

    private static final Integer TEST_GOODS_COUNT = 16;
    private static final Integer TEST_LIMIT = 6;
    @Autowired
    private CatalogService catalogService;

    /**
     * Отображение каталога
     *
     * @param id    id категории
     * @param page  номер страницы
     * @param limit кол-во товаров отображаемых на странице
     * @return отображение каталога
     */



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderCatalog(@PathVariable("id") Long id,
                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                Long limit,
                                Model model) {
        List<GoodInfo> goods = catalogService.getGoodsByCategoryId(id);
        model.addAttribute("goods", goods);



        model.addAttribute("page", page);
        model.addAttribute("limit", limit == null ? TEST_LIMIT : limit);
        model.addAttribute("goodsCount", TEST_GOODS_COUNT);
        return "catalog/catalog";
    }
    @RequestMapping(value = "/showMore", method = RequestMethod.POST)
    public String showMoreGoods(Long id, Integer page, Integer limit, Model model) {
        // Эта страшная проверка с page и limit только для теста, так как у нас пока нет реальных данных
        List<GoodInfo> goods = catalogService.getGoodsByCategoryId(id);
        if (TEST_GOODS_COUNT + limit > page * limit){
            model.addAttribute("goods", (TEST_GOODS_COUNT> page * limit) ? goods : goods.subList(0, TEST_GOODS_COUNT + limit - page * limit));
        }
        return "catalog/ajaxGoods";
    }
    /**
     * Отображение главной страницы каталога
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String mainCatalog(HttpServletRequest request) {
        request.setAttribute("message", "Главная страница каталога");
        return "catalog/catalogMain";
    }
}
