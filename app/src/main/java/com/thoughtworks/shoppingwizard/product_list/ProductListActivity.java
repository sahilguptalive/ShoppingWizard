package com.thoughtworks.shoppingwizard.product_list;

import android.os.Bundle;

import com.thoughtworks.shoppingwizard.BaseActivity;
import com.thoughtworks.shoppingwizard.R;

public class ProductListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.title_activity_home);
        setContentView(R.layout.activity_home);
        setupAdditionalUI();
        setupContentView();
    }

    private void setupContentView() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.home_activity_content_root,
                        new ProductListFragment())
                .commit();
    }

    private void setupAdditionalUI() {
    }
}
