package com.thoughtworks.domain.cart.usecases;

import com.thoughtworks.domain.UseCaseDataReceiver;
import com.thoughtworks.domain.UseCaseError;
import com.thoughtworks.domain.cart.CartRepository;

/**
 * Created on 16-06-2018.
 */
public final class GetProductFromCartIdUseCase
        implements GetProductFromCartId {

    private final CartRepository mCartRepo;

    private GetProductFromCartIdUseCase(final CartRepository cartRepository) {
        mCartRepo = cartRepository;
    }

    public static GetProductFromCartIdUseCase newInstance(CartRepository cartRepository) {
        return new GetProductFromCartIdUseCase(cartRepository);
    }

    @Override
    public void execute(final Integer input, final UseCaseDataReceiver<Integer> useCaseDataReceiver) {
        final Integer result = mCartRepo.getProductIdFromCartId(input);
        if (result == null) {
            useCaseDataReceiver.onUseCaseDataReceivedFailed(new UseCaseError());
        } else {
            useCaseDataReceiver.onUseCaseDataReceived(result);
        }
    }
}
