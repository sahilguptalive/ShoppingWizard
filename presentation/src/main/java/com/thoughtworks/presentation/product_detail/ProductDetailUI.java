package com.thoughtworks.presentation.product_detail;

import com.thoughtworks.presentation.BaseUI;
import com.thoughtworks.presentation.PresentationError;

/**
 * Created on 12-06-2018.
 */
public interface ProductDetailUI  extends BaseUI {

    void renderProductDetail(ProductDetailModel data);

    void renderError(PresentationError error);

    void showCartDetailUi();
}
