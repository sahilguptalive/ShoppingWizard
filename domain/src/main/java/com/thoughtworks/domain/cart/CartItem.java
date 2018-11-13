package com.thoughtworks.domain.cart;

import com.thoughtworks.domain.product_detail.Product;

/**
 * Created on 16-06-2018.
 */
public class CartItem {

    private final int mCartId;
    private final Product mProduct;

    public CartItem(final int cartId, final Product product) {
        mCartId = cartId;
        mProduct = product;
    }

    public int getCartId() {
        return mCartId;
    }

    public Product getProduct() {
        return mProduct;
    }
}
