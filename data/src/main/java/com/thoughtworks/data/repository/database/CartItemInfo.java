package com.thoughtworks.data.repository.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created on 14-06-2018.
 */
public class CartItemInfo extends RealmObject {

    @PrimaryKey
    private int id;
    private ProductInfo productInfo;

    public static final class ColumnName {
        public static final String ID = "id";
        public static final String PRODUCT_INFO = "productInfo";
        public static final String PRICE = CartItemInfo.ColumnName.PRODUCT_INFO
                + "." + ProductInfo.ColumnNames.PRICE;
    }

    public CartItemInfo(final int id, final ProductInfo productInfo) {
        this.id = id;
        this.productInfo = productInfo;
    }

    public CartItemInfo() {
    }

    public int getId() {
        return id;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }
}
