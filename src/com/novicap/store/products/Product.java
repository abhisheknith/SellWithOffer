package com.novicap.store.products;

import java.math.BigDecimal;

public final class Product {

    public Product() {
    }

    public Product(String code, String desc, BigDecimal price) {
        this.code = code;
        this.desc = desc;
        this.price = price;
    }

    // Should be useful while persisting.
    private String id;

    private String code;

    private String desc;

    private BigDecimal price;

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
