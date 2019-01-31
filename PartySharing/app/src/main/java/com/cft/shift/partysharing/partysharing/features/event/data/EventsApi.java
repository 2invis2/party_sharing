package com.cft.shift.partysharing.partysharing.features.event.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import com.cft.shift.partysharing.partysharing.features.event.domain.model.Event;

public interface EventsApi {
    @GET("/events")
    Call<List<Event>> getEventList();



}
