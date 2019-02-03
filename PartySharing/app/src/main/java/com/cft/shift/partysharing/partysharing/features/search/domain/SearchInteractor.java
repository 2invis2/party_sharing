package com.cft.shift.partysharing.partysharing.features.search.domain;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;

public interface SearchInteractor {
    void loadSearch(Carry<GetAllEventsResponse> carry);

    void findEventByName(GetAllEventsResponse mLoadedSearchList, String s);

    void findEventByCategory(GetAllEventsResponse mLoadedSearchList, String s);
}
