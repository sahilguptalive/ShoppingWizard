package com.thoughtworks.shoppingwizard.product_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtworks.shoppingwizard.R;

/**
 * Created on 09-06-2018.
 */
class ProductListItemViewHolder extends RecyclerView.ViewHolder {

    TextView mTextViewProductName;
    TextView mTextViewProductPrice;
    ImageView mImageViewProductUrl;

    ProductListItemViewHolder(final View itemView) {
        super(itemView);
        inflateItems();
    }

    private void inflateItems() {
        mTextViewProductName = itemView.findViewById(R.id.product_item_name);
        mTextViewProductPrice = itemView.findViewById(R.id.product_item_price);
        mImageViewProductUrl = itemView.findViewById(R.id.product_img_url);
    }

}
