package com.springapp.mvc.common.filters;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 04.04.2016.
 */

public class CatalogFilterInfo {

    @Id
    private long id;
    @OneToMany
    @JoinColumn(name = "filter_id")
    private List<FilterItem> colors;
}
