package com.novicap.store;

import com.novicap.store.pricingrules.PriceCalculator;
import com.novicap.store.products.ProductManager;
import com.novicap.store.products.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CheckoutCart {

    private Map<String, Integer> products;
    private PriceCalculator priceCalculator;
    private ProductManager productManager;

    public CheckoutCart() {
        products = new HashMap<>();
        priceCalculator = new PriceCalculator();
        productManager = ProductManager.getInstance();
    }

    public boolean scan(String productCode) throws ProductNotFoundException {
        productManager.validateProduct(productCode);
        if (products.containsKey(productCode)) {
            products.put(productCode, products.get(productCode) + 1);
        } else {
            products.put(productCode, 1);
        }
        return true;
    }

    public BigDecimal total() throws ProductNotFoundException {
        return priceCalculator.getTotalPrice(products);
    }

    public Map<String, Integer> getProducts() {
        return new HashMap<>(products);
    }
}
