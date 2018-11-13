package com.thoughtworks.presentation.product_list;

import android.support.annotation.NonNull;

import com.thoughtworks.data.product.ProductDataRepository;
import com.thoughtworks.domain.UseCaseError;
import com.thoughtworks.domain.product_list.ProductList;
import com.thoughtworks.domain.product_list.ProductRepository;
import com.thoughtworks.domain.product_list.usecases.GetProducts;
import com.thoughtworks.domain.product_list.usecases.GetProductsUseCase;
import com.thoughtworks.presentation.BasePresenter;

/**
 * Created on 12-06-2018.
 */
public final class ProductListPresenter implements BasePresenter<ProductListUI> {

    private GetProducts mGetProductsUseCase;
    private ProductListUI mView;
    private final ProductListDataMapper mProductListDataMapper;

    private ProductListPresenter() {
        mProductListDataMapper = new ProductListDataMapper();
    }

    public static ProductListPresenter newInstance() {
        return new ProductListPresenter();
    }

    @Override
    public void onUiCreated(@NonNull final ProductListUI view) {
        mView = view;
        initObjects();
        mGetProductsUseCase.execute(null, new ProductListReceiver());
    }

    private void initObjects() {
        final ProductRepository repository = ProductDataRepository
                .newInstance(mView.getContextRef());
        mGetProductsUseCase = GetProductsUseCase.newInstance(repository);
        mGetProductsUseCase.execute(null, new ProductListReceiver());
    }

    @Override
    public void onUiResume() {

    }

    @Override
    public void onUiPaused() {

    }

    @Override
    public void onUiDestroyed() {
        mView = null;
    }

    public void onListItemClicked(final ProductListItemModel listItemModel) {
        mView.showProduct(listItemModel);
    }

    public void onCategorySelected(final int position) {
        switch (position) {
            case 0://all
                mGetProductsUseCase.execute(GetProducts.Category.ALL, new ProductListReceiver());
                break;
            case 1://electronic
                mGetProductsUseCase.execute(GetProducts.Category.ELECTRONICS, new ProductListReceiver());
                break;
            case 2://furniture
                mGetProductsUseCase.execute(GetProducts.Category.FURNITURE, new ProductListReceiver());
                break;
        }
    }

    public void onShowCartClicked() {
        if(mView!=null){
            mView.showCartDetails();
        }
    }

    private class ProductListReceiver
            implements com.thoughtworks.domain.UseCaseDataReceiver<com.thoughtworks.domain.product_list.ProductList> {

        @Override
        public void onUseCaseDataReceived(@NonNull final ProductList data) {
            if (mView != null) {
                mView.renderProductsList(mProductListDataMapper.map(data));
            }
        }

        @Override
        public void onUseCaseDataReceivedFailed(@NonNull final UseCaseError error) {

        }
    }
}
