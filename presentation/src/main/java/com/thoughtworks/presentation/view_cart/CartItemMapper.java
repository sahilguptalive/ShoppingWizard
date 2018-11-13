package com.thoughtworks.presentation.view_cart;

import com.thoughtworks.domain.cart.CartItem;
import com.thoughtworks.presentation.product_list.Mapper;
import com.thoughtworks.presentation.product_list.ProductListItemDataMapper;

/**
 * Created on 16-06-2018.
 */
class CartItemMapper
        implements Mapper<CartItem, CartItemViewModel> {
    @Override
    public CartItemViewModel map(final CartItem input) {
        return new CartItemViewModel(
                input.getCartId(),
                new ProductListItemDataMapper().map(input.getProduct()));
    }
}
