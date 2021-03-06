package com.springapp.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by sergey on 27.07.16.
 */
public class GoodFormBean {
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String name;
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String description;
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String price;
    private MultipartFile file;



    @NotEmpty(message = "Поле обязательно для заполнения")
    private String category;

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    private Long goodId;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String type;





    public GoodFormBean() {
    }
}
