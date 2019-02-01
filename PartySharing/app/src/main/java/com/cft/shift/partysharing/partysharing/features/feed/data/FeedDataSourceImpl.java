package com.cft.shift.partysharing.partysharing.features.feed.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.DefaultCallback;
import com.cft.shift.partysharing.partysharing.network.ServerAPI;
import com.cft.shift.partysharing.partysharing.network.exchange.FeedResponse;

public class FeedDataSourceImpl implements FeedDataSource {

    private final ServerAPI serverAPI;

    public FeedDataSourceImpl(ServerAPI serverAPI) { this.serverAPI = serverAPI;}

    @Override
    public void loadFeed(Carry<FeedResponse> carry) {
        serverAPI.getFeed().enqueue(new DefaultCallback(carry));
    }
}
