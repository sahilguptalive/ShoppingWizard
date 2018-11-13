package com.thoughtworks.presentation.product_detail;

import android.support.annotation.NonNull;

import com.thoughtworks.data.cart.CartDataRepository;
import com.thoughtworks.data.product.ProductDataRepository;
import com.thoughtworks.domain.UseCaseError;
import com.thoughtworks.domain.cart.usecases.AddToCart;
import com.thoughtworks.domain.cart.usecases.AddToCartUseCase;
import com.thoughtworks.domain.cart.CartRepository;
import com.thoughtworks.domain.product_detail.usecases.GetProductDetails;
import com.thoughtworks.domain.product_detail.usecases.GetProductDetailsUseCase;
import com.thoughtworks.domain.product_detail.Product;
import com.thoughtworks.domain.product_list.ProductRepository;
import com.thoughtworks.presentation.BasePresenter;

/**
 * Created on 14-06-2018.
 */
public class ProductDetailPresenter implements BasePresenter<ProductDetailUI> {

    private final ProductDetailMapper mProductDetailMapper;
    private ProductDetailUI mView;
    private GetProductDetails mGetProductDetailsUseCase;
    private AddToCart mAddToCartUseCase;


    public static ProductDetailPresenter newInstance() {
        return new ProductDetailPresenter();
    }

    private ProductDetailPresenter() {
        mProductDetailMapper = new ProductDetailMapper();
    }

    @Override
    public void onUiCreated(@NonNull final ProductDetailUI view) {
        mView = view;
        initObjects();
    }

    private void initObjects() {
        final ProductRepository repository = ProductDataRepository
                .newInstance(mView.getContextRef());
        mGetProductDetailsUseCase = GetProductDetailsUseCase.newInstance(repository);

        final CartRepository cartRepository = CartDataRepository.newInstance(mView.getContextRef());
        mAddToCartUseCase = AddToCartUseCase.newInstance(cartRepository);
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

    public void loadDataForProductId(int productId) {
        mGetProductDetailsUseCase.execute(productId, new ProductDetailReceiver());
    }

    public void onAddToCartClicked(final int prodId) {
        mAddToCartUseCase.execute(prodId, new AddToCartUseCaseListener());
    }

    public void onShowCartClicked() {
        mView.showCartDetailUi();
    }

    private class ProductDetailReceiver implements com.thoughtworks.domain.UseCaseDataReceiver<Product> {

        @Override
        public void onUseCaseDataReceived(@NonNull final Product data) {
            if (mView != null) {
                mView.renderProductDetail(mProductDetailMapper.map(data));
            }
        }

        @Override
        public void onUseCaseDataReceivedFailed(@NonNull final UseCaseError error) {

        }
    }

    private class AddToCartUseCaseListener implements com.thoughtworks.domain.UseCaseDataReceiver<Boolean> {
        @Override
        public void onUseCaseDataReceived(final Boolean data) {

        }

        @Override
        public void onUseCaseDataReceivedFailed(final UseCaseError error) {

        }
    }
}
