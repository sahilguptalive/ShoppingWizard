package com.thoughtworks.domain.product_list.usecases;

import com.thoughtworks.domain.BaseUseCase;
import com.thoughtworks.domain.product_list.ProductList;

/**
 * Created on 12-06-2018.
 */
public interface GetProducts extends BaseUseCase<GetProducts.Category, ProductList> {

    public enum Category {
        ALL("all"),
        ELECTRONICS("Electronics"),
        FURNITURE("Furniture");

        private final String mName;

        Category(final String name) {
            mName = name;
        }

        public String getName() {
            return mName;
        }
    }
}
