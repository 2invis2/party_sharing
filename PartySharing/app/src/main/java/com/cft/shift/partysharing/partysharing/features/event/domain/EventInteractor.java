package com.cft.shift.partysharing.partysharing.features.event.domain;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesResponse;

public interface EventInteractor  {
    void loadEvent(Carry<GetEventResponse> carry, GetEventRequest getEventRequest);
    void loadParticipants(Carry<GetProfilesResponse> carry, GetProfilesRequest getProfilesRequest);
}
