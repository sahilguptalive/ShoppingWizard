package com.thoughtworks.shoppingwizard.cart;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thoughtworks.presentation.PresentationError;
import com.thoughtworks.presentation.view_cart.CartItemViewModel;
import com.thoughtworks.presentation.view_cart.CartViewUI;
import com.thoughtworks.presentation.view_cart.ViewCartPresenter;
import com.thoughtworks.shoppingwizard.BaseFragment;
import com.thoughtworks.shoppingwizard.Navigator;
import com.thoughtworks.shoppingwizard.R;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created on 15-06-2018.
 */
public class CartDetailFragment extends BaseFragment implements CartViewUI {

    private RecyclerView mRecyclerViewCartItems;
    private ViewCartPresenter mCartPresenter;
    private CartItemsAdapter mAdapter;
    private TextView mCartTotal;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.layout_cart, container, false);
        mCartPresenter = ViewCartPresenter.newInstance();
        setupView(view);
        return view;
    }

    private void setupView(final View view) {
        setupRecyclerView(view);
        mCartTotal = view.findViewById(R.id.cart_details_textview_total_amount);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCartPresenter.onUiCreated(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mCartPresenter.onUiResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mCartPresenter.onUiPaused();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mCartPresenter.onUiDestroyed();
    }

    private void setupRecyclerView(final View view) {
        mRecyclerViewCartItems = view.findViewById(R.id.cart_recycler_view_cart_items);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerViewCartItems.setLayoutManager(layoutManager);
        mAdapter = new CartItemsAdapter();
        mRecyclerViewCartItems.setAdapter(mAdapter);
        mAdapter.setItemClickListener(new ProductItemTapListener());
    }


    @Override
    public void renderCartItems(final List<CartItemViewModel> data) {
        if (mAdapter != null) {
            mAdapter.setData(data);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void renderError(final PresentationError error) {
        //no implementation
    }

    @Override
    public void showProduct(final int prodId) {
        Navigator.navigateToProductDetail(mContext, prodId);
    }

    @Override
    public CartItemViewModel getItemAt(final int adapterPosition) {
        return mAdapter.getItemAt(adapterPosition);
    }

    @Override
    public void renderCartTotal(final double totalAmount) {
        mCartTotal.setText(mContext.getString(R.string.cart_total, String.valueOf(totalAmount)));
    }

    @Override
    public WeakReference<Context> getContextRef() {
        return new WeakReference<>(getContext());
    }


    private class ProductItemTapListener implements CartItemListener {

        @Override
        public void onCartItemRemoved(final int cartId) {
            mCartPresenter.onCartItemRemoveIconClicked(cartId);
        }

        @Override
        public void onCartItemClicked(final int cartId) {
            mCartPresenter.onCartItemClicked(cartId);
        }
    }
}
