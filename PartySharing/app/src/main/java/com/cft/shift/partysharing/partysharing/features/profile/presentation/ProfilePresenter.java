package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.profile.data.ProfileApi;
import com.cft.shift.partysharing.partysharing.features.profile.domain.model.Profile;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.DefaultCallback;

import java.util.UUID;

public class ProfilePresenter extends MvpPresenter<ProfileView> {
    private ProfileApi profileApi;

    public void ProfilePresenter(ProfileApi profileApi) {
        this.profileApi = profileApi;
    }

    public void getProfile(UUID id, Carry<Profile> carry) {
        profileApi.getProfile(id).enqueue(new DefaultCallback<>(carry));
    }



}
