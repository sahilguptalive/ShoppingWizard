package com.thoughtworks.domain;


/**
 * Created on 12-06-2018.
 */
public interface UseCaseDataReceiver<O> {

    void onUseCaseDataReceived(O data);

    void onUseCaseDataReceivedFailed(UseCaseError error);
}
