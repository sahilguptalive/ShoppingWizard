package com.thoughtworks.data.cart.mapper;

import com.thoughtworks.data.cart.entity.CartDetailEntity;
import com.thoughtworks.domain.cart.CartDetails;

/**
 * Created on 16-06-2018.
 */
public class CartDetailEntityMapper implements com.thoughtworks.data.Mapper<com.thoughtworks.data.cart.entity.CartDetailEntity, com.thoughtworks.domain.cart.CartDetails> {
    @Override
    public CartDetails map(final CartDetailEntity input) {
        return new CartDetails(new CartItemEntityListMapper().map(
                input.getCartItemEntityList()),
                input.getTotalAmount());
    }
}
