package com.thoughtworks.shoppingwizard.product_list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.thoughtworks.presentation.PresentationError;
import com.thoughtworks.presentation.product_list.ProductListItemModel;
import com.thoughtworks.presentation.product_list.ProductListPresenter;
import com.thoughtworks.presentation.product_list.ProductListUI;
import com.thoughtworks.shoppingwizard.BaseFragment;
import com.thoughtworks.shoppingwizard.Navigator;
import com.thoughtworks.shoppingwizard.R;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created on 09-06-2018.
 */
public class ProductListFragment extends BaseFragment implements ProductListUI {

    private RecyclerView mRecyclerViewProducts;
    private ProductListPresenter mProductListPresenter;
    private ProductListAdapter mAdapter;
    private Spinner mSpinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.layout_product_list, container, false);
        mProductListPresenter = ProductListPresenter.newInstance();
        setHasOptionsMenu(true);
        setupView(view);
        return view;
    }

    private void setupView(final View view) {
        setupRecyclerView(view);
        setupSpinner(view);
    }

    private void setupSpinner(final View view) {
        mSpinner = view.findViewById(R.id.product_list_spinner_categories);
        final ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
                mContext,
                R.array.categories,
                android.R.layout.simple_spinner_item);
        mSpinner.setAdapter(spinnerAdapter);
        mSpinner.setOnItemSelectedListener(new CategorySelectionListener());
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProductListPresenter.onUiCreated(this);
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.cart_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == R.id.show_cart) {
            mProductListPresenter.onShowCartClicked();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        mProductListPresenter.onUiResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mProductListPresenter.onUiPaused();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mProductListPresenter.onUiDestroyed();
    }

    private void setupRecyclerView(final View view) {
        mRecyclerViewProducts = view.findViewById(R.id.product_list_recycler_view_products);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerViewProducts.setLayoutManager(layoutManager);
        mAdapter = new ProductListAdapter();
        mRecyclerViewProducts.setAdapter(mAdapter);
        mAdapter.setItemClickListener(new ProductItemTapListener());
    }


    @Override
    public void renderProductsList(final List<ProductListItemModel> data) {
        if (mAdapter != null) {
            mAdapter.setData(data);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void renderCartCount(final int cartCount) {
        //TODO:
    }

    @Override
    public void renderError(final PresentationError error) {
        //no implementation
    }

    @Override
    public void showProduct(final ProductListItemModel data) {
        Navigator.navigateToProductDetail(mContext, data.getProductId());
    }

    @Override
    public ProductListItemModel getItemAt(final int adapterPosition) {
        return mAdapter.getItemAt(adapterPosition);
    }

    @Override
    public void showCartDetails() {
        Navigator.navigateToCartDetail(mContext);
    }

    @Override
    public WeakReference<Context> getContextRef() {
        return new WeakReference<>(getContext());
    }


    private class ProductItemTapListener implements ProductListItemClickListener {

        @Override
        public void onProductClicked(final ProductListItemModel productListItemModel) {
            if (mProductListPresenter != null) {
                mProductListPresenter.onListItemClicked(productListItemModel);
            }
        }
    }

    private class CategorySelectionListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
            if (mProductListPresenter != null) {
                mProductListPresenter.onCategorySelected(position);
            }
        }

        @Override
        public void onNothingSelected(final AdapterView<?> parent) {

        }
    }
}
