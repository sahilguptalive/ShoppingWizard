package com.thoughtworks.shoppingwizard.cart;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtworks.presentation.view_cart.CartItemViewModel;
import com.thoughtworks.shoppingwizard.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 09-06-2018.
 */
class CartItemsAdapter extends RecyclerView.Adapter<CartItemViewHolder> {

    private final List<CartItemViewModel> mData;
    private CartItemListener mListener;

    public CartItemsAdapter(final List<CartItemViewModel> data) {
        mData = new ArrayList<>(data);
    }

    public CartItemsAdapter() {
        mData = new ArrayList<>();
    }

    @NonNull
    @Override

    public CartItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                 final int viewType) {
        return new CartItemViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartItemViewHolder holder,
                                 final int position) {

        final CartItemViewModel viewModel = mData.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (mListener != null) {
                    mListener.onCartItemClicked(viewModel.getCartId());
                }
            }
        });
        holder.mImageViewRemoveItem.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        if (mListener != null) {
                            mListener.onCartItemRemoved(viewModel.getCartId());
                        }
                    }
                }
        );
        holder.mTextViewProductName.setText(viewModel.getProductListItemModel().getName());
        holder.mTextViewProductPrice.setText(viewModel.getProductListItemModel().getPrice());
        ImageLoader.loadImage(holder.mImageViewProduct,
                viewModel.getProductListItemModel().getProdImgUrl());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    CartItemViewModel getItemAt(int adapterPosition) {
        return mData.get(adapterPosition);
    }

    public void setData(final List<CartItemViewModel> data) {
        mData.clear();
        mData.addAll(data);
    }

    void setItemClickListener(final CartItemListener listener) {
        mListener = listener;
    }
}
