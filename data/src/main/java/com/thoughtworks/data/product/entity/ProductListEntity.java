package com.thoughtworks.data.product.entity;

import java.util.List;

/**
 * Created on 13-06-2018.
 */
public class ProductListEntity {

    private final List<ProductEntity> mProductEntityList;

    public ProductListEntity(final List<ProductEntity> productEntityList) {
        mProductEntityList = productEntityList;
    }

    public List<ProductEntity> getProductEntityList() {
        return mProductEntityList;
    }
}
