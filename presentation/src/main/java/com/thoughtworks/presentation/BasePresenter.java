package com.thoughtworks.presentation;

import android.support.annotation.NonNull;

/**
 * Created on 12-06-2018.
 */
public interface BasePresenter<I> {

    void onUiCreated(@NonNull I view);

    void onUiResume();

    void onUiPaused();

    void onUiDestroyed();
}
