package com.thoughtworks.presentation.view_cart;

import com.thoughtworks.presentation.BaseUI;
import com.thoughtworks.presentation.PresentationError;

import java.util.List;

/**
 * Created on 12-06-2018.
 */
public interface CartViewUI extends BaseUI {

    void renderCartItems(final List<CartItemViewModel> data);

    void renderError(final PresentationError error);

    void showProduct(int prodId);

    CartItemViewModel getItemAt(int adapterPosition);

    void renderCartTotal(double totalAmount);
}
