package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import android.content.Context;

import com.cft.shift.partysharing.partysharing.App;
import com.cft.shift.partysharing.partysharing.features.profile.data.ProfileApi;
import com.cft.shift.partysharing.partysharing.features.profile.data.ProfileDataSource;
import com.cft.shift.partysharing.partysharing.features.profile.data.ProfileDataSourceImp;
import com.cft.shift.partysharing.partysharing.features.profile.domain.ProfileInteractor;
import com.cft.shift.partysharing.partysharing.features.profile.domain.ProfileInteractorImpl;

final public class PresenterProfileFactory {
    static ProfilePresenter createProfilePresenter(Context context) {
        final ProfileApi  profileApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ProfileApi.class);
        final ProfileDataSource dataSource = new ProfileDataSourceImp(profileApi);
        final ProfileInteractor profileInteractor = new ProfileInteractorImpl(dataSource);

        return new ProfilePresenter(profileInteractor);
    }

}
