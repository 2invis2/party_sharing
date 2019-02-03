package com.cft.shift.partysharing.partysharing.features.search.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.BaseActivity;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.create.presentation.CreateEventActivity;
import com.cft.shift.partysharing.partysharing.features.event.presentation.EventActivity;
import com.cft.shift.partysharing.partysharing.features.feed.presentation.FeedActivity;
import com.cft.shift.partysharing.partysharing.features.feed.presentation.FeedListAdapter;
import com.cft.shift.partysharing.partysharing.features.profile.presentation.ProfileActivity;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.util.IdSaver;

public class SearchActivity extends BaseActivity implements SearchActivityView {

    private SearchPresenter presenter;
    private ListView mListSearch;
    private SearchView mSearchView;
    private GetAllEventsResponse mLoadedSearchList;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_feed:
                    Intent intent1 = new Intent(SearchActivity.this, FeedActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_search:
                    return true;
                case R.id.navigation_create:
                    Intent intent2 = new Intent(SearchActivity.this, CreateEventActivity.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_profile:
                    Intent intent3 = new Intent(SearchActivity.this, ProfileActivity.class);
                    startActivity(intent3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initView();
    }

    private void initView() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mSearchView = findViewById(R.id.searchView);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                presenter.editTextSearch(mLoadedSearchList, s);
                return false;
            }
        });
        loadSearch(IdSaver.getId(this));
    }

    private void loadSearch(Long id) {
        presenter.loadSearch(id);
    }

    @Override
    protected MvpPresenter<SearchActivityView> getPresenter() {
        presenter = PresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected <T extends MvpView> T getMvpView() {
        return null;
    }

    @Override
    public void showEventList(GetAllEventsResponse list) {
        FeedListAdapter mFeedListAdapter = new FeedListAdapter(this, list.getEvents());

        mLoadedSearchList = list;

        mListSearch = findViewById(R.id.list_feed);
        mListSearch.setAdapter(mFeedListAdapter);
        mListSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(SearchActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showError(String message) {

    }
}
