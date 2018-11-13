package com.thoughtworks.domain.product_list;

import com.thoughtworks.domain.BaseRepository;
import com.thoughtworks.domain.product_detail.Product;
import com.thoughtworks.domain.product_list.usecases.GetProducts;

/**
 * Created on 12-06-2018.
 */
public interface ProductRepository extends BaseRepository {

    ProductList getProducts(final GetProducts.Category input);

    Product getProduct(int id);
}
