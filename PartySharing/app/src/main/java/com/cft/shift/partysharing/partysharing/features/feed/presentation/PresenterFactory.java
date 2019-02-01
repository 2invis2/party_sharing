package com.cft.shift.partysharing.partysharing.features.feed.presentation;

import android.content.Context;

import com.cft.shift.partysharing.partysharing.App;
import com.cft.shift.partysharing.partysharing.features.feed.data.FeedDataSource;
import com.cft.shift.partysharing.partysharing.features.feed.data.FeedDataSourceImpl;
import com.cft.shift.partysharing.partysharing.features.feed.domain.FeedInteractor;
import com.cft.shift.partysharing.partysharing.features.feed.domain.FeedInteractorImpl;
import com.cft.shift.partysharing.partysharing.network.ServerAPI;


final class PresenterFactory {

    static FeedPresenter createPresenter(Context context) {
        final ServerAPI api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(ServerAPI.class);

        final FeedDataSource dataSource = new FeedDataSourceImpl(api);
        final FeedInteractor interactor = new FeedInteractorImpl(dataSource);

        return new FeedPresenter(interactor);
    }

}