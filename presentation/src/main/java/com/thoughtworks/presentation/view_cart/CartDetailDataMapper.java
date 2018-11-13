package com.thoughtworks.presentation.view_cart;

import com.thoughtworks.domain.cart.CartDetails;
import com.thoughtworks.presentation.product_list.Mapper;

/**
 * Created on 16-06-2018.
 */
class CartDetailDataMapper implements Mapper<CartDetails, CartDetailViewModel> {

    @Override
    public CartDetailViewModel map(final CartDetails input) {
        return new CartDetailViewModel(
                new CartItemListMapper().map(input.getCartItems()),
                input.getAmount());
    }
}
