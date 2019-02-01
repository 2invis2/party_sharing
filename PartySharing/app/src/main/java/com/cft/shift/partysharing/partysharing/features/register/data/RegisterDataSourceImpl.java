package com.cft.shift.partysharing.partysharing.features.register.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.DefaultCallback;
import com.cft.shift.partysharing.partysharing.network.ServerAPI;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterResponse;

public class RegisterDataSourceImpl implements RegisterDataSource{

    private final ServerAPI serverAPI;

    public RegisterDataSourceImpl(ServerAPI serverAPI) { this.serverAPI = serverAPI;}


    @Override
    public void register(RegisterRequest registerRequest, Carry<RegisterResponse> carry) {
        serverAPI.postRegistrationInfo(registerRequest).enqueue(new DefaultCallback<>(carry));
    }
}
