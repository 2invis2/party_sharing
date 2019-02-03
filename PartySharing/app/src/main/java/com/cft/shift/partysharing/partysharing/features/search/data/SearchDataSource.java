package com.cft.shift.partysharing.partysharing.features.search.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;

public interface SearchDataSource {
    void loadSearch(Long id, Carry<GetAllEventsResponse> carry);
}
