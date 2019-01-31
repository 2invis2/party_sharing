package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.profile.domain.model.Profile;
import com.cft.shift.partysharing.partysharing.network.exchange.EventPreview;

import java.util.List;

public interface ProfileView extends MvpView {
    //void showProgress();

    //void hideProgress();
    void showEventsPreviw(int eventsNum, List<EventPreview> eventPreviews);
    void showProfile(Profile profile);

    void showError(String message);
}
