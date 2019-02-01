package com.cft.shift.partysharing.partysharing.features.feed.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.FeedResponse;

public interface FeedDataSource {
    void loadFeed(Long id, Carry<FeedResponse> carry);
}
