package com.thoughtworks.shoppingwizard.cart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.thoughtworks.shoppingwizard.BaseActivity;
import com.thoughtworks.shoppingwizard.R;

/**
 * Created on 15-06-2018.
 */
public class CartDetailActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_detail);
        setupContentView();
        setupHomeEnable(true);
    }

    private void setupContentView() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_cart_detail_root,
                        new CartDetailFragment())
                .commit();
    }

    public static Intent createIntent(final Context context) {
        return new Intent(context, CartDetailActivity.class);
    }
}