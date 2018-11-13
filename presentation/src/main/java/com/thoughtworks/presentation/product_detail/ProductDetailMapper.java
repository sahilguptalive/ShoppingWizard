package com.thoughtworks.presentation.product_detail;

import com.thoughtworks.domain.product_detail.Product;
import com.thoughtworks.presentation.product_list.Mapper;
import com.thoughtworks.presentation.product_list.ProductListItemDataMapper;

/**
 * Created on 15-06-2018.
 */
class ProductDetailMapper implements Mapper<Product, ProductDetailModel> {

    @Override
    public ProductDetailModel map(final Product input) {
        return new ProductDetailModel(
                new ProductListItemDataMapper()
                        .map(input));
    }
}
