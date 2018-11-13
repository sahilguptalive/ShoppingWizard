package com.thoughtworks.data.cart.mapper;

import com.thoughtworks.data.Mapper;
import com.thoughtworks.data.cart.entity.CartItemEntity;
import com.thoughtworks.data.product.mapper.ProductEntityMapper;
import com.thoughtworks.domain.cart.CartItem;

/**
 * Created on 16-06-2018.
 */
class CartItemEntityMapper implements Mapper<CartItemEntity, CartItem> {
    @Override
    public CartItem map(final CartItemEntity input) {
        return new CartItem(input.getCartId(),
                new ProductEntityMapper().map(input.getProductEntity()));
    }
}
