package com.thoughtworks.presentation.product_list;

/**
 * Created on 12-06-2018.
 */
public interface Mapper<S, D> {

    D map(S input);
}
