package com.novicap.store.pricingrules.offers;

public abstract class Offer {

    public Offer(String code, String productCode, int minimumProductCount) {
        this.code = code;
        this.productCode = productCode;
        this.minimumProductCount = minimumProductCount;
    }

    private String id;

    private String code;

    private String productCode;

    private int minimumProductCount;

    public String getCode() {
        return code;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getMinimumProductCount() {
        return minimumProductCount;
    }

    public abstract String getType();
}
