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

    @ManyToMany                                 // определяет отношение многие ко многим
            (cascade = CascadeType.REFRESH,
                    fetch = FetchType.LAZY)     // подгрузка объектов только при обращении к ним
    @JoinTable(name = "COLORS_GOODS",           // вспомогательная связывающая таблица для отношений многие ко многим
            joinColumns = @JoinColumn(name = "COLOR_ID"),        // название колонки для связи с текущей таблицей Orders
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
