package com.cft.shift.partysharing.partysharing.features.search.presentation;

import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.network.exchange.FeedResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;

public interface SearchActivityView extends MvpView {

    //void showProgress();

    //void hideProgress();

    void showEventList(GetAllEventsResponse list);

    void showError(String message);
}