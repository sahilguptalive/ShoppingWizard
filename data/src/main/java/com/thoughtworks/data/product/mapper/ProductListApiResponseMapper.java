package com.thoughtworks.data.product.mapper;

import com.thoughtworks.data.Mapper;
import com.thoughtworks.data.product.entity.ProductEntity;
import com.thoughtworks.data.product.entity.ProductListEntity;
import com.thoughtworks.data.repository.database.ProductInfo;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;

/**
 * Created on 13-06-2018.
 */
public class ProductListApiResponseMapper
        implements Mapper<RealmResults<ProductInfo>, ProductListEntity> {

    @Override
    public ProductListEntity map(final RealmResults<ProductInfo> input) {
        List<ProductEntity> productEntities = new ArrayList<>();
        final ProductInfoMapper itemMapper = new ProductInfoMapper();
        for (int i = 0; i < input.size(); i++) {
            productEntities.add(itemMapper.map(input.get(i)));
        }
        return new ProductListEntity(productEntities);
    }
}
