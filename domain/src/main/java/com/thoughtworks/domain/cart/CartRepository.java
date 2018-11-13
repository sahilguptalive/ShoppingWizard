package com.thoughtworks.domain.cart;

/**
 * Created on 15-06-2018.
 */
public interface CartRepository {

    boolean addToCart(int productId);

    boolean removeFromCart(int cartId);

    CartDetails getCartDetails();

    Integer getProductIdFromCartId(Integer cartId);
}
