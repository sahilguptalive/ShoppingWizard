package com.thoughtworks.data.cart.mapper;

import com.thoughtworks.data.Mapper;
import com.thoughtworks.data.cart.entity.CartItemEntity;
import com.thoughtworks.data.product.mapper.ProductInfoMapper;
import com.thoughtworks.data.repository.database.CartItemInfo;

/**
 * Created on 16-06-2018.
 */
class CartItemInfoMapper implements Mapper<CartItemInfo, CartItemEntity> {
    @Override
    public CartItemEntity map(final CartItemInfo input) {
        return new CartItemEntity(input.getId(),
                new ProductInfoMapper().map(input.getProductInfo()));
    }
}
