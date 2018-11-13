package com.thoughtworks.presentation.view_cart;

import java.util.List;

/**
 * Created on 16-06-2018.
 */
class CartDetailViewModel {

    private final List<CartItemViewModel> mCartItemViewModelList;
    private final double totalAmount;

    CartDetailViewModel(final List<CartItemViewModel> cartItemViewModelList, final double totalAmount) {
        mCartItemViewModelList = cartItemViewModelList;
        this.totalAmount = totalAmount;
    }

    public List<CartItemViewModel> getCartItemViewModelList() {
        return mCartItemViewModelList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
