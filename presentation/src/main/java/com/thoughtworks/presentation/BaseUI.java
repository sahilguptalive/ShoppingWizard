package com.thoughtworks.presentation;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created on 14-06-2018.
 */
public interface BaseUI {

    WeakReference<Context> getContextRef();

}

