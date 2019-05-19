package com.novicap.store.pricingrules.offers;

import com.novicap.store.pricingrules.offers.GetForFreeOffer;
import com.novicap.store.pricingrules.offers.Offer;
import com.novicap.store.pricingrules.offers.ReducedPriceOffer;

import java.math.BigDecimal;
import java.util.*;

/**
 * Similar to product manager, this should be extracted to interface, have abilities to register/deregister offers,
 * extend validity dates of offers.
 * This should have a persist layer where from where it will initialize itself.
 * For now I will write everything in constructor to get POC running.
 */
public class OfferManager {

    private static OfferManager instance;

    /**
     * Data structure largely depends on use case.
     * In current scenario, we will almost always query for applicable offers on a product hence keeping it like this.
     * If product hierarchy is introduced then this might get affected.
     */
    private Map<String, List<Offer>> productOffers;

    public synchronized static OfferManager getInstance() {
        if (instance == null) {
            instance = new OfferManager();
        }
        return instance;
    }

    private OfferManager() {
        productOffers = new HashMap<>();
        productOffers.put("VOUCHER", Arrays.asList(new GetForFreeOffer("BUY_TWO_GET_ONE_FOR_VOUCHER", "VOUCHER", 3, 1)));
        productOffers.put("TSHIRT", Arrays.asList(new ReducedPriceOffer("BUY_THREE_FOR_REDUCED_PRICE", "TSHIRT", 3, new BigDecimal("19.00"))));
    }

    public List<Offer> getApplicableOffers(String productCode) {
        if (productCode == null) {
            throw new NullPointerException("product Code cannot be null.");
        }
        if (productOffers.containsKey(productCode)) {
            return productOffers.get(productCode);
        }
        return Collections.emptyList();
    }
}
