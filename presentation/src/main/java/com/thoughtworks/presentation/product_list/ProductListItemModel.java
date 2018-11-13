package com.thoughtworks.presentation.product_list;

/**
 * Created on 12-06-2018.
 */
public class ProductListItemModel {

    private final String mName;
    private final String mPrice;
    private final String mCategory;
    private final String mProdImgUrl;
    private final int mProductId;

    public ProductListItemModel(final int productId,
                                final String name,
                                final String price,
                                final String prodImgUrl,
                                final String category) {
        mName = name;
        mPrice = price;
        mProdImgUrl = prodImgUrl;
        mCategory = category;
        mProductId = productId;
    }

    public String getName() {
        return mName;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getProdImgUrl() {
        return mProdImgUrl;
    }

    public int getProductId() {
        return mProductId;
    }
}