package com.cft.shift.partysharing.partysharing.features.event.presentation;

import android.content.Context;

import com.cft.shift.partysharing.partysharing.App;
import com.cft.shift.partysharing.partysharing.features.event.data.EventDataSource;
import com.cft.shift.partysharing.partysharing.features.event.data.EventDataSourceImpl;
import com.cft.shift.partysharing.partysharing.features.event.data.EventsApi;
import com.cft.shift.partysharing.partysharing.features.event.domain.EventInteractor;
import com.cft.shift.partysharing.partysharing.features.event.domain.EventInteractorImpl;

final public class PresenterEventFactory {
    static EventPresenter createProfilePresenter(Context context) {
        final EventsApi eventsApi = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(EventsApi.class);
        final EventDataSource dataSource = new EventDataSourceImpl(eventsApi);
        final EventInteractor eventInteractor = new EventInteractorImpl(dataSource);
        return new EventPresenter(eventInteractor);
    }
}
