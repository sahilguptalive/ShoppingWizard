package com.thoughtworks.data.product.mapper;

import com.thoughtworks.data.Mapper;
import com.thoughtworks.data.product.entity.ProductEntity;
import com.thoughtworks.data.product.entity.ProductListEntity;
import com.thoughtworks.domain.product_detail.Product;
import com.thoughtworks.domain.product_list.ProductList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 13-06-2018.
 */
public class ProductListEntityMapper
        implements Mapper<ProductListEntity, ProductList> {

    @Override
    public ProductList map(final ProductListEntity input) {
        List<Product> productEntities = new ArrayList<>();
        final ProductEntityMapper itemMapper = new ProductEntityMapper();
        for (ProductEntity productEntity : input.getProductEntityList()) {
            productEntities.add(itemMapper.map(productEntity));
        }
        return new ProductList(productEntities);
    }
}
