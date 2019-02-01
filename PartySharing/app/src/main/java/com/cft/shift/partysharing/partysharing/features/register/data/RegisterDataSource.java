package com.cft.shift.partysharing.partysharing.features.register.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterResponse;

public interface RegisterDataSource {

    void register(RegisterRequest registerRequest, Carry<RegisterResponse> carry);

}
