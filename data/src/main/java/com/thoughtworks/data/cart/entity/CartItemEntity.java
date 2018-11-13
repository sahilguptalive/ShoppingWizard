package com.thoughtworks.data.cart.entity;

import com.thoughtworks.data.product.entity.ProductEntity;

/**
 * Created on 16-06-2018.
 */
public class CartItemEntity {

    private final int mCartId;
    private final ProductEntity mProductEntity;

    public CartItemEntity(final int cartId, final ProductEntity productEntity) {
        mCartId = cartId;
        mProductEntity = productEntity;
    }

    public int getCartId() {
        return mCartId;
    }

    public ProductEntity getProductEntity() {
        return mProductEntity;
    }
}
