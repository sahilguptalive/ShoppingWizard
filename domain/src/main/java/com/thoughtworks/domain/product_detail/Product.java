package com.thoughtworks.domain.product_detail;

/**
 * Created on 12-06-2018.
 */
public class Product {

    private final int productId;
    private final int categoryId;
    private final String name;
    private final double price;
    private final String prodImgUrl;
    private final String category;

    public Product(final int productId,
                   final int categoryId,
                   final String name,
                   final double price,
                   final String prodImgUrl,
                   final String category) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.prodImgUrl = prodImgUrl;
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
        return prodImgUrl;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }
}
