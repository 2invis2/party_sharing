package com.cft.shift.partysharing.partysharing.features.feed.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cft.shift.partysharing.partysharing.R;
import com.cft.shift.partysharing.partysharing.features.BaseActivity;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.MvpView;
import com.cft.shift.partysharing.partysharing.features.profile.presentation.CreateEventActivity;
import com.cft.shift.partysharing.partysharing.features.profile.presentation.ProfileActivity;
import com.cft.shift.partysharing.partysharing.network.exchange.FeedResponse;

public class PendingActivity extends BaseActivity implements FeedView {

    private ListView mListFeed;
    private FeedListAdapter mFeedListAdapter;
    private TabLayout.OnTabSelectedListener mOnTabSelectedListener = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition()) {
                case 0:
                    Intent intent = new Intent(PendingActivity.this, FeedActivity.class);
                    startActivity(intent);
                    return ;
                case 1:
                    return ;
            }
            return;
        }
        @Override
        public void onTabUnselected(TabLayout.Tab tab) {        }
        @Override
        public void onTabReselected(TabLayout.Tab tab) {        }
    };

    private FeedPresenter presenter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_feed:
                    return true;
                case R.id.navigation_search:
                    return true;
                case R.id.navigation_create:
                    Intent intent2 = new Intent(PendingActivity.this, CreateEventActivity.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_profile:
                    Intent intent3 = new Intent(PendingActivity.this, ProfileActivity.class);
                    startActivity(intent3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);

        initView();
    }

    private void initView(){
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(mOnTabSelectedListener);

        TextView text = findViewById(R.id.text_pending);
        text.setText("Pending");

        loadFeed();

    }

    private void loadFeed() {
        presenter.loadFeed();
    }

    @Override
    protected MvpPresenter<FeedView> getPresenter() {
        presenter = PresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected  MvpView getMvpView() {
        return this;
    }

    @Override
    public void showEventList(FeedResponse list) {
        FeedListAdapter mFeedListAdapter = new FeedListAdapter(this, list.getPending().getData());

        mListFeed = findViewById(R.id.list_pending);
        mListFeed.setAdapter(mFeedListAdapter);
    }

    @Override
    public void showError(String message) {
        Toast toast = Toast.makeText( this,  message, Toast.LENGTH_LONG);
        toast.show();

    }
}

