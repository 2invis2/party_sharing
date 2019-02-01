package com.cft.shift.partysharing.partysharing.features.feed.domain;



import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.FeedResponse;

public interface FeedInteractor {

    void loadFeed(Long id, Carry<FeedResponse> carry);
}
