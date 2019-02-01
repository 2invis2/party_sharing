package com.cft.shift.partysharing.partysharing.features.create.domain;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.DefaultCallback;
import com.cft.shift.partysharing.partysharing.network.ServerAPI;
import com.cft.shift.partysharing.partysharing.network.exchange.AddEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.AddEventResponse;

public class CreateInteractorImpl implements CreateInteractor {

    ServerAPI serverAPI;

    public CreateInteractorImpl(ServerAPI serverAPI) {
        this.serverAPI = serverAPI;
    }

    @Override
    public void create(Long id, AddEventRequest request, Carry<AddEventResponse> carry) {
        serverAPI.addEventRequest(id, request).enqueue(new DefaultCallback<>(carry));
    }

}
