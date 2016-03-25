package com.springapp.mvc.common;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "h_categories")
public class CategoryInfo {

    /**
     * id категории
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Название категории
     */
    private String name;

    /**
     * Список дочерних категорий
     */
    @OneToMany(mappedBy = "parent")
    private List<CategoryInfo> children;

    /**
     * Родительская категория
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CategoryInfo parent;

    public CategoryInfo() {
    }

    public CategoryInfo(Long id, String name, List<CategoryInfo> children) {
        this.id = id;
        this.name = name;
        this.children = children;
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

    public List<CategoryInfo> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryInfo> children) {
        this.children = children;
    }

    public CategoryInfo getParent() {
        return parent;
    }

    public void setParent(CategoryInfo parent) {
        this.parent = parent;
    }
}
