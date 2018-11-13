package com.thoughtworks.domain;

/**
 * Created on 12-06-2018.
 */
public interface BaseUseCase<I, O> {

    void execute(I input, UseCaseDataReceiver<O> useCaseDataReceiver);
}
