package com.springapp.mvc.common;

import java.math.BigDecimal;

/**
 * Основная информация о товаре
 *
 * Gataullin Kamil
 * 22.02.2016 22:54
 */
public class GoodInfo {

    /**
     * id товара
     */
    private Long id;

    /**
     * Название товара
     */
    private String name;

    /**
     * id категории товара
     */
    private Long categoryId;

    /**
     * Цена
     */
    private BigDecimal price;

    public GoodInfo() {
    }

    public GoodInfo(Long id, String name, Long categoryId, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecoratedName() {
        return "*** " + name + " ***";
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
