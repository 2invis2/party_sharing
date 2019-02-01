package com.cft.shift.partysharing.partysharing.features.feed.presentation;

import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.network.exchange.FeedResponse;


public interface FeedView extends MvpView {

    //void showProgress();

    //void hideProgress();

    void showEventList(FeedResponse list);

    void showError(String message);
}
