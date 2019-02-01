package com.cft.shift.partysharing.partysharing.features.profile.domain;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventsListRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventsListResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

public interface ProfileInteractor {
    void loadProfile(Carry<GetProfileResponse> carry, GetProfileRequest getProfileRequest);
    void loadAttendEvents(Carry<GetEventsListResponse> carry, GetEventsListRequest getEventsListRequest);
    void loadManageEvents(Carry<GetEventsListResponse> carry, GetEventsListRequest getEventsListRequest);
}
