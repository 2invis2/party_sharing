package com.cft.shift.partysharing.partysharing.features.register.domain;

import com.cft.shift.partysharing.partysharing.features.register.data.RegisterDataSource;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterResponse;

public class RegisterInteractorImpl implements RegisterInteractor{

    RegisterDataSource registerDataSource;

    public RegisterInteractorImpl(RegisterDataSource registerDataSource) {
        this.registerDataSource = registerDataSource;
    }

    @Override
    public void register(RegisterRequest registerRequest, Carry<RegisterResponse> carry) {
        registerDataSource.register(registerRequest, carry);
    }
}
