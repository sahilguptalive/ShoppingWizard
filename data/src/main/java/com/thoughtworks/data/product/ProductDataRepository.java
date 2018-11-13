package com.thoughtworks.data.product;

import android.content.Context;
import android.support.annotation.NonNull;

import com.thoughtworks.data.Mapper;
import com.thoughtworks.data.product.entity.ProductEntity;
import com.thoughtworks.data.product.entity.ProductListEntity;
import com.thoughtworks.data.product.mapper.ProductEntityMapper;
import com.thoughtworks.data.product.mapper.ProductInfoMapper;
import com.thoughtworks.data.product.mapper.ProductListApiResponseMapper;
import com.thoughtworks.data.product.mapper.ProductListEntityMapper;
import com.thoughtworks.data.repository.DataStoreRepository;
import com.thoughtworks.data.repository.database.ProductInfo;
import com.thoughtworks.domain.product_detail.Product;
import com.thoughtworks.domain.product_list.ProductList;
import com.thoughtworks.domain.product_list.ProductRepository;
import com.thoughtworks.domain.product_list.usecases.GetProducts;

import java.lang.ref.WeakReference;

import io.realm.RealmResults;

/**
 * Created on 12-06-2018.
 */
public class ProductDataRepository implements ProductRepository {

    private final Mapper<RealmResults<ProductInfo>, ProductListEntity> mProductInfoListMapper;
    private final Mapper<ProductListEntity, ProductList> mProductEntityListMapper;
    private final Mapper<ProductInfo, ProductEntity> mProductInfoMapper;
    private final Mapper<ProductEntity, Product> mProductEntityMapper;

    public static ProductRepository newInstance(@NonNull WeakReference<Context> context) {

        return new ProductDataRepository(context);
    }

    private ProductDataRepository(@NonNull WeakReference<Context> context) {
        DataStoreRepository.init(context);
        initDatabase();
        mProductInfoListMapper = new ProductListApiResponseMapper();
        mProductEntityListMapper = new ProductListEntityMapper();
        mProductInfoMapper = new ProductInfoMapper();
        mProductEntityMapper = new ProductEntityMapper();
    }

    private void initDatabase() {

    }

    @Override
    public ProductList getProducts(final GetProducts.Category input) {
        final RealmResults<ProductInfo> databaseResponse =
                DataStoreRepository.getProducts(input);
        final ProductListEntity productListEntity = mProductInfoListMapper.map(databaseResponse);
        return mProductEntityListMapper.map(productListEntity);
    }

    @Override
    public Product getProduct(final int id) {
        final ProductInfo databaseResponse = DataStoreRepository.getProductForId(id);
        final ProductEntity productEntity = mProductInfoMapper.map(databaseResponse);
        return mProductEntityMapper.map(productEntity);
    }
}
