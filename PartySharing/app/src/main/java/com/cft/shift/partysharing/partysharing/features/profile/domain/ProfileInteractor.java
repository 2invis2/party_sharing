package com.cft.shift.partysharing.partysharing.features.profile.domain;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

public interface ProfileInteractor {
    void loadProfile(Carry<GetProfileResponse> carry, GetProfileRequest getProfileRequest);
    void loadEvents(Carry<GetAllEventsResponse> carry);
}
