package com.thoughtworks.data.cart.mapper;

import com.thoughtworks.data.Mapper;
import com.thoughtworks.data.cart.entity.CartItemEntity;
import com.thoughtworks.domain.cart.CartItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16-06-2018.
 */
class CartItemEntityListMapper implements Mapper<List<CartItemEntity>,
        List<CartItem>> {

    @Override
    public List<CartItem> map(final List<CartItemEntity> input) {
        final List<CartItem> result = new ArrayList<>(input.size());
        final CartItemEntityMapper cartItemEntityMapper = new CartItemEntityMapper();
        for (CartItemEntity entity : input) {
            result.add(cartItemEntityMapper.map(entity));
        }
        return result;
    }
}
