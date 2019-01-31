package com.cft.shift.partysharing.partysharing.features.profile.data;

import android.content.Context;

import com.cft.shift.partysharing.partysharing.features.profile.domain.model.Profile;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

public interface ProfileDataSource {

    Profile getProfile(Carry<GetProfileResponse> carry, Long id, GetProfileRequest getProfileRequest,final Context context);
    void getEvents(Carry<GetAllEventsResponse> carry,final Context context);
}
