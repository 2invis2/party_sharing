package com.cft.shift.partysharing.partysharing.features.register.presentation;

import android.content.Context;

import com.cft.shift.partysharing.partysharing.App;

import com.cft.shift.partysharing.partysharing.features.register.data.RegisterDataSource;
import com.cft.shift.partysharing.partysharing.features.register.data.RegisterDataSourceImpl;
import com.cft.shift.partysharing.partysharing.features.register.domain.RegisterInteractor;
import com.cft.shift.partysharing.partysharing.features.register.domain.RegisterInteractorImpl;
import com.cft.shift.partysharing.partysharing.network.ServerAPI;

public class RegisterPresenterFactory {

    static RegisterPresenter createPresenter(Context context) {
        final ServerAPI api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ServerAPI.class);

        final RegisterDataSource dataSource = new RegisterDataSourceImpl(api);
        final RegisterInteractor interactor = new RegisterInteractorImpl(dataSource);
        return new RegisterPresenter(interactor);
    }

}
