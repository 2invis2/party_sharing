package com.cft.shift.partysharing.partysharing.features.profile.data;

import com.cft.shift.partysharing.partysharing.features.profile.domain.model.Profile;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProfileApi {
    @GET("/profile")
    Call<GetProfileResponse> getProfile(GetProfileRequest getProfileRequest);

    @GET("/events")
    Call<GetAllEventsResponse> getEventList();

}
