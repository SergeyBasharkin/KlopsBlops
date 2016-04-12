package com.springapp.mvc.common.filters;

import com.springapp.mvc.common.GoodInfo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 04.04.2016.
 */
@Entity
@Table(name = "h_colors")
public class Colors {
    @Id
    private Integer id;

    private String name;

    @ManyToMany
            (cascade = CascadeType.REFRESH,
                    fetch = FetchType.LAZY)
    @JoinTable(name = "COLORS_GOODS",
            joinColumns = @JoinColumn(name = "COLOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "GOOD_ID"))
    private List<GoodInfo> goods;

    public Colors() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodInfo> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodInfo> goods) {
        this.goods = goods;
    }
}
