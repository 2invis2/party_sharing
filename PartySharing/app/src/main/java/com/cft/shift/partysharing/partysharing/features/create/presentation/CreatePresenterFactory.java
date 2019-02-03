package com.cft.shift.partysharing.partysharing.features.create.presentation;

import android.content.Context;

import com.cft.shift.partysharing.partysharing.App;
import com.cft.shift.partysharing.partysharing.features.create.domain.CreateInteractor;
import com.cft.shift.partysharing.partysharing.features.create.domain.CreateInteractorImpl;

import com.cft.shift.partysharing.partysharing.network.ServerAPI;

class CreatePresenterFactory {
    static CreatePresenter createPresenter(Context context) {
        final ServerAPI api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ServerAPI.class);

        CreateInteractor interactor = new CreateInteractorImpl(api);
        return new CreatePresenter(interactor);
    }
}
