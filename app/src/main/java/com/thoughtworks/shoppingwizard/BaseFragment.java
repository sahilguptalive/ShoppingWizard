package com.thoughtworks.shoppingwizard;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created on 12-06-2018.
 */
public class BaseFragment extends Fragment {

    protected Context mContext;

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
