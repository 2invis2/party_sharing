package com.cft.shift.partysharing.partysharing.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.cft.shift.partysharing.partysharing.features.event.domain.model.Event;
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
    Call<FeedResponse> getFeed();

    @GET("/profile")
    Call<GetProfileResponse> getProfile(@Body GetProfileRequest getProfileRequest);

    @GET("/profiles")
    Call<GetProfilesResponse> getProfiles(@Body GetProfilesRequest getProfilesRequest);

    @GET("/event")
    Call<AddEventResponse> getEvent(@Body AddEventRequest addEventRequest);

    @GET("/event")
    Call<GetEventResponse> getEvent(@Body GetEventRequest getEventRequest);

    @GET("/events")
    Call<GetAllEventsResponse> getEventList();

    @POST("/request")
    Call<Response> postEventRequest(@Body PartRequest partRequest);

    @POST("/invite")
    Call<Response> postInviteRequest(@Body InviteRequest inviteRequest);

    @POST("/accept")
    Call<Response> postAcceptRequest(@Body AcceptRequest acceptRequest);

    @POST("/confirm")
    Call<Response> postConfirmRequest(@Body ConfirmRequest confirmRequest);


}
