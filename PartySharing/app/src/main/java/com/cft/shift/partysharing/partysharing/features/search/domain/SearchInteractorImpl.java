package com.cft.shift.partysharing.partysharing.features.search.domain;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.cft.shift.partysharing.partysharing.features.search.data.SearchDataSource;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.EventPreview;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;

import java.net.ProxySelector;
import java.nio.channels.Selector;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchInteractorImpl implements SearchInteractor{
    private final SearchDataSource dataSource;

    public SearchInteractorImpl(SearchDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void loadSearch(Carry<GetAllEventsResponse> carry) {
        dataSource.loadSearch(carry);
    }

    @Override
    public void findEventByName(GetAllEventsResponse mLoadedSearchList, String s) {

    }

    /*@RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<EventPreview> findEventByName(GetAllEventsResponse mLoadedSearchList, final String s) {
        Predicate condition = new Predicate() {
            public boolean test(Object list) {
                return ((EventPreview)((GetAllEventsResponse)list).getEvents()).getName().equals(s);
            }
        };
        return CollectionUtils.select( mLoadedSearchList.getEvents(), condition );

        /*List<EventPreview> result = mLoadedSearchList.getEvents().stream()
                .filter(item -> item.getName().equals("three"))
                .collect(Collectors.toList());
    }*/

    @Override
    public void findEventByCategory(GetAllEventsResponse mLoadedSearchList, String s) {

    }
}
