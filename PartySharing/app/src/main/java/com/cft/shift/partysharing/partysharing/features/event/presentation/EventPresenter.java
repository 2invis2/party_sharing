package com.cft.shift.partysharing.partysharing.features.event.presentation;

import android.graphics.Bitmap;

import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.event.domain.EventInteractor;
import com.cft.shift.partysharing.partysharing.features.event.domain.model.Event;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesResponse;
import com.cft.shift.partysharing.partysharing.util.Converter;

public class EventPresenter extends MvpPresenter<EventView> {
    private final EventInteractor eventInteractor;
    EventPresenter(EventInteractor eventInteractor) {
        this.eventInteractor=eventInteractor;
    }

    protected void onViewMyEvent(){
        getEvent();
    }

    private void getEvent(){
        //Временно поставил getEventRequest = null потом пропишу
        GetEventRequest getEventRequest = null;
        eventInteractor.loadEvent(new Carry<GetEventResponse>() {
            @Override
            public void onSuccess(GetEventResponse result) {
                Bitmap image = Converter.base64ToBitmap(result.getImage());
                Event event = new Event(result.getName(),result.getLocation(),result.getAddress()
                        ,result.getDate(),result.getCategory(),result.getCreatorId(),result.getAttend(),image);
                view.showEvent(event);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError("You Have Fail in loadEvents!");
            }
        },getEventRequest);
    }

    public void getParticipants(){
        //  getProfilesRequest должен браться из ответа на запрос выше
        GetProfilesRequest getProfilesRequest = null;
        eventInteractor.loadParticipants(new Carry<GetProfilesResponse>() {
            @Override
            public void onSuccess(GetProfilesResponse result) {
                view.showParticipants(result.getCount(),result.getProfiles());
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError("You Have Fail in getParticuoanst!");

            }
        },getProfilesRequest);
    }
}
