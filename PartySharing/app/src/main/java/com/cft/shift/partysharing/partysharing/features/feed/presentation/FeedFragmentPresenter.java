package com.cft.shift.partysharing.partysharing.features.feed.presentation;

import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.feed.domain.FeedInteractor;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.FeedResponse;


public class FeedFragmentPresenter extends MvpPresenter<FeedView> {

    private final FeedInteractor interactor;

    FeedFragmentPresenter(FeedInteractor interactor) {
        this.interactor = interactor;
    }

    void loadFeed(){
        interactor.loadFeed(new Carry<FeedResponse>() {

            @Override
            public void onSuccess(FeedResponse result) {
                view.showEventList(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }

        });
    }
}
