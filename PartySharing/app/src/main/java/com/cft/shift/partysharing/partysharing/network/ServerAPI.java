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
    Call<RegisterResponse> postRegistrationInfo(RegisterRequest registerRequest);

    @Headers({"Authorization: id"})
    @GET("/feed")
    Call<FeedResponse> getFeed();

    @Headers({"Authorization: id"})
    @GET("/profile")
    Call<GetProfileResponse> getProfile(GetProfileRequest getProfileRequest);

    @Headers({"Authorization: id"})
    @GET("/profiles")
    Call<GetProfilesResponse> getProfiles(GetProfilesRequest getProfilesRequest);

    @Headers({"Authorization: id"})
    @GET("/event")
    Call<AddEventResponse> getEvent(@Body AddEventRequest addEventRequest);

    @Headers({"Authorization: id"})
    @GET("/event")
    Call<GetEventResponse> getEvent(@Body GetEventRequest getEventRequest);

    @Headers({"Authorization: id"})
    @GET("/events")
    Call<GetAllEventsResponse> getEventList();

    @Headers({"Authorization: id"})
    @POST("/request")
    Call<Response> postEventRequest(@Body PartRequest partRequest);

    @Headers({"Authorization: id"})
    @POST("/invite")
    Call<Response> postInviteRequest(@Body InviteRequest inviteRequest);

    @Headers({"Authorization: id"})
    @POST("/accept")
    Call<Response> postAcceptRequest(@Body AcceptRequest acceptRequest);

    @Headers({"Authorization: id"})
    @POST("/confirm")
    Call<Response> postConfirmRequest(@Body ConfirmRequest confirmRequest);


}
