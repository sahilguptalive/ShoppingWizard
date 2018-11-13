package com.thoughtworks.shoppingwizard;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created on 17-06-2018.
 */
public final class ImageLoader {

    private ImageLoader() {

    }

    public static void loadImage(ImageView imageView,
                                 String url) {
        Glide.with(imageView)
                .load(url)
                .into(imageView);
    }

}
