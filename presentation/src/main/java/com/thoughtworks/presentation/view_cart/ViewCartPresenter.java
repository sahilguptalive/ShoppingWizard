package com.thoughtworks.presentation.view_cart;

import android.support.annotation.NonNull;

import com.thoughtworks.data.cart.CartDataRepository;
import com.thoughtworks.domain.UseCaseDataReceiver;
import com.thoughtworks.domain.UseCaseError;
import com.thoughtworks.domain.cart.CartDetails;
import com.thoughtworks.domain.cart.CartRepository;
import com.thoughtworks.domain.cart.usecases.GetCartDetailsUseCase;
import com.thoughtworks.domain.cart.usecases.GetProductFromCartIdUseCase;
import com.thoughtworks.domain.cart.usecases.RemoveItemFromCartUseCase;
import com.thoughtworks.presentation.BasePresenter;

/**
 * Created on 15-06-2018.
 */
public class ViewCartPresenter implements BasePresenter<CartViewUI> {

    private CartViewUI mView;
    private GetCartDetailsUseCase mGetCartDetailsUseCase;
    private GetProductFromCartIdUseCase mGetProductFromCartIdUseCase;
    private RemoveItemFromCartUseCase mRemoveItemFromCartUseCase;

    public static ViewCartPresenter newInstance() {
        return new ViewCartPresenter();
    }

    private ViewCartPresenter() {

    }

    @Override
    public void onUiCreated(@NonNull final CartViewUI view) {
        mView = view;
        initObjects();
        mGetCartDetailsUseCase.execute(null, new CartDetailReceiver());
    }

    private void initObjects() {
        final CartRepository cartRepo = CartDataRepository.newInstance(mView.getContextRef());
        mGetCartDetailsUseCase = GetCartDetailsUseCase.newInstance(cartRepo);
        mGetProductFromCartIdUseCase = GetProductFromCartIdUseCase.newInstance(cartRepo);
        mRemoveItemFromCartUseCase = RemoveItemFromCartUseCase.newInstance(cartRepo);
    }

    public void onCartItemClicked(int cartId) {
        mGetProductFromCartIdUseCase.execute(cartId, new ProductDetailReceiverProductDetails());
    }

    public void onCartItemRemoveIconClicked(final int cartId) {
        mRemoveItemFromCartUseCase.execute(cartId, new RemoveItemListener());
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

    private class CartDetailReceiver implements UseCaseDataReceiver<CartDetails> {
        @Override
        public void onUseCaseDataReceived(final CartDetails data) {
            if (mView != null) {
                final CartDetailViewModel cartDetailViewModel = new CartDetailDataMapper().map(data);
                mView.renderCartItems(cartDetailViewModel.getCartItemViewModelList());
                mView.renderCartTotal(cartDetailViewModel.getTotalAmount());
            }
        }

        @Override
        public void onUseCaseDataReceivedFailed(final UseCaseError error) {
        }
    }

    private class ProductDetailReceiverProductDetails implements UseCaseDataReceiver<Integer> {
        @Override
        public void onUseCaseDataReceived(final Integer data) {
            if (mView != null) {
                mView.showProduct(data);
            }
        }

        @Override
        public void onUseCaseDataReceivedFailed(final UseCaseError error) {

        }
    }


    private class RemoveItemListener implements UseCaseDataReceiver<CartDetails> {

        @Override
        public void onUseCaseDataReceived(final CartDetails data) {
            new CartDetailReceiver().onUseCaseDataReceived(data);
        }

        @Override
        public void onUseCaseDataReceivedFailed(final UseCaseError error) {

        }
    }
}
