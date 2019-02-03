package com.cft.shift.partysharing.partysharing.features.search.presentation;

import android.content.Context;

import com.cft.shift.partysharing.partysharing.App;
import com.cft.shift.partysharing.partysharing.features.search.data.SearchDataSource;
import com.cft.shift.partysharing.partysharing.features.search.data.SearchDataSourceImpl;
import com.cft.shift.partysharing.partysharing.features.search.domain.SearchInteractor;
import com.cft.shift.partysharing.partysharing.features.search.domain.SearchInteractorImpl;
import com.cft.shift.partysharing.partysharing.network.ServerAPI;

final class PresenterFactory {

    static SearchPresenter createPresenter(Context context) {
        final ServerAPI api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ServerAPI.class);

        final SearchDataSource dataSource = new SearchDataSourceImpl(api);
        final SearchInteractor interactor = new SearchInteractorImpl(dataSource);

        return new SearchPresenter(interactor);
    }

}
