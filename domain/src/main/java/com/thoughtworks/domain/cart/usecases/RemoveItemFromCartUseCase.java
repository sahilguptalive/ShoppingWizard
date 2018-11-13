package com.thoughtworks.domain.cart.usecases;

import com.thoughtworks.domain.UseCaseDataReceiver;
import com.thoughtworks.domain.UseCaseError;
import com.thoughtworks.domain.cart.CartDetails;
import com.thoughtworks.domain.cart.CartRepository;

/**
 * Created on 16-06-2018.
 */
public class RemoveItemFromCartUseCase
        implements RemoveItemFromCart {

    private final CartRepository mCartRepo;

    private RemoveItemFromCartUseCase(final CartRepository cartRepository) {
        mCartRepo = cartRepository;
    }

    public static RemoveItemFromCartUseCase newInstance(CartRepository cartRepository) {
        return new RemoveItemFromCartUseCase(cartRepository);
    }

    @Override
    public void execute(final Integer cartId, final UseCaseDataReceiver<CartDetails> useCaseDataReceiver) {
        if (!mCartRepo.removeFromCart(cartId)) {
            useCaseDataReceiver.onUseCaseDataReceivedFailed(new UseCaseError());
            return;
        }
        final CartDetails repositoryOutput = mCartRepo.getCartDetails();
        if (repositoryOutput == null) {
            useCaseDataReceiver.onUseCaseDataReceivedFailed(new UseCaseError());
        } else {
            useCaseDataReceiver.onUseCaseDataReceived(repositoryOutput);
        }
    }

}
