package com.cft.shift.partysharing.partysharing.features.create.domain;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.AddEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.AddEventResponse;

public interface CreateInteractor {

    public void create(Long id, AddEventRequest request, Carry<AddEventResponse> carry);

}
