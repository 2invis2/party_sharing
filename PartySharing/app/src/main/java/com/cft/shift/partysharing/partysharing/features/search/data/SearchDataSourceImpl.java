package com.cft.shift.partysharing.partysharing.features.search.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.DefaultCallback;
import com.cft.shift.partysharing.partysharing.network.ServerAPI;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;

public class SearchDataSourceImpl implements SearchDataSource{
    private final ServerAPI serverAPI;

    public SearchDataSourceImpl(ServerAPI serverAPI) {
        this.serverAPI = serverAPI;
    }

    @Override
    public void loadSearch(Long id, Carry<GetAllEventsResponse> carry) {
        serverAPI.getEventList(id).enqueue(new DefaultCallback<>(carry));
    }
}
