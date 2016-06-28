package com.springapp.mvc.common;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Основная информация о товаре
 *
 *
 */
@Entity
@Table(name = "h_goods")
public class GoodInfo {

    /**
     * id товара
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Название товара
     */
    private String name;

    /**
     * Описание товара
     */
    private String description;

    /**
     * Тип товара mechanical,battery
     */
    private String type;

    /**
     * id категории товара
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryInfo category;


    /**
     * URL изображения
     */
    private String imageUrl;
    /**
     * Цена
     */
    private BigDecimal price;

    public GoodInfo(Long id) {
        this.id = id;
    }

    public GoodInfo(Long id, String name, CategoryInfo category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public GoodInfo(Long id, String name, String imageUrl, CategoryInfo category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.category = category;
        this.price = price;
    }

    public GoodInfo(Long id, String name, String description, String imageUrl, CategoryInfo category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.price = price;
    }

    public GoodInfo(long id, String name, Long categoryId, BigDecimal price) {
        this.id = id;
        this.name=name;
        this.price = price;
    }


    public Long getId() {

        return id;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CategoryInfo getCategory() {
        return category;
    }

    public void setCategory(CategoryInfo category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public GoodInfo() {
    }

    public GoodInfo(String name) {
        this.name = name;
    }

    public GoodInfo(BigDecimal price) {
        this.price = price;
    }
}
