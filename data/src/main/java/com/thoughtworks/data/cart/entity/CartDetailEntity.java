package com.thoughtworks.data.cart.entity;

import java.util.List;

/**
 * Created on 16-06-2018.
 */
public class CartDetailEntity {

    private final List<CartItemEntity> mCartItemEntityList;
    private final double mTotalAmount;

    public CartDetailEntity(final List<CartItemEntity> cartItemEntityList, final double totalAmount) {
        mCartItemEntityList = cartItemEntityList;
        mTotalAmount = totalAmount;
    }

    public List<CartItemEntity> getCartItemEntityList() {
        return mCartItemEntityList;
    }

    public double getTotalAmount() {
        return mTotalAmount;
    }
}
