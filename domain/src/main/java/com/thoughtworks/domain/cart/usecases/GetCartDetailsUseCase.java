package com.thoughtworks.domain.cart.usecases;

import com.thoughtworks.domain.UseCaseDataReceiver;
import com.thoughtworks.domain.UseCaseError;
import com.thoughtworks.domain.cart.CartDetails;
import com.thoughtworks.domain.cart.CartRepository;

/**
 * Created on 15-06-2018.
 */
public class GetCartDetailsUseCase implements GetCartDetails {

    private final CartRepository mCartRepo;

    private GetCartDetailsUseCase(final CartRepository cartRepository) {
        mCartRepo = cartRepository;
    }

    public static GetCartDetailsUseCase newInstance(CartRepository cartRepository) {
        return new GetCartDetailsUseCase(cartRepository);
    }

    @Override
    public void execute(final Void input, final UseCaseDataReceiver<CartDetails> useCaseDataReceiver) {
        final CartDetails repositoryOutput = mCartRepo.getCartDetails();
        if (repositoryOutput == null) {
            useCaseDataReceiver.onUseCaseDataReceivedFailed(new UseCaseError());
        } else {
            useCaseDataReceiver.onUseCaseDataReceived(repositoryOutput);
        }
    }

}
