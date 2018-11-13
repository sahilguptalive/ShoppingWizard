package com.thoughtworks.data;

/**
 * Created on 13-06-2018.
 */
public interface Mapper<S, D> {

    D map(S input);
}
