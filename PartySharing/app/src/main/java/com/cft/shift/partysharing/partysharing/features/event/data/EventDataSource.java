package com.cft.shift.partysharing.partysharing.features.event.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesResponse;

public interface EventDataSource {
    void getEvent(Carry<GetEventResponse> carry,GetEventRequest eventRequest);
    void getParticipants(Carry<GetProfilesResponse> carry,GetProfilesRequest getProfilesRequest);
}
