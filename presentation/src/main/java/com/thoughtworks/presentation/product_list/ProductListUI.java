package com.thoughtworks.presentation.product_list;

import com.thoughtworks.presentation.BaseUI;
import com.thoughtworks.presentation.PresentationError;

import java.util.List;

/**
 * Created on 12-06-2018.
 */
public interface ProductListUI extends BaseUI {

    void renderProductsList(List<ProductListItemModel> data);

    void renderCartCount(int cartCount);

    void renderError(PresentationError error);

    void showProduct(final ProductListItemModel data);

    ProductListItemModel getItemAt(int adapterPosition);

    void showCartDetails();
}
