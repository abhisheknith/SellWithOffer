package com.novicap.store.pricingrules;

import com.novicap.store.pricingrules.offers.GetForFreeOffer;
import com.novicap.store.pricingrules.offers.Offer;
import com.novicap.store.pricingrules.offers.OfferManager;
import com.novicap.store.pricingrules.offers.ReducedPriceOffer;
import com.novicap.store.products.Product;
import com.novicap.store.products.ProductManager;
import com.novicap.store.products.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.*;

public class PriceCalculator {

    private ProductManager productManager;
    private OfferManager offerManager;

    public PriceCalculator() {
        productManager = ProductManager.getInstance();
        offerManager = OfferManager.getInstance();
    }

    public BigDecimal getTotalPrice(Map<String, Integer> cartProducts) throws ProductNotFoundException {
        if (cartProducts == null) {
            throw new NullPointerException("Cart items cannot be null.");
        }
        BigDecimal total = new BigDecimal(0);
        Iterator<Map.Entry<String, Integer>> entryIterator = cartProducts.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String productCode = entry.getKey();
            Integer count = entry.getValue();
            Product product = productManager.validateProduct(productCode);
            List<Offer> applicableOffers = offerManager.getApplicableOffers(productCode);
            BigDecimal price;
            if (applicableOffers.isEmpty()) {
                price = product.getPrice().multiply(new BigDecimal(count));
            } else {
                price = applicableOffers.stream().map(offer -> applyOffer(offer, product, count))
                        .max(Comparator.naturalOrder()).get();
            }
            total = total.add(price);
        }
        return total;
    }

    private BigDecimal applyOffer(Offer offer, Product product, Integer count) {
        switch (offer.getType()) {
            case ReducedPriceOffer.REDUCED_PRICE:
                if (offer.getMinimumProductCount() <= count) {
                    return ((ReducedPriceOffer) offer).getReducedPrice().multiply(new BigDecimal(count));
                }
            case GetForFreeOffer.GET_FOR_FREE:
                if (offer.getMinimumProductCount() <= count) {
                    int eligibleFreeItems = (count / offer.getMinimumProductCount())
                            * ((GetForFreeOffer) offer).getFreeItemsCount();
                    return product.getPrice().multiply(new BigDecimal(count - eligibleFreeItems));
                }
        }
        return product.getPrice().multiply(new BigDecimal(count));
    }
}
