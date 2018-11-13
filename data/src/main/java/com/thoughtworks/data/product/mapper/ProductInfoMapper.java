package com.thoughtworks.data.product.mapper;

import com.thoughtworks.data.Mapper;
import com.thoughtworks.data.product.entity.ProductEntity;
import com.thoughtworks.data.repository.database.ProductInfo;

/**
 * Created on 13-06-2018.
 */
public class ProductInfoMapper
        implements Mapper<ProductInfo, ProductEntity> {

    @Override
    public ProductEntity map(final ProductInfo input) {
        return new ProductEntity(
                input.getId(),
                input.getCategoryInfo().getId(),
                input.getDisplayName(),
                input.getPrice(),
                input.getProdImgUrl(),
                input.getCategoryInfo().getName());
    }
}
