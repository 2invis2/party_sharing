package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import android.content.Context;

import com.cft.shift.partysharing.partysharing.App;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.profile.data.ProfileApi;
import com.cft.shift.partysharing.partysharing.features.profile.data.ProfileDataSource;
import com.cft.shift.partysharing.partysharing.features.profile.data.ProfileDataSourceImp;
import com.cft.shift.partysharing.partysharing.features.profile.domain.model.Profile;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.DefaultCallback;
import com.cft.shift.partysharing.partysharing.network.exchange.EventPreview;

import java.util.List;
import java.util.UUID;

public class ProfilePresenter extends MvpPresenter<ProfileView> {
    private static ProfileApi profileApi;
    private static Profile profile;
    private static List<EventPreview> eventPreviews;
    private static Context context;

    public void ProfilePresenter(Context context) {
        ProfilePresenter.context = context;
        profileApi = App.getRetrofitProvider(context).getRetrofit().create(ProfileApi.class);
    }
    //Показывает профиль на экране
    public static Profile getProfile(Long id, Carry<Profile> carry) {
        ProfileDataSourceImp profileDataSourceImp = new ProfileDataSourceImp(profileApi);
        profile = profileDataSourceImp.getProfile();
        return profile;
    }

    public static List<EventPreview> getEventPreviews()
}
