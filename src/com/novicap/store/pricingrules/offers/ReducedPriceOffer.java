package com.novicap.store.pricingrules.offers;

import java.math.BigDecimal;

public class ReducedPriceOffer extends Offer {

    public static final String REDUCED_PRICE = "ReducedPrice";

    public ReducedPriceOffer(String code, String productCode, int minimumProductCount, BigDecimal reducedPrice) {
        super(code, productCode, minimumProductCount);
        this.reducedPrice = reducedPrice;
    }

    private BigDecimal reducedPrice;

    @Override
    public String getType() {
        return REDUCED_PRICE;
    }

    public BigDecimal getReducedPrice() {
        return reducedPrice;
    }
}
