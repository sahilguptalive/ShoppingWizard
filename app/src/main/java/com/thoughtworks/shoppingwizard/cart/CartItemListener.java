package com.thoughtworks.shoppingwizard.cart;

/**
 * Created on 15-06-2018.
 */
interface CartItemListener {

    void onCartItemRemoved(int cartId);

    void onCartItemClicked(int cartId);
}
