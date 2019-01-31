package com.cft.shift.partysharing.partysharing.features.profile.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

public interface ProfileDataSource {

    void getProfile(Carry<GetProfileResponse> carry,GetProfileRequest getProfileRequest);
    void getEvents(Carry<GetAllEventsResponse> carry);
}