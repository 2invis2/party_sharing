package com.cft.shift.partysharing.partysharing.features.event.presentation;

import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.event.domain.model.Event;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

import java.util.List;

public interface EventView extends MvpView {
    void showEvent(Event event);

    void showParticipants(int numPartic, List<GetProfileResponse> profiles);

    void showError(String message);
}
