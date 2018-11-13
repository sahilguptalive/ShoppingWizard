package com.thoughtworks.domain.product_detail.usecases;

import com.thoughtworks.domain.UseCaseDataReceiver;
import com.thoughtworks.domain.UseCaseError;
import com.thoughtworks.domain.product_detail.Product;
import com.thoughtworks.domain.product_list.ProductRepository;

/**
 * Created on 12-06-2018.
 */
public class GetProductDetailsUseCase implements GetProductDetails {

    private final ProductRepository mProductRepository;

    public static GetProductDetails newInstance(ProductRepository productRepository) {
        return new GetProductDetailsUseCase(productRepository);
    }

    private GetProductDetailsUseCase(final ProductRepository productRepository) {
        mProductRepository = productRepository;
    }

    @Override
    public void execute(final Integer prodId, final UseCaseDataReceiver<Product> useCaseDataReceiver) {
        final Product repositoryOutput = mProductRepository.getProduct(prodId);
        if (repositoryOutput == null) {
            useCaseDataReceiver.onUseCaseDataReceivedFailed(new UseCaseError());
        } else {
            useCaseDataReceiver.onUseCaseDataReceived(repositoryOutput);
        }
    }
}
