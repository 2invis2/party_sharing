package com.cft.shift.partysharing.partysharing.features.event.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.DefaultCallback;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesResponse;

public class EventDataSourceImpl implements EventDataSource{
    private final  EventsApi eventsapi;
    public EventDataSourceImpl(EventsApi eventsApi) {
        this.eventsapi = eventsApi;
    }
    @Override
    public void getEvent(Carry<GetEventResponse> carry, GetEventRequest eventRequest) {
        eventsapi.getEvent(eventRequest).enqueue(new DefaultCallback<GetEventResponse>(carry));
    }
    @Override
    public void getParticipants(Carry<GetProfilesResponse> carry, GetProfilesRequest getProfilesRequest) {
        eventsapi.getProfiles(getProfilesRequest).enqueue(new DefaultCallback<GetProfilesResponse>(carry));

    }
}
