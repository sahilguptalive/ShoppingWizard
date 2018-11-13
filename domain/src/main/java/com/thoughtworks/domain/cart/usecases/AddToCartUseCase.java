package com.thoughtworks.domain.cart.usecases;

import com.thoughtworks.domain.UseCaseDataReceiver;
import com.thoughtworks.domain.UseCaseError;
import com.thoughtworks.domain.cart.CartRepository;

/**
 * Created on 15-06-2018.
 */
public class AddToCartUseCase implements AddToCart {

    private final CartRepository mCartRepo;

    private AddToCartUseCase(final CartRepository cartRepository) {
        mCartRepo = cartRepository;
    }

    public static AddToCartUseCase newInstance(CartRepository cartRepository) {
        return new AddToCartUseCase(cartRepository);
    }

    @Override
    public void execute(final Integer prodId, final UseCaseDataReceiver<Boolean> useCaseDataReceiver) {
        final Boolean repositoryOutput = mCartRepo.addToCart(prodId);
        if (!repositoryOutput) {
            useCaseDataReceiver.onUseCaseDataReceivedFailed(new UseCaseError());
        } else {
            useCaseDataReceiver.onUseCaseDataReceived(repositoryOutput);
        }
    }

}
