package com.cft.shift.partysharing.partysharing.features.register.domain;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterResponse;

public interface RegisterInteractor {

    void register(RegisterRequest registerRequest, Carry<RegisterResponse> carry);



}
