package com.thoughtworks.shoppingwizard.product_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtworks.presentation.product_list.ProductListItemModel;
import com.thoughtworks.shoppingwizard.ImageLoader;
import com.thoughtworks.shoppingwizard.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 09-06-2018.
 */
class ProductListAdapter extends RecyclerView.Adapter<ProductListItemViewHolder> {

    private final List<ProductListItemModel> mData;
    private ProductListItemClickListener mItemClickListener;

    public ProductListAdapter(final List<ProductListItemModel> data) {
        mData = new ArrayList<>(data);
    }

    public ProductListAdapter() {
        mData = new ArrayList<>();
    }

    @NonNull
    @Override

    public ProductListItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                        final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_list_item, parent, false);
        return new ProductListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductListItemViewHolder holder,
                                 final int position) {

        final ProductListItemModel productListItemModel = mData.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onProductClicked(productListItemModel);
                }
            }
        });
        holder.mTextViewProductName.setText(productListItemModel.getName());
        holder.mTextViewProductPrice.setText(productListItemModel.getPrice());
        ImageLoader.loadImage(holder.mImageViewProductUrl,
                productListItemModel.getProdImgUrl());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    ProductListItemModel getItemAt(int adapterPosition) {
        return mData.get(adapterPosition);
    }

    public void setData(final List<ProductListItemModel> data) {
        mData.clear();
        mData.addAll(data);
    }

    void setItemClickListener(final ProductListItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
