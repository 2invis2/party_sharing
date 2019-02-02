package com.cft.shift.partysharing.partysharing.features.search.presentation;

import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.search.domain.SearchInteractor;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;

public class SearchPresenter extends MvpPresenter<SearchActivityView> {
    private final SearchInteractor interactor;

    SearchPresenter(SearchInteractor interactor) {
        this.interactor = interactor;
    }

    public void loadSearch() {
        interactor.loadSearch(new Carry<GetAllEventsResponse>() {

            @Override
            public void onSuccess(GetAllEventsResponse result) {
                view.showEventList(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }

        });
    }

    public void editTextSearch(GetAllEventsResponse mLoadedSearchList, String s) {
        interactor.findEventByName(mLoadedSearchList, s);
        interactor.findEventByCategory(mLoadedSearchList, s);
    }
}
