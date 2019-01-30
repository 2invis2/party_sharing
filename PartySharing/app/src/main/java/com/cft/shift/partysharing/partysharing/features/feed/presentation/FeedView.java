package com.cft.shift.partysharing.partysharing.features.feed.presentation;

import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.feed.domain.model.Event;

import java.util.List;


public interface FeedView extends MvpView {

    //void showProgress();

    //void hideProgress();

    void showEventList(List<Event> list);

    void showError(String message);
}
