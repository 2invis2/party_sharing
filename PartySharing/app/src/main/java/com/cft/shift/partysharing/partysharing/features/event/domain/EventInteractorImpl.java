package com.cft.shift.partysharing.partysharing.features.event.domain;

import com.cft.shift.partysharing.partysharing.features.event.data.EventDataSource;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesResponse;

//Обращаемся к API модели Event
public class EventInteractorImpl implements EventInteractor {
    private final EventDataSource eventDataSource;

    public EventInteractorImpl(EventDataSource eventDataSource) {
        this.eventDataSource = eventDataSource;
    }

    @Override
    public void loadEvent(Carry<GetEventResponse> carry, GetEventRequest getEventRequest) {
        eventDataSource.getEvent(carry,getEventRequest);
    }

    @Override
    public void loadParticipants(Carry<GetProfilesResponse> carry, GetProfilesRequest getProfilesRequest) {
        eventDataSource.getParticipants(carry, getProfilesRequest);
    }
}
