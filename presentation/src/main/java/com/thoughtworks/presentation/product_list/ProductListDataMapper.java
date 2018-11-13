package com.thoughtworks.presentation.product_list;

import com.thoughtworks.domain.product_detail.Product;
import com.thoughtworks.domain.product_list.ProductList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 12-06-2018.
 */
public class ProductListDataMapper implements Mapper<ProductList,
        List<ProductListItemModel>> {

    @Override
    public List<ProductListItemModel> map(final ProductList input) {
        final List<ProductListItemModel> result = new ArrayList<>();
        final ProductListItemDataMapper itemMapper = new ProductListItemDataMapper();
        for (Product product : input.getData())
            result.add(itemMapper.map(product));
        return result;
    }

}
