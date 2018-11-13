package com.thoughtworks.data.product.entity;

/**
 * Created on 12-06-2018.
 */
public class ProductEntity {

    private final int productId;
    private final int categoryId;
    private final String name;
    private final double price;
    private final String mProdImgUrl;
    private final String category;

    public ProductEntity(final int productId,
                         final int categoryId,
                         final String name,
                         final double price,
                         final String prodImgUrl,
                         final String category) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        mProdImgUrl = prodImgUrl;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getProdImgUrl() {
        return mProdImgUrl;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }

}
