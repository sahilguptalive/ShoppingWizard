package com.thoughtworks.shoppingwizard;

import android.content.Context;
import android.content.Intent;

import com.thoughtworks.shoppingwizard.cart.CartDetailActivity;
import com.thoughtworks.shoppingwizard.product_detail.ProductDetailActivity;

/**
 * Created on 13-06-2018.
 */
public final class Navigator {

    private Navigator() {

    }

    public static void navigateToProductDetail(Context context, final int productId) {
        final Intent intent = ProductDetailActivity.createIntent(context, productId);
        context.startActivity(intent);
    }

    public static void navigateToCartDetail(Context context) {
        final Intent intent = CartDetailActivity.createIntent(context);
        context.startActivity(intent);
    }
}
