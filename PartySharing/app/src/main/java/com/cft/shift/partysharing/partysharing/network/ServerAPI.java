package com.cft.shift.partysharing.partysharing.network;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

import com.cft.shift.partysharing.partysharing.network.exchange.AcceptRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.AddEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.AddEventResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.ConfirmRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.FeedResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetEventResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfilesResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.InviteRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.PartRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterResponse;


public interface ServerAPI {
    @POST("/register")
    Call<RegisterResponse> postRegistrationInfo(@Body RegisterRequest registerRequest);

    @GET("/feed")
    Call<FeedResponse> getFeed(@Header("Authorization") Long id);

    @GET("/profile")
    Call<GetProfileResponse> getProfile(@Header("Authorization") Long id, @Body GetProfileRequest getProfileRequest);

    @GET("/profiles")
    Call<GetProfilesResponse> getProfiles(@Header("Authorization") Long id, @Body GetProfilesRequest getProfilesRequest);

    @GET("/event")
    Call<AddEventResponse> getEvent(@Header("Authorization") Long id, @Body AddEventRequest addEventRequest);

    @GET("/event")
    Call<GetEventResponse> getEvent(@Header("Authorization") Long id, @Body GetEventRequest getEventRequest);

    @GET("/events")
    Call<GetAllEventsResponse> getEventList(@Header("Authorization") Long id);

    @POST("/request")
    Call<Response> partEventRequest(@Header("Authorization") Long id, @Body PartRequest partRequest);

    @POST("/invite")
    Call<Response> postInviteRequest(@Header("Authorization") Long id, @Body InviteRequest inviteRequest);

    @POST("/accept")
    Call<Response> postAcceptRequest(@Header("Authorization") Long id, @Body AcceptRequest acceptRequest);

    @POST("/confirm")
    Call<Response> postConfirmRequest(@Header("Authorization") Long id, @Body ConfirmRequest confirmRequest);

    @POST("/event")
    Call<AddEventResponse> addEventRequest(@Header("Authorization") Long id, @Body AddEventRequest addEventRequest);

}
