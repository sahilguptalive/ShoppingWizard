package com.thoughtworks.presentation.view_cart;

import com.thoughtworks.domain.cart.CartItem;
import com.thoughtworks.presentation.product_list.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16-06-2018.
 */
class CartItemListMapper implements
        Mapper<List<CartItem>, List<CartItemViewModel>> {

    @Override
    public List<CartItemViewModel> map(final List<CartItem> input) {
        final List<CartItemViewModel> cartItemList
                = new ArrayList<>(input.size());
        final CartItemMapper cartItemMapper = new CartItemMapper();
        for (CartItem cartItem : input) {
            cartItemList.add(cartItemMapper.map(cartItem));
        }
        return cartItemList;
    }
}
