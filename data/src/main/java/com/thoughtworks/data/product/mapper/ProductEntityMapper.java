package com.thoughtworks.data.product.mapper;

import com.thoughtworks.data.Mapper;
import com.thoughtworks.data.product.entity.ProductEntity;
import com.thoughtworks.domain.product_detail.Product;

/**
 * Created on 13-06-2018.
 */
public class ProductEntityMapper
        implements Mapper<ProductEntity, Product> {

    @Override
    public Product map(final ProductEntity input) {
        return new Product(
                input.getProductId(),
                input.getCategoryId(),
                input.getName(),
                input.getPrice(),
                input.getProdImgUrl(),
                input.getCategory());
    }
}
