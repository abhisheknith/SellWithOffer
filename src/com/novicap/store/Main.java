package com.novicap.store;

import com.novicap.store.products.ProductNotFoundException;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    private static void test1() {
        CheckoutCart cart = new CheckoutCart();
        try {
            cart.scan("VOUCHER");
            cart.scan("TSHIRT");
            cart.scan("MUG");
            System.out.println(cart.total());
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        CheckoutCart cart = new CheckoutCart();
        try {
            cart.scan("VOUCHER");
            cart.scan("VOUCHER");
            cart.scan("VOUCHER");
            cart.scan("TSHIRT");
            cart.scan("MUG");
            System.out.println(cart.total());
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test3() {
        CheckoutCart cart = new CheckoutCart();
        try {
            cart.scan("VOUCHER");
            cart.scan("TSHIRT");
            cart.scan("TSHIRT");
            cart.scan("TSHIRT");
            cart.scan("MUG");
            System.out.println(cart.total());
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test4() {
        CheckoutCart cart = new CheckoutCart();
        try {
            cart.scan("VOUCHER");
            cart.scan("VOUCHER");
            cart.scan("VOUCHER");
            cart.scan("VOUCHER");
            cart.scan("VOUCHER");
            cart.scan("VOUCHER");
            cart.scan("TSHIRT");
            cart.scan("TSHIRT");
            cart.scan("TSHIRT");
            cart.scan("TSHIRT");
            cart.scan("MUG");
            System.out.println(cart.total());
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test5() {
        // Test case in challenge def says that it should be 25.00 but I beg to differ.
        // If offer is get 1 extra after buying 2 then we got to scan three items for that to be eligible.
        CheckoutCart cart = new CheckoutCart();
        try {
            cart.scan("VOUCHER");
            cart.scan("TSHIRT");
            cart.scan("VOUCHER");
            System.out.println(cart.total());
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test6() {
        CheckoutCart cart = new CheckoutCart();
        try {
            cart.scan("TSHIRT");
            cart.scan("TSHIRT");
            cart.scan("TSHIRT");
            cart.scan("VOUCHER");
            cart.scan("TSHIRT");
            System.out.println(cart.total());
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test7() {
        CheckoutCart cart = new CheckoutCart();
        try {
            cart.scan("VOUCHER");
            cart.scan("TSHIRT");
            cart.scan("VOUCHER");
            cart.scan("VOUCHER");
            cart.scan("MUG");
            cart.scan("TSHIRT");
            cart.scan("TSHIRT");
            System.out.println(cart.total());
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
    }
}
