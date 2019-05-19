package com.novicap.store.products;

// Should be an interface

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Should be extracted to be an interface.
 * This implementation should consider managing multiple requests coming in to validate product codes and
 * return the product info.
 * Should expose a way to register product details as well.
 * P.S. I will be initiating everything in constructor to save time.
 */
public class ProductManager {

    private static ProductManager productManager;
    /**
     * code vs product manager, assuming it must be unique through-out the store.
     */
    private Map<String, Product> products;

    public synchronized static ProductManager getInstance() {
        if (productManager == null) {
            productManager = new ProductManager();
        }
        return productManager;
    }

    private ProductManager() {
        products = new HashMap<>();
        products.put("VOUCHER", new Product("VOUCHER", "NoviCap Voucher", new BigDecimal("5.00")));
        products.put("TSHIRT", new Product("T-SHIRT", "NoviCap T-Shirt", new BigDecimal("20.00")));
        products.put("MUG", new Product("VOUCHER", "NoviCap Coffee Mug", new BigDecimal("7.50")));
    }

    public Product validateProduct(String productCode) throws ProductNotFoundException {
        if (productCode == null) {
            throw new NullPointerException("product Code cannot be null.");
        }
        if (products.containsKey(productCode)) {
            return products.get(productCode);
        }
        throw new ProductNotFoundException("No product with code " + productCode);
    }
}
