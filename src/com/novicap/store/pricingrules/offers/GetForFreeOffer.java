package com.novicap.store.pricingrules.offers;

public class GetForFreeOffer extends Offer {

    public static final String GET_FOR_FREE = "GetForFree";

    /**
     * Create offer with rule of getting few extra on buying threshold.
     *
     * @param code
     * @param productCode
     * @param minimumProductCount should always be greater than freeItemsCount. Represents count after including free items as well.
     * @param freeItemsCount
     */
    public GetForFreeOffer(String code, String productCode, int minimumProductCount, int freeItemsCount) {
        super(code, productCode, minimumProductCount);
        this.freeItemsCount = freeItemsCount;
        this.billableItems = minimumProductCount - freeItemsCount;
    }

    private int freeItemsCount;
    private int billableItems;

    @Override
    public String getType() {
        return GET_FOR_FREE;
    }

    public int getFreeItemsCount() {
        return freeItemsCount;
    }

    public int getBillableItems() {
        return billableItems;
    }
}
