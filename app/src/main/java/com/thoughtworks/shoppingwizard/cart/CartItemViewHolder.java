package com.thoughtworks.shoppingwizard.cart;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtworks.shoppingwizard.R;

/**
 * Created on 09-06-2018.
 */
class CartItemViewHolder extends RecyclerView.ViewHolder {

    TextView mTextViewProductName;
    TextView mTextViewProductPrice;
    ImageView mImageViewRemoveItem;
    ImageView mImageViewProduct;

    CartItemViewHolder(final ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cart_list_item,
                parent, false));
        inflateItems();
    }

    private void inflateItems() {
        mTextViewProductName = itemView.findViewById(R.id.product_item_name);
        mTextViewProductPrice = itemView.findViewById(R.id.product_item_price);
        mImageViewRemoveItem = itemView.findViewById(R.id.cart_list_item_remove_item_icon);
        mImageViewProduct = itemView.findViewById(R.id.cart_list_item_remove_item_icon);
    }

}
