package com.cft.shift.partysharing.partysharing.features.profile.data;

import android.content.Context;
import android.widget.Toast;

import com.cft.shift.partysharing.partysharing.features.profile.domain.model.Profile;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.DefaultCallback;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

public class ProfileDataSourceImp implements ProfileDataSource {
    private final ProfileApi profileApi;

    public ProfileDataSourceImp(ProfileApi profileApi) {
        this.profileApi = profileApi;

    }

    @Override
    public Profile getProfile(final Carry<GetProfileResponse> carry, Long id, GetProfileRequest getProfileRequest, final Context context) {
        profileApi.getProfile(getProfileRequest).enqueue(new DefaultCallback<GetProfileResponse>(new Carry<GetProfileResponse>(){
            @Override
            public Profile onSuccess(GetProfileResponse result) {
                Profile profile = new Profile();


                return profile;

            }
            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(context,"FAIL IN ProfileResponse!",Toast.LENGTH_LONG).show();
            }
        }));
    }

    @Override
    public void getEvents(Carry<GetAllEventsResponse> carry, final Context context) {
        profileApi.getEventList().enqueue(new DefaultCallback<GetAllEventsResponse>(new Carry<GetAllEventsResponse>(){
            @Override
            public Profile onSuccess(GetAllEventsResponse result) {

                return null;
            }
            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(context,"FAIL IN EventResponse!",Toast.LENGTH_LONG).show();
            }
        }));


    }
}



