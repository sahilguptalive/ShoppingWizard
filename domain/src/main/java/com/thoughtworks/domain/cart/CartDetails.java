package com.thoughtworks.domain.cart;

import java.util.List;

/**
 * Created on 16-06-2018.
 */
public class CartDetails {

    private final List<CartItem> mCartItems;
    private final double mAmount;

    public CartDetails(final List<CartItem> cartItems, final double amount) {
        mCartItems = cartItems;
        mAmount = amount;
    }

    public List<CartItem> getCartItems() {
        return mCartItems;
    }

    public double getAmount() {
        return mAmount;
    }
}
