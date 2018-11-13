package com.thoughtworks.presentation.product_list;

import com.thoughtworks.domain.product_detail.Product;

/**
 * Created on 12-06-2018.
 */
public class ProductListItemDataMapper implements Mapper<Product,
        ProductListItemModel> {

    @Override
    public ProductListItemModel map(final Product input) {
        return new ProductListItemModel(input.getProductId()
                , input.getName()
                , String.valueOf(input.getPrice())
                , input.getProdImgUrl()
                , null);
    }
}
