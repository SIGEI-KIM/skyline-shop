package com.sigei.Skyline_Shops.model.request;

import com.sigei.Skyline_Shops.dblayer.entity.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequest {

    private Integer id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
}
