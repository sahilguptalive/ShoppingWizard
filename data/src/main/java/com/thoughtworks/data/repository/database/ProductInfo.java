package com.thoughtworks.data.repository.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created on 14-06-2018.
 */
public class ProductInfo extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private String display_name;
    private double price;
    private CategoryInfo categoryInfo;
    private String prodImgUrl;

    public ProductInfo() {
    }

    public ProductInfo(final int id,
                       final String name,
                       final String display_name,
                       final double price,
                       final CategoryInfo categoryInfo,
                       final String prodImgUrl) {
        this.id = id;
        this.name = name;
        this.display_name = display_name;
        this.price = price;
        this.categoryInfo = categoryInfo;
        this.prodImgUrl = prodImgUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return display_name;
    }

    public double getPrice() {
        return price;
    }

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public String getProdImgUrl() {
        return prodImgUrl;
    }

    public static final class ColumnNames {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String DISPLAY_NAME = "display_name";
        public static final String PRICE = "price";
        public static final String PRODUCT_IMG_URL = "prodImgUrl";
        static final String CATEGORY_INFO = "categoryInfo";
        public static final String CATEGORY_NAME = CATEGORY_INFO
                + "." + CategoryInfo.ColumnName.NAME;
    }
}
