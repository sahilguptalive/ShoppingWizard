package com.thoughtworks.shoppingwizard.product_detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.thoughtworks.shoppingwizard.BaseActivity;
import com.thoughtworks.shoppingwizard.R;

public class ProductDetailActivity
        extends BaseActivity {

    private static final String KEY_PRODUCT_ID = "KEY_PRODUCT_ID";
    private static final int DEF_PROD_ID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        setupHomeEnable(true);
        setData();
    }

    private void setData() {
        if (getProductIdFromIntent() == DEF_PROD_ID) {
            return;
        }
        final Fragment fragment
                = ProductDetailFragment.newInstance(getProductIdFromIntent());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_product_detail_root,
                        fragment)
                .commit();
    }

    private int getProductIdFromIntent() {
        return getIntent().getIntExtra(KEY_PRODUCT_ID, DEF_PROD_ID);
    }

    public static Intent createIntent(final Context context, final int productId) {
        final Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra(KEY_PRODUCT_ID, productId);
        return intent;
    }
}
