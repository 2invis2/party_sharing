package com.cft.shift.partysharing.partysharing.features.profile.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.DefaultCallback;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventsListRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventsListResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

public class ProfileDataSourceImp implements ProfileDataSource {
    private final ProfileApi profileApi;

    public ProfileDataSourceImp(ProfileApi profileApi) {
        this.profileApi = profileApi;
    }
    @Override
    public void getProfile(final Carry<GetProfileResponse> carry, GetProfileRequest getProfileRequest) {
         profileApi.getProfile(getProfileRequest).enqueue(new DefaultCallback<GetProfileResponse>(carry));
    }
    @Override
    public void getEventsList(Carry<GetEventsListResponse> carry, GetEventsListRequest getEventsListRequest) {
        profileApi.getEventList(getEventsListRequest).enqueue(new DefaultCallback<GetEventsListResponse>(carry));
    }
}