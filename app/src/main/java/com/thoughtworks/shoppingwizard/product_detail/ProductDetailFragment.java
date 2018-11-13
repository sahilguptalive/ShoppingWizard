package com.thoughtworks.shoppingwizard.product_detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtworks.presentation.PresentationError;
import com.thoughtworks.presentation.product_detail.ProductDetailModel;
import com.thoughtworks.presentation.product_detail.ProductDetailPresenter;
import com.thoughtworks.presentation.product_detail.ProductDetailUI;
import com.thoughtworks.shoppingwizard.BaseFragment;
import com.thoughtworks.shoppingwizard.ImageLoader;
import com.thoughtworks.shoppingwizard.Navigator;
import com.thoughtworks.shoppingwizard.R;

import java.lang.ref.WeakReference;

/**
 * Created on 14-06-2018.
 */
public class ProductDetailFragment
        extends BaseFragment implements ProductDetailUI {

    private static final String KEY_PROD_ID = "KEY_PROD_ID";
    private static final int INVALID_ID = -1;
    private ProductDetailPresenter mProductDetailPresenter;

    private TextView mTextViewProductName;
    private TextView mTextViewProductPrice;
    private ImageView mImageViewProduct;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.layout_product_detail, container, false);
        mProductDetailPresenter = ProductDetailPresenter.newInstance();
        setupView(view);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.cart_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == R.id.show_cart) {
            mProductDetailPresenter.onShowCartClicked();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupView(final View view) {
        setHasOptionsMenu(true);
        mTextViewProductName = view.findViewById(R.id.product_item_name);
        mTextViewProductPrice = view.findViewById(R.id.product_item_price);
        mImageViewProduct = view.findViewById(R.id.product_img_url);
        view.findViewById(R.id.product_detail_action_add_to_cart)
                .setOnClickListener(new AddToCartListener());
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProductDetailPresenter.onUiCreated(this);
        mProductDetailPresenter.loadDataForProductId(getProdIdFromArg());
    }

    private int getProdIdFromArg() {
        return getArguments() == null
                ? INVALID_ID
                : getArguments().getInt(KEY_PROD_ID, INVALID_ID);
    }


    @Override
    public void renderProductDetail(final ProductDetailModel data) {
        mTextViewProductName.setText(data.getName());
        mTextViewProductPrice.setText(data.getPrice());
        ImageLoader.loadImage(mImageViewProduct,
                data.getProdImgUrl());
    }

    @Override
    public void renderError(final PresentationError error) {

    }

    @Override
    public void showCartDetailUi() {
        Navigator.navigateToCartDetail(mContext);
    }

    static Fragment newInstance(final int productId) {
        final Fragment fragment = new ProductDetailFragment();
        final Bundle args = new Bundle();
        args.putInt(KEY_PROD_ID, productId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public WeakReference<Context> getContextRef() {
        return new WeakReference<>(getContext());
    }

    private class AddToCartListener implements View.OnClickListener {
        @Override
        public void onClick(final View v) {
            if (mProductDetailPresenter != null) {
                mProductDetailPresenter.onAddToCartClicked(getProdIdFromArg());
            }
        }
    }
}
