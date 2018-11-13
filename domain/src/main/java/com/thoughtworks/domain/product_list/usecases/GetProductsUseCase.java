package com.thoughtworks.domain.product_list.usecases;

import com.thoughtworks.domain.UseCaseDataReceiver;
import com.thoughtworks.domain.UseCaseError;
import com.thoughtworks.domain.product_list.ProductList;
import com.thoughtworks.domain.product_list.ProductRepository;

/**
 * Created on 12-06-2018.
 */
public class GetProductsUseCase implements GetProducts {

    private final ProductRepository mProductRepository;

    public static GetProducts newInstance(ProductRepository productRepository) {
        return new GetProductsUseCase(productRepository);
    }

    private GetProductsUseCase(final ProductRepository productRepository) {
        mProductRepository = productRepository;
    }

    @Override
    public void execute(final GetProducts.Category input, final UseCaseDataReceiver<ProductList> useCaseDataReceiver) {
        final ProductList repositoryOutput = mProductRepository.getProducts(input);
        if (repositoryOutput == null) {
            useCaseDataReceiver.onUseCaseDataReceivedFailed(new UseCaseError());
        } else {
            useCaseDataReceiver.onUseCaseDataReceived(repositoryOutput);
        }
    }
}
