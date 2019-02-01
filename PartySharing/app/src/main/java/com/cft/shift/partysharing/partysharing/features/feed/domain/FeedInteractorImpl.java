package com.cft.shift.partysharing.partysharing.features.feed.domain;

import com.cft.shift.partysharing.partysharing.features.feed.data.FeedDataSource;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.FeedResponse;

public class FeedInteractorImpl implements FeedInteractor{

    private final FeedDataSource dataSource;

    public FeedInteractorImpl(FeedDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void loadFeed(Carry<FeedResponse> carry) {
        dataSource.loadFeed(carry);
    }
}
