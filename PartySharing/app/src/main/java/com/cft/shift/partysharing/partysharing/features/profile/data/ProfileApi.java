package com.cft.shift.partysharing.partysharing.features.profile.data;

import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventsListRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventsListResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ProfileApi {
    @GET("/profile")
    Call<GetProfileResponse> getProfile(@Body GetProfileRequest getProfileRequest);

    @GET("/events")
    Call<GetAllEventsResponse> getAllEventList();

    @GET("/events")
    Call<GetEventsListResponse> getEventList(@Body GetEventsListRequest getEventsListRequest);

}
