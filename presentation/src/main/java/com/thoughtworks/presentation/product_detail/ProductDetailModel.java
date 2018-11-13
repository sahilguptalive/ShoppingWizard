package com.thoughtworks.presentation.product_detail;

import com.thoughtworks.presentation.product_list.ProductListItemModel;

/**
 * Created on 12-06-2018.
 */
public class ProductDetailModel {

    private final ProductListItemModel mListItemodel;

    public ProductDetailModel(final ProductListItemModel listItemodel) {
        mListItemodel = listItemodel;
    }

    public String getName() {
        return mListItemodel.getName();
    }

    public String getPrice() {
        return mListItemodel.getPrice();
    }

    public String getCategory() {
        return mListItemodel.getCategory();
    }

    public int getProductId() {
        return mListItemodel.getProductId();
    }

    public String getProdImgUrl() {
        return mListItemodel.getProdImgUrl();
    }

}
