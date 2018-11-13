package com.thoughtworks.presentation.view_cart;

import com.thoughtworks.presentation.product_list.ProductListItemModel;

/**
 * Created on 16-06-2018.
 */
public class CartItemViewModel {

    private final int mCartId;
    private final ProductListItemModel mProductListItemModel;

    public CartItemViewModel(final int cartId, final ProductListItemModel productListItemModel) {
        mCartId = cartId;
        mProductListItemModel = productListItemModel;
    }

    public int getCartId() {
        return mCartId;
    }

    public ProductListItemModel getProductListItemModel() {
        return mProductListItemModel;
    }
}
