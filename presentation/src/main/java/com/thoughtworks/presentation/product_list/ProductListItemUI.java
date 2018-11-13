package com.thoughtworks.presentation.product_list;

import com.thoughtworks.presentation.PresentationError;

/**
 * Created on 12-06-2018.
 */
public interface ProductListItemUI {

    void renderProductMiniDetail(ProductListItemModel data);

    void renderCartCount(int cartCount);

    void renderError(PresentationError error);

}
