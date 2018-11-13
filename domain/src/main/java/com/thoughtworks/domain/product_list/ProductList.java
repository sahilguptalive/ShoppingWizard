package com.thoughtworks.domain.product_list;

import com.thoughtworks.domain.product_detail.Product;

import java.util.List;

/**
 * Created on 12-06-2018.
 */
public class ProductList {

    private final List<Product> mData;

    public ProductList(final List<Product> data) {
        mData = data;
    }

    public List<Product> getData() {
        return mData;
    }


}
